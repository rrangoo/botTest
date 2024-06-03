package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @author Bazhov N.S.
 */
@RequiredArgsConstructor
@RestController
public class BaseController {

    private final Bot bot;

    @PostMapping("/")
    public void alert(@RequestBody Message message) throws TelegramApiException {
        bot.sendMessage(message);
    }
}
