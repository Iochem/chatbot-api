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
            input = scanner.nextLine().toLowerCase(); // Converte a entrada para minúsculas

            // Respostas pré-definidas
            if (input.contains("agendar") || input.contains("marcar") || input.contains("horário")) {
                System.out.println("🤖 Chatbot: Temos os seguintes dias e horários disponíveis:");
                for (String[] linha : escolher) { //For para percorrer a matrix
                    System.out.print(linha[0] + ": "); //Mostrar só os dias
                    for (int i = 1; i < linha.length; i++) {
                        System.out.print(linha[i] + " "); // Mostrar só os horários
                    }
                    System.out.println();
                }
                System.out.println("\nDigite um dia e horário (ex: 'Dia 3 14h00') para marcar: ");
                System.out.print("Você:");
                String escolha = scanner.nextLine().toLowerCase().trim();
                boolean encontrado = false;
                for(String[] linha : escolher){ // o for vai percorrer toda a matriz
                    String dia = linha[0].toLowerCase().trim();
                    for(int i = 1;i < linha.length; i++ ){
                        String hora = linha[i].toLowerCase().trim();
                        if (escolha.equals(dia + " " + hora)) {
                            encontrado = true;
                            break;//Sai do loop interno
                        }
                    }
                    if (encontrado) break; // Sai do for externo também
                }

                if (encontrado) {
                    System.out.println("✅ Agendamento confirmado para " + escolha);


                }else {
                    System.out.println("❌ Horário  ou dia não disponível.");
                }

            } else if (input.contains("preço") || input.contains("valor")) {
                System.out.println("🤖 Chatbot: os preços são: ");
                for (String num : corte) {
                    System.out.println(num);
                }
            }else{
                System.out.println("🤖 Chatbot: Desculpe, não entendi.");
            }


        }
        //scanner.close();
    }
}
