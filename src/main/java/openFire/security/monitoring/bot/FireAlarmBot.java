package openFire.security.monitoring.bot;

import openFire.security.monitoring.iroha.StateMonitoring;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class FireAlarmBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText() &&
                (update.getMessage().getText().toLowerCase().contains("status") ||
                        update.getMessage().getText().toLowerCase().contains("статус"))) {
            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText(StateMonitoring.checkCurrentState());
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        return "s7_chatbot";
    }

    @Override
    public String getBotToken() {
        return "334704612:AAHa-Ja69TnQUrtwneEGniP8dsTXSp9lLSg";
    }
}
