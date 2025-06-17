package com.seuprojeto.chatbot.controller;

import java.util.Scanner;

import com.seuprojeto.chatbot.entity.ClienteEntity;
import com.seuprojeto.chatbot.repository.ClienteRepository;
import com.seuprojeto.chatbot.repository.DadosRepository;
import com.seuprojeto.chatbot.service.AgendamentoService;
import com.seuprojeto.chatbot.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Component
//@RestController - futuramente
public class ChatbotController {
    private final Scanner scanner = new Scanner(System.in);

    private final DadosRepository dadosRepository;
    private final AgendamentoService agendamentoService;
    private final ClienteRepository clienteRepository;
    private final ClienteService clienteService;
    private final ClienteEntity clienteEntity;



    public void iniciarAtendimento() {
        System.out.println("🤖 Chatbot: Olá! Bem-vindo à barbearia.");
        System.out.println("Digite 'sair' caso queira encerrar o atendimento.");
        String input;

        while (true) {
            System.out.println("🤖 Chatbot: Como posso ajudar você?");
            System.out.print("Você: ");
            input = scanner.nextLine().toLowerCase().trim();

            if (input.contains("dia") || input.contains("hora") || input.contains("horário")) {
                mostrarDiasHorarios();
            } else if (input.contains("marcar") || input.contains("agendar")) {
                realizarAgendamento();
            } else if (input.contains("preço") || input.contains("valor")) {
                mostrarPrecos();
            } else if (input.contains("cancelar")) {
                cancelarAgendamento();
            } else if (input.contains("sair")) {
                sairAtendimento();
                break;
            } else {
                mensagemNaoEntendi();
            }
        }
    }

    // Métodos separados para cada funcionalidade

    private void mostrarDiasHorarios() {
        System.out.println("🤖 Chatbot: Temos os seguintes dias e horários disponíveis:");
        dadosRepository.mostrarDiasHorarios();
    }

    private void realizarAgendamento() {
        System.out.print("Informe seu nome: ");
        String nomeCliente = scanner.nextLine().trim().toLowerCase();

        while (true) {
            System.out.println("\nDigite um dia e horário (ex: 'Dia 3 14h00') para marcar  ");
            System.out.print("ou ('voltar') para retornar ao menu:");
            String escolha = scanner.nextLine().toLowerCase().trim();

            if (escolha.equals("voltar")) break;

            //Adicionar dados para os services validarem
            clienteService.validarCliente(nomeCliente, escolha);
            agendamentoService.validarDiaHorario(escolha);

            boolean validoHorario = agendamentoService.validarDiaHorario(escolha);
            boolean validoCliente = clienteService.validarCliente(nomeCliente, escolha);

            if (!validoCliente) {
                continue;
            }

            if (!validoHorario) {
                continue;
            }

            //Adicionar os dados as classes
            clienteEntity.setNome(nomeCliente);
            clienteEntity.setHorarioMarcado(escolha);
            clienteService.adicionarCliente(nomeCliente, escolha);
            System.out.println("✅ Agendamento confirmado para " + escolha);
            break;
        }
    }

    private void mostrarPrecos() {
        System.out.println("🤖 Chatbot: Os preços são:");
        dadosRepository.mostrarCortes();
    }

    private void cancelarAgendamento() {
        System.out.println("🤖 Chatbot: Informe o cliente e o horário agendado (Ex: Ana Dia 3 14h00):");
        String cancelarAgendamento = scanner.nextLine().toLowerCase().trim();

        boolean cancelamentoFeito = clienteService.verificarExistenciaAgendamento(cancelarAgendamento);
        // Se retornar true cancela
        if (cancelamentoFeito) {
            System.out.println("🤖 Chatbot: Agendamento " + cancelarAgendamento + " cancelado");
        } else {
            System.out.println("🤖 Chatbot: Agendamento não encontrado no sistema");
        }
    }

    private void sairAtendimento() {
        if (clienteEntity != null) {
            System.out.println("🤖 Chatbot: Até mais! Tenha um ótimo dia, " + clienteEntity.getNome());
        } else {
            System.out.println("🤖 Chatbot: Até mais! Tenha um ótimo dia!");
        }
        scanner.close();  // fecha o scanner corretamente
    }

    private void mensagemNaoEntendi() {
        System.out.println("🤖 Chatbot: Desculpe, não entendi. Pode reformular?");
    }
}

