package openFire.security.monitoring.iroha;

import openFire.security.monitoring.Receiver;
import openFire.security.monitoring.model.SensorParameter;
import openFire.security.monitoring.model.SensorTransaction;
import openFire.security.monitoring.model.VerifierTransaction;
import openFire.security.monitoring.model.sensorResponse.SensorStatusMap;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StateMonitoring {
    private static final Logger logger = Logger.getLogger(StateMonitoring.class.getName());

    public static final Double SMOKE_ALERT_VALUE = 100d;
    public static final Double TEMPERATURE_ALERT_VALUE = 30d;

    public static String checkSensorCurrentState() {
        Receiver receiver = null;
        try {
            receiver = new Receiver("192.168.1.227", 50051);
            SensorStatusMap sensorStatusMap = receiver.getUniqueSensorUpdates("sensorid@test");
            return sensorStatusMap.toString();
        } finally {
            try {
                if (receiver != null) {
                    receiver.shutdown();
                }
            } catch (InterruptedException e) {
                logger.warning("Can't send updates");
                e.printStackTrace();
            }
        }
    }

    public static List<SensorTransaction> getAllSensorValues(String sensorId) {
        Receiver receiver = null;
        try {
            receiver = new Receiver("192.168.1.227", 50051);

            List<SensorTransaction> sensorTransaction = receiver.getAllSensorUpdates();

            return sensorTransaction.stream().filter(t -> t.getSensorId().equals(sensorId)).limit(15).collect(Collectors.toList());
        } finally {
            try {
                if (receiver != null) {
                    receiver.shutdown();
                }
            } catch (InterruptedException e) {
                logger.warning("Can't send updates");
                e.printStackTrace();
            }
        }
    }

    public static List<VerifierTransaction> getAllVerifierValues(String verifierId) {
        Receiver receiver = null;
        try {
            receiver = new Receiver("192.168.1.227", 50051);

            List<VerifierTransaction> verifierTransactions = receiver.getAllVerifierUpdates(verifierId);

            return verifierTransactions.stream().filter(t -> t.getSrc_account_id().equals(verifierId)).limit(15).collect(Collectors.toList());
        } finally {
            try {
                if (receiver != null) {
                    receiver.shutdown();
                }
            } catch (InterruptedException e) {
                logger.warning("Can't send updates");
                e.printStackTrace();
            }
        }
    }


    public static List<SensorTransaction> getSensorValues(int intervalInMinutes) {
        Receiver receiver = null;
        try {
            receiver = new Receiver("192.168.1.227", 50051);

            List<SensorTransaction> sensorTransaction = receiver.getAllSensorUpdates();

            LocalDateTime localDateTime = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDateTime();
            return sensorTransaction.stream().filter(t -> t.getLocalDateTime().isAfter(localDateTime.minusMinutes(intervalInMinutes))).collect(Collectors.toList());
        } finally {
            try {
                if (receiver != null) {
                    receiver.shutdown();
                }
            } catch (InterruptedException e) {
                logger.warning("Can't send updates");
                e.printStackTrace();
            }
        }
    }

    public static List<VerifierTransaction> getVerifierValues(int intervalInMinutes) {
        Receiver receiver = null;
        try {
            receiver = new Receiver("192.168.1.227", 50051);

            List<VerifierTransaction> verifierTransactions = receiver.getAllVerifierUpdates("verifier@test");

            LocalDateTime localDateTime = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDateTime();
            return verifierTransactions.stream().filter(t -> t.getLocalDateTime().isAfter(localDateTime.minusMinutes(intervalInMinutes))).collect(Collectors.toList());
        } finally {
            try {
                if (receiver != null) {
                    receiver.shutdown();
                }
            } catch (InterruptedException e) {
                logger.warning("Can't send updates");
                e.printStackTrace();
            }
        }
    }

    public static String getSensorAlerts() {
        StringBuilder stringBuilder = new StringBuilder();
        List<SensorTransaction> sensorTransactions = getSensorValues(1);
        stringBuilder.append("Transactions for the last minute:\n");
        stringBuilder.append(sensorTransactions.toString() + "\n");

        final boolean[] alert = {false};

        sensorTransactions.stream().filter(t -> SensorParameter.Smoke.equals(t.getParameter())).forEach(t -> {
            if (t.getValue() >= SMOKE_ALERT_VALUE) {
                stringBuilder.append("ALERT! Smoke value is more then " + SMOKE_ALERT_VALUE + " for " + t.toString());
                alert[0] = true;
            }
        });

        sensorTransactions.stream().filter(t -> SensorParameter.Temperature.equals(t.getParameter())).forEach(t -> {
            if (t.getValue() >= TEMPERATURE_ALERT_VALUE) {
                stringBuilder.append("ALERT! Temperature value is more then " + TEMPERATURE_ALERT_VALUE + " for " + t.toString());
                alert[0] = true;
            }
        });

        sensorTransactions = getSensorValues(10);
        if (sensorTransactions.size() == 0) {
            stringBuilder.append("ALERT! No notifications from sensor for the last 10 minutes");
            alert[0] = true;
        }

        if (alert[0]) {
            return stringBuilder.toString();
        }
        return null;
    }

    public static String getVerifierAlerts() {
        StringBuilder stringBuilder = new StringBuilder();
        List<VerifierTransaction> verifierTransactions = getVerifierValues(1);
        stringBuilder.append("Verifier transactions for the last minute:\n");
        stringBuilder.append(verifierTransactions.toString() + "\n");

        final boolean[] alert = {false};

        verifierTransactions.stream().filter(t -> !t.getRunning()).forEach(t -> {
            stringBuilder.append("ALERT! Verifier " + t.getSrc_account_id() + " marked sensor " + t.getDest_account_id() + " as not running!");
            alert[0] = true;
        });

        verifierTransactions = getVerifierValues(60 * 24 * 7);
        if (verifierTransactions.size() == 0) {
            stringBuilder.append("ALERT! No notifications from verifier for the last week");
            alert[0] = true;
        }

        if (alert[0]) {
            return stringBuilder.toString();
        }
        return null;
    }

}
