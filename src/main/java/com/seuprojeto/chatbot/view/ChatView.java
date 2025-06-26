package com.seuprojeto.chatbot.view;

import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class ChatView {//Temporária
    //será responsável por interagir com o usuário: mostrar mensagens, ler input, imprimir menus etc.

    private final Scanner scanner = new Scanner(System.in);

    public String lerMensagem() {
        System.out.print("Você: ");
        return scanner.nextLine().trim().toLowerCase();
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println("🤖 Chatbot: " + mensagem);
    }

    public void mostrarMenu() {
        System.out.println("🤖 Chatbot: Digite 'sair' para encerrar o atendimento.");
        System.out.println("Como posso ajudar você?");
    }

    public void mensagemNaoEntendi(){
        System.out.println("🤖 Chatbot: Não entendi. Por favor, tente novamente.");
    }

    public void encerrarComAgendamento(String nomeAgendamento) {
        System.out.println("🤖 Chatbot: Até mais! Tenha um ótimo dia, " + nomeAgendamento);
    }

    public void encerrarSemAgendamento() {
        System.out.println("🤖 Chatbot: Até logo!");
    }

    public void fechamento(){
        scanner.close();
    }
}


