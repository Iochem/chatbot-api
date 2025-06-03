package com.seuprojeto.chatbot.entity;

import java.util.UUID;

import jakarta.persistence.Entity;

@Entity
public class ClienteEntity { //Classe que vai receber o nome e o horarioMarcado
    //@Id
    private final UUID id;
    private String nome;
    private String horarioMarcado;


    public ClienteEntity(String nomeCliente){
        this.id = UUID.randomUUID(); // Gera um ID único automaticamente
        this.nome = nomeCliente;
    }
    public String getNome(){
        return nome;
    }

    public void setNome(String nomeCliente){
        this.nome = nomeCliente;
    }

    public UUID getId() {
        return id;
    }

    public void setHorarioMarcado(String escolha){
        this.horarioMarcado = escolha;
    }
    public String getHorarioMarcado(){
        return horarioMarcado;
    }

}
