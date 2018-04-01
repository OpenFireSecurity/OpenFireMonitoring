package openFire.security.monitoring.bot;

import openFire.security.monitoring.bot.commands.*;
import openFire.security.monitoring.bot.services.Emoji;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

import static openFire.security.monitoring.bot.BuildVars.COMMANDS_TOKEN;
import static openFire.security.monitoring.bot.BuildVars.COMMANDS_USER;

public class CommandsHandler extends TelegramLongPollingCommandBot {

    public static final String LOGTAG = "UPDATESHANDLER";

    /**
     * Constructor.
     */
    public CommandsHandler() {
        register(new HelloCommand());
        register(new StartCommand());
        register(new StopCommand());
        HelpCommand helpCommand = new HelpCommand(this);
        register(helpCommand);
        StatusCommand statusCommand = new StatusCommand(this);
        register(statusCommand);
        LastUpdatesCommand lastUpdatesCommand = new LastUpdatesCommand(this);
        register(lastUpdatesCommand);

        registerDefaultAction((absSender, message) -> {
            SendMessage commandUnknownMessage = new SendMessage();
            commandUnknownMessage.setChatId(message.getChatId());
            commandUnknownMessage.setText("The command '" + message.getText() + "' is not known by this bot. Here comes some help " + Emoji.AMBULANCE);
            try {
                absSender.sendMessage(commandUnknownMessage);
            } catch (TelegramApiException e) {
                BotLogger.error(LOGTAG, e);
            }
            helpCommand.execute(absSender, message.getFrom(), message.getChat(), new String[]{});
        });
    }


    @Override
    public void processNonCommandUpdate(Update update) {

        if (update.hasMessage()) {
            Message message = update.getMessage();

//            if (!DatabaseManager.getInstance().getUserStateForCommandsBot(message.getFrom().getId())) {
//                return;
//            }

            if (message.hasText()) {
                SendMessage echoMessage = new SendMessage();
                echoMessage.setChatId(message.getChatId());
                echoMessage.setText("Hey heres your message:\n" + message.getText());

                try {
                    sendMessage(echoMessage);
                } catch (TelegramApiException e) {
                    BotLogger.error(LOGTAG, e);
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return COMMANDS_USER;
    }

    @Override
    public String getBotToken() {
        return COMMANDS_TOKEN;
    }
}