package openFire.security.monitoring;

import openFire.security.monitoring.bot.BotApiTools;
import openFire.security.monitoring.bot.FireAlarmBot;
import org.telegram.telegrambots.ApiContextInitializer;

public class Main {
    public static void main(String[] args) {
        ApiContextInitializer.init();

        BotApiTools botsApi = new BotApiTools();

        botsApi.registerBot(new FireAlarmBot());
    }
}
