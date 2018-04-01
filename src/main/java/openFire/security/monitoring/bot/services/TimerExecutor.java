package openFire.security.monitoring.bot.services;

import org.telegram.telegrambots.logging.BotLogger;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerExecutor {
    private static final String LOGTAG = "TIMEREXECUTOR";
    private static volatile TimerExecutor instance; ///< Instance
    private static final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1); ///< Thread to execute operations

    /**
     * Private constructor due to singleton
     */
    private TimerExecutor() {
    }

    /**
     * Singleton pattern
     *
     * @return Instance of the executor
     */
    public static TimerExecutor getInstance() {
        final TimerExecutor currentInstance;
        if (instance == null) {
            synchronized (TimerExecutor.class) {
                if (instance == null) {
                    instance = new TimerExecutor();
                }
                currentInstance = instance;
            }
        } else {
            currentInstance = instance;
        }

        return currentInstance;
    }

    /**
     * Add a new CustomTimerTask to be executed
     *
     * @param task       Task to execute
     * @param targetHour Hour to execute it
     * @param targetMin  Minute to execute it
     * @param targetSec  Second to execute it
     */
    public void startExecutionEveryMinuteAt(CustomTimerTask task, int targetHour, int targetMin, int targetSec) {
        BotLogger.warn(LOGTAG, "Posting new task" + task.getTaskName());
        final Runnable taskWrapper = () -> {
            try {
                task.execute();
                task.reduceTimes();
                startExecutionEveryMinuteAt(task, targetHour, targetMin, targetSec);
            } catch (Exception e) {
                BotLogger.severe(LOGTAG, "Bot threw an unexpected exception at TimerExecutor", e);
            }
        };
        if (task.getTimes() != 0) {
            final long delay = computNextDilay(targetHour, targetMin, targetSec);
            executorService.schedule(taskWrapper, delay, TimeUnit.SECONDS);
        }
    }

    /**
     * Find out next daily execution
     *
     * @param targetHour Target hour
     * @param targetMin  Target minute
     * @param targetSec  Target second
     * @return time in second to wait
     */
    private long computNextDilay(int targetHour, int targetMin, int targetSec) {
        return targetHour * 60 * 60 + targetMin * 60 + targetSec;
    }

    @Override
    public void finalize() {
        this.stop();
    }

    /**
     * Stop the thread
     */
    public void stop() {
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            BotLogger.severe(LOGTAG, ex);
        } catch (Exception e) {
            BotLogger.severe(LOGTAG, "Bot threw an unexpected exception at TimerExecutor", e);
        }
    }
}
