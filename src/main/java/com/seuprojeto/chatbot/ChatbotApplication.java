package com.seuprojeto.chatbot;

import com.seuprojeto.chatbot.controller.ChatbotController;

public class ChatbotApplication {
    public static void main(String[] args) {
        ChatbotController chatbotController = new ChatbotController();
        chatbotController.iniciarAtendimento();;
    }
}
