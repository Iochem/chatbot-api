package com.seuprojeto.chatbot;

import java.util.Scanner;

public class ChatbotApplication {
    public static void main(String[] args) {
        System.out.println("🤖 Chatbot: Olá! Como posso ajudar você?");
        System.out.println("Digite 'sair' caso queira encerrar o atendimento");

        //Iniciar o Scanner
        Scanner scanner = new Scanner(System.in);

        // Dados de horários disponíveis
        String[][] escolher = {
                {"Dia 3", "14h00", "15h00", "16h00"},
                {"Dia 6", "13h00", "14h10", "17h00"}
        };

        // Dados de preços dos cortes
        String[] corte = {
                "Corte simples: R$16,00",
                "Pezinho: R$10,00"
        };

        String input;

        while(true){
            System.out.print("Você: ");
            input = scanner.nextLine().toLowerCase();
            if (input.contains("agendar") || input.contains("marcar") || input.contains("horário")) {
                System.out.println("🤖 Chatbot: Temos os seguintes dias e horários disponíveis:");
                for (String[] linha : escolher) {
                    System.out.print(linha[0] + ": ");
                    for (int i = 1; i < linha.length; i++) {
                        System.out.print(linha[i] + " ");
                    }
                    System.out.println();
                }
            }
            // Aqui ainda não há respostas
            System.out.println("🤖 Chatbot: Desculpe, não entendi.");
        }



        //Fechar o Scanner
        scanner.close();
    }
}
