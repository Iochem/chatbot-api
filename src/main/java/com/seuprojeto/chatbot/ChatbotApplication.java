package com.seuprojeto.chatbot;

import com.seuprojeto.chatbot.controller.ChatbotController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

//Para não precisar de um banco de dados
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ChatbotApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ChatbotApplication.class, args);

        ChatbotController chatbot = context.getBean(ChatbotController.class);
        chatbot.iniciarAtendimento();
    }
}
