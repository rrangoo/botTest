package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * @author Bazhov N.S.
 */
@Component
public class Bot extends TelegramLongPollingBot {

    private Long id = 301653931L;

    public void sendMessage(Message message) throws TelegramApiException {
        StringBuilder sb = new StringBuilder();

        for (String flag : message.getType()) {
            sb.append(flag).append("\n");
        }

        sb.append(message.message);

        execute(SendMessage.builder().chatId(Long.valueOf(id)).text(sb.toString()).build());
    }

    @Override
    public void onUpdateReceived(Update update) {
        id = update.getMessage().getChatId();
    }

    @Override
    public String getBotUsername() {
        return "alert_test_defend_bot";
    }

    @Override
    public String getBotToken() {
        return "7288092202:AAGsCLyeK3VEP2Fsgbs4oLXJOf5icOaXgl0";
    }

    @PostConstruct
    public void registerBot() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(this);
        } catch (TelegramApiException e) {
        }
    }
}
