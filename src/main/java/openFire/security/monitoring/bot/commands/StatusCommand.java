package openFire.security.monitoring.bot.commands;

import openFire.security.monitoring.bot.database.DatabaseManager;
import openFire.security.monitoring.iroha.StateMonitoring;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.bots.commands.ICommandRegistry;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

public class StatusCommand extends BotCommand {

    private static final String LOGTAG = "STATUSCOMMAND";

    private final ICommandRegistry commandRegistry;

    public StatusCommand(ICommandRegistry commandRegistry) {
        super("status", "Get current sensor status");
        this.commandRegistry = commandRegistry;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage helpMessage = new SendMessage();
        helpMessage.setChatId(chat.getId().toString());
        helpMessage.enableHtml(true);
        helpMessage.setText(StateMonitoring.checkSensorCurrentState());

        try {
            absSender.sendMessage(helpMessage);
        } catch (TelegramApiException e) {
            BotLogger.error(LOGTAG, e);
        }
    }
}
