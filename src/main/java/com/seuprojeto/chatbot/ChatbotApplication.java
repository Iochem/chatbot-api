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

        System.out.print("Você: ");
        input = scanner.nextLine().toLowerCase();


        System.out.println("🤖 Chatbot: Desculpe, não entendi.");

        //Fechar o Scanner
        scanner.close();
    }
}
