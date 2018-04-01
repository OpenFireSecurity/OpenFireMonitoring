package openFire.security.monitoring.iroha;

import iroha.protocol.Responses;
import openFire.security.monitoring.Receiver;
import openFire.security.monitoring.examples.ReceiverExample;
import openFire.security.monitoring.sensorResponseModel.SensorStatusMap;

import java.util.logging.Logger;

public class StateMonitoring {
    private static final Logger logger = Logger.getLogger(StateMonitoring.class.getName());

    public static String checkCurrentState() {
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
}
