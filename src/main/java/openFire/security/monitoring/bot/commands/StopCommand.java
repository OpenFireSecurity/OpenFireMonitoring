package openFire.security.monitoring.bot.commands;

import openFire.security.monitoring.bot.database.DatabaseManager;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

public class StopCommand extends BotCommand {

    public static final String LOGTAG = "STOPCOMMAND";

    public StopCommand() {
        super("stop", "With this command you can stop the Bot");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        DatabaseManager dbManager = DatabaseManager.getInstance();

        try {
            dbManager.deleteUser(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String userName = user.getFirstName() + " " + (user.getLastName() != null ? user.getLastName() : "");

        SendMessage answer = new SendMessage();
        answer.setChatId(chat.getId().toString());
        answer.setText("Good bye " + userName + "\n" + "Hope to see you soon!");

        try {
            absSender.sendMessage(answer);
        } catch (TelegramApiException e) {
            BotLogger.error(LOGTAG, e);
        }
    }
}
