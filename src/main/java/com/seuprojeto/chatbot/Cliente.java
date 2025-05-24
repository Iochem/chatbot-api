package com.seuprojeto.chatbot;

public class Cliente {
    private String nome;
    private String  horarioMarcado;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeCliente) {
        this.nome = nomeCliente;
    }

    public String getHorarioMarcado() {
        return horarioMarcado;
    }

    public void setHorarioMarcado(String escolha) {
        this.horarioMarcado = escolha;
    }
}
