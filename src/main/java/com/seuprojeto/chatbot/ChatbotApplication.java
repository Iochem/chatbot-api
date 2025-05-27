package com.seuprojeto.chatbot;

import com.seuprojeto.chatbot.entity.ClienteEntity;
import com.seuprojeto.chatbot.repository.DadosRepository;
import java.util.Scanner;

public class ChatbotApplication {
    public static void main(String[] args) {
        System.out.println("🤖 Chatbot: Olá! Como posso ajudar você?");
        System.out.println("Digite 'sair' caso queira encerrar o atendimento");

        //Iniciar o Scanner
        Scanner scanner = new Scanner(System.in);


        //Cliente informa nome para o cadastro
        System.out.print("Digite seu nome: ");
        String nomeCliente = scanner.nextLine();

        //Criar o objeto de cliente
        ClienteEntity clienteEntity = new ClienteEntity(nomeCliente);

        //Intanciar a classe dados
        DadosRepository dadosRepository = new DadosRepository();


        System.out.println("🤖 Chatbot: Olá, " + nomeCliente + "! Em que posso ajudar?");
        System.out.println("Digite 'sair' caso queira encerrar o atendimento");

        String input;

        while(true){
            System.out.print("Você: ");
            input = scanner.nextLine().toLowerCase(); // Converte a entrada para minúsculas

            // Respostas pré-definidas
            if (input.contains("agendar") || input.contains("marcar") || input.contains("horário")) {
                System.out.println("🤖 Chatbot: Temos os seguintes dias e horários disponíveis:");
                dadosRepository.mostrarDiasHorarios();

                System.out.println("\nDigite um dia e horário (ex: 'Dia 3 14h00') para marcar: ");
                System.out.print("Você:");
                String escolha = scanner.nextLine().toLowerCase().trim();
                boolean encontrado = false;

                // trazer para aqui o DiaHorario
                for(String chave : dadosRepository.getDiaHorario().keySet()){
                    for(String valor : dadosRepository.getDiaHorario().get(chave)){
                        if(escolha.equalsIgnoreCase(chave + " " + valor)){
                            clienteEntity.setHorarioMarcado(escolha);
                            encontrado = true;
                            break;
                        }
                    }
                if (encontrado) break;
                }

                if (encontrado) {
                    System.out.println("✅ Agendamento confirmado para " + clienteEntity.getHorarioMarcado());
                }else {
                    System.out.println("❌ Horário  ou dia não disponível.");
                }

            } else if (input.contains("preço") || input.contains("valor") || input.contains("cortes")) {
                System.out.println("🤖 Chatbot: os preços são: ");
                dadosRepository.mostrarCortes();


            } else if (input.contains("tchau") || input.contains("sair")) {
                System.out.println("🤖 Chatbot: Até mais! Tenha um ótimo dia!" + clienteEntity.getNome());
                break;
            }
            else{
                System.out.println("🤖 Chatbot: Desculpe, não entendi.");
            }


        }
        //Fechar o scanner
        scanner.close();
    }
}
