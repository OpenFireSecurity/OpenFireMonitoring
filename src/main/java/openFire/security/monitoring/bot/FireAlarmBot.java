package openFire.security.monitoring.bot;

import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class FireAlarmBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
//            if ((update.getMessage().getText().toLowerCase().contains("status") ||
//                    update.getMessage().getText().toLowerCase().contains("статус"))) {
//                SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
//                        .setChatId(update.getMessage().getChatId())
//                        .setText(StateMonitoring.checkSensorCurrentState());
//                try {
//                    execute(message); // Call method to send the message
//                } catch (TelegramApiException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

    public String getBotUsername() {
        return BuildVars.COMMANDS_USER;
    }

    @Override
    public String getBotToken() {
        return BuildVars.COMMANDS_TOKEN;
    }
}
