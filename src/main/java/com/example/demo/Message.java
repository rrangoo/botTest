package com.example.demo;

import lombok.Data;

import java.util.List;

/**
 * @author Bazhov N.S.
 */
@Data
public class Message {
    List<String> type;
    String message;
}
