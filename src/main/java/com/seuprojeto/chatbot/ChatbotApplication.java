package com.seuprojeto.chatbot;

import com.seuprojeto.chatbot.entity.ClienteEntity;
import com.seuprojeto.chatbot.repository.ClienteRepository;
import com.seuprojeto.chatbot.repository.DadosRepository;
import com.seuprojeto.chatbot.service.AgendamentoService;
import com.seuprojeto.chatbot.service.ClienteService;

import java.util.Scanner;

public class ChatbotApplication {
    public static void main(String[] args) {
        System.out.println("🤖 Chatbot: Olá! Como posso ajudar você?");
        System.out.println("Digite 'sair' caso queira encerrar o atendimento");

        //Iniciar o Scanner
        Scanner scanner = new Scanner(System.in);

        //Iniciar a instanciação do ClienteEntity
        ClienteEntity clienteEntity = null;

        //Intanciar a classe dados
        DadosRepository dadosRepository = new DadosRepository();

        //Instanciar a classe AgendamentoService
        AgendamentoService agendamentoService = new AgendamentoService(dadosRepository);

        //Instanciar a classe ClienteRepository
        ClienteRepository clienteRepository = new ClienteRepository();

        //Instanciar a classe ClienteService
        ClienteService clienteService = new ClienteService(clienteRepository);


        System.out.println("🤖 Chatbot: Olá! Em que posso ajudar?");
        System.out.println("Digite 'sair' caso queira encerrar o atendimento");

        String input;

        while(true){
            System.out.print("Você: ");
            input = scanner.nextLine().toLowerCase(); // Converte a entrada para minúsculas

            // Respostas pré-definidas
            if (input.contains("dia") || input.contains("hora") || input.contains("horário")) {
                System.out.println("🤖 Chatbot: Temos os seguintes dias e horários disponíveis:");
                dadosRepository.mostrarDiasHorarios();

            }else if (input.contains("marcar") || input.contains("agendar")  ) {
                System.out.print("Informe seu nome: ");
                String nomeCliente = scanner.nextLine().trim().toLowerCase();

                //Verifica se o método do ClienteService retorna true
                while(true){
                    System.out.println("\nDigite um dia e horário (ex: 'Dia 3 14h00') para marcar (ou 'voltar') para retornar ao menu: ");
                    String escolha = scanner.nextLine().toLowerCase().trim();

                    if (escolha.equals("voltar")) break;

                    clienteService.validarCliente(nomeCliente, escolha);
                    agendamentoService.validarDiaHorario(escolha);
                    // 1º: Valida se o cliente já está agendado
                    boolean validoCliente = clienteService.validarCliente(nomeCliente, escolha);

                    if (!validoCliente) {
                        System.out.println("❌ Cliente ou horário já agendado.");
                        continue;
                    }

                    // 2º: Valida se o horário existe nos dados disponíveis
                    boolean validoHorario = agendamentoService.validarDiaHorario(escolha);

                    if (!validoHorario) {
                        System.out.println("❌ Horário indisponível.");
                        continue;
                    }

                    // 3º: Tudo certo, agenda
                    //Criar o objeto de ClienteEntity com o nome e esolha
                    clienteEntity = new ClienteEntity(nomeCliente);
                    clienteEntity.setHorarioMarcado(escolha);
                    clienteService.adicionarCliente(nomeCliente, escolha);

                    System.out.println("✅ Agendamento confirmado para " + clienteEntity.getHorarioMarcado());
                    break;
                }
            } else if (input.contains("cancelar")) {
                while (true){
                    //Para cancelar agendamento
                    System.out.println("🤖 Chatbot: Informe o cliente e o horário agendado (Ex: Ana Dia 3 14h00):");
                    System.out.println("ou ('voltar') para retornar ao menu:   ");
                    String cancelarAgendamento = scanner.nextLine().toLowerCase().trim();

                    if (cancelarAgendamento.equals("voltar")) break;


                    boolean cancelamentoFeito = clienteService.verificarExistenciaAgendamento(cancelarAgendamento);
                    // Se retornar true cancela
                    if (cancelamentoFeito) {
                        System.out.println("🤖 Chatbot: Agendamento " + cancelarAgendamento + " cancelado");
                        break; //Se encontrar cancela
                    } else {
                        System.out.println("🤖 Chatbot: Agendamento não encontrado no sistema");
                    }
                }
            } else if (input.contains("preço") || input.contains("valor") || input.contains("cortes")) {
                System.out.println("🤖 Chatbot: os preços são: ");
                dadosRepository.mostrarCortes();

            } else if (input.contains("tchau") || input.contains("sair")) {
                if (clienteEntity != null) {
                    System.out.println("🤖 Chatbot: Até mais! Tenha um ótimo dia, " + clienteEntity.getNome());
                } else {
                    System.out.println("🤖 Chatbot: Até mais! Tenha um ótimo dia!");
                }
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
