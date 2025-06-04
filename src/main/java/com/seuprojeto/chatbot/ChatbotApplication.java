package com.seuprojeto.chatbot;

import com.seuprojeto.chatbot.entity.ClienteEntity;
import com.seuprojeto.chatbot.repository.ClienteRepository;
import com.seuprojeto.chatbot.repository.DadosRepository;
import com.seuprojeto.chatbot.service.AgendamentoService;

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

        AgendamentoService agendamentoService = new AgendamentoService(dadosRepository);

        //Instanciar a classe ClienteRepository
        ClienteRepository clienteRepository = new ClienteRepository();



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
                agendamentoService.validarDiaHorario(escolha);
                boolean encontrado = agendamentoService.validarDiaHorario(escolha);

                if (encontrado) {
                    clienteEntity.setHorarioMarcado(escolha);
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
