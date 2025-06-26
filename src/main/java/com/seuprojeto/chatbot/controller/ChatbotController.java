package com.seuprojeto.chatbot.controller;

import java.util.Scanner;

import com.seuprojeto.chatbot.entity.ClienteEntity;
import com.seuprojeto.chatbot.repository.ClienteRepository;
import com.seuprojeto.chatbot.repository.DadosRepository;
import com.seuprojeto.chatbot.service.AgendamentoService;
import com.seuprojeto.chatbot.service.ClienteService;
import com.seuprojeto.chatbot.view.ChatView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Component
//@RestController - futuramente
public class ChatbotController {
    private final Scanner scanner = new Scanner(System.in);

    private String nomeAgendamento;

    //Instanciação dos objetos
    private final ChatView chatView;
    private final DadosRepository dadosRepository;
    private final AgendamentoService agendamentoService;
    private final ClienteRepository clienteRepository;
    private final ClienteService clienteService;
    private final ClienteEntity clienteEntity;


    public void iniciarAtendimento() {
        chatView.mostrarMensagem("Olá! Bem-vindo à barbearia.");

        while (true) {
            chatView.mostrarMenu();
            String input = chatView.lerMensagem();

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
                chatView.mensagemNaoEntendi();
            }
        }
    }

    // Métodos separados para cada funcionalidade

    private void mostrarDiasHorarios() {
        chatView.mostrarMensagem("Temos os seguintes dias e horários disponíveis:");
        dadosRepository.mostrarDiasHorarios();
    }

    private void realizarAgendamento() {
        chatView.mostrarMensagem("Informe seu nome: ");
        String nomeCliente = chatView.lerMensagem();

        while (true) {
            chatView.mostrarMensagem("Digite um dia e horário (ex: 'Dia 3 14h00') para marcar");
            chatView.mostrarMensagem("ou ('voltar') para retornar ao menu:");
            String escolha = chatView.lerMensagem();

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

            //Criar o objeto de ClienteService
            clienteEntity.setNome(nomeCliente);
            //Adicionar dados as classes
            clienteEntity.setHorarioMarcado(escolha);
            clienteService.adicionarCliente(nomeCliente, escolha);
            chatView.mostrarMensagem("✅ Agendamento confirmado para " + escolha);
            nomeAgendamento = nomeCliente;
            break;
        }
    }

    private void mostrarPrecos() {
        chatView.mostrarMensagem("Temos os segunites cortes disponíveis:");
        dadosRepository.mostrarCortes();
    }

    private void cancelarAgendamento() {
        chatView.mostrarMensagem("Informe o cliente e o horário agendado (Ex: Ana Dia 3 14h00):");
        String cancelarAgendamento = chatView.lerMensagem();

        boolean cancelamentoFeito = clienteService.verificarExistenciaAgendamento(cancelarAgendamento);
        // Se retornar true cancela
        if (cancelamentoFeito) {
            chatView.mostrarMensagem("Agendamento " + cancelarAgendamento + " cancelado");
        } else {
            chatView.mostrarMensagem("Agendamento não encontrado no sistema");
        }
    }

    private void sairAtendimento() {
        //chatView.encerrarComAgendamento(nomeAgendamento);
        if (clienteEntity != null) {
            chatView.encerrarComAgendamento(nomeAgendamento);
        } else {
            chatView.encerrarSemAgendamento();
        }
        chatView.fechamento();
    }
}


