package open.fire.security.monitoring.bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class BotApiTools {
    public BotApiTools() {
        ApiContextInitializer.init();
    }

    public TelegramBotsApi registerBot(TelegramLongPollingBot bot) {
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        return botsApi;
    }
}
