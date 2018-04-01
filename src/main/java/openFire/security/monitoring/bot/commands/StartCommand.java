package openFire.security.monitoring.bot.commands;

import com.mysql.cj.core.util.StringUtils;
import openFire.security.monitoring.bot.database.DatabaseManager;
import openFire.security.monitoring.bot.services.CustomTimerTask;
import openFire.security.monitoring.bot.services.TimerExecutor;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

import static openFire.security.monitoring.iroha.StateMonitoring.getSensorAlerts;
import static openFire.security.monitoring.iroha.StateMonitoring.getVerifierAlerts;

public class StartCommand extends BotCommand {

    public static final String LOGTAG = "STARTCOMMAND";

    public StartCommand() {
        super("start", "With this command you can start the Bot");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        DatabaseManager databseManager = DatabaseManager.getInstance();
        StringBuilder messageBuilder = new StringBuilder();

        String userName = user.getFirstName() + " " + (user.getLastName() != null ? user.getLastName() : "");

        if (databseManager.setNewUserForStartBot(user.getId(), user.getUserName())) {
            messageBuilder.append("Hi ").append(userName).append("\n");
            messageBuilder.append("i think we know each other already!");
        } else {
            messageBuilder.append("Welcome ").append(userName).append("\n");
            messageBuilder.append("this bot will update you about fire monitorings anf fire alarms");
        }

        SendMessage answer = new SendMessage();
        answer.setChatId(chat.getId().toString());
        answer.setText(messageBuilder.toString());

        try {
            absSender.sendMessage(answer);
        } catch (TelegramApiException e) {
            BotLogger.error(LOGTAG, e);
        }

        startAlertTimers(absSender, chat);
    }

    private void startAlertTimers(AbsSender absSender, Chat chat) {
        TimerExecutor.getInstance().startExecutionEveryMinuteAt(new CustomTimerTask("Alerts checker", -1) {
            @Override
            public void execute() {
                sendAlerts(absSender, chat);
            }
        }, 0, 0, 30);
    }

    public void sendAlerts(AbsSender absSender, Chat chat) {
        sendAlerts(getVerifierAlerts(), absSender, chat);
        sendAlerts(getSensorAlerts(), absSender, chat);
    }

    private void sendAlerts(String alerts, AbsSender absSender, Chat chat) {
        if (!StringUtils.isNullOrEmpty(alerts)) {
            SendMessage answer = new SendMessage();
            answer.setChatId(chat.getId().toString());
            answer.setText(alerts);

            try {
                absSender.sendMessage(answer);
            } catch (TelegramApiException e) {
                BotLogger.error(LOGTAG, e);
            }
        }
    }
}