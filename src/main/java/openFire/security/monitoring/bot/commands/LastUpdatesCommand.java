package openFire.security.monitoring.bot.commands;

import openFire.security.monitoring.iroha.StateMonitoring;
import openFire.security.monitoring.model.SensorTransaction;
import openFire.security.monitoring.model.VerifierTransaction;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.bots.commands.ICommandRegistry;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

import java.util.List;

public class LastUpdatesCommand extends BotCommand {

    private static final String LOGTAG = "LASTUPDATESCOMMAND";

    private final ICommandRegistry commandRegistry;

    public LastUpdatesCommand(ICommandRegistry commandRegistry) {
        super("lastUpdates", "Get all sensor measures. Set sensor and/or verifier identities with spaces");
        this.commandRegistry = commandRegistry;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage helpMessage = new SendMessage();
        helpMessage.setChatId(chat.getId().toString());
        helpMessage.enableHtml(true);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            List<SensorTransaction> sensorTransactions = StateMonitoring.getAllSensorValues(s);
            if (sensorTransactions.size() > 0) {
                stringBuilder.append(sensorTransactions.toString());
            }

            List<VerifierTransaction> verifierTransactions = StateMonitoring.getAllVerifierValues(s);
            if (verifierTransactions.size() > 0) {
                stringBuilder.append(verifierTransactions.toString());
            }
        }
        helpMessage.setText(stringBuilder.toString());

        try {
            absSender.sendMessage(helpMessage);
        } catch (TelegramApiException e) {
            BotLogger.error(LOGTAG, e);
        }
    }
}
