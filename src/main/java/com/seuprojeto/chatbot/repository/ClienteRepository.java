package com.seuprojeto.chatbot.repository;


import com.seuprojeto.chatbot.entity.ClienteEntity;

import java.util.Map;
import java.util.HashMap;

public class ClienteRepository {
    private final Map<String, String> clientesAgendados = new HashMap<>();
    private ClienteEntity clienteEntity;

    public ClienteRepository(){
        this.clienteEntity = clienteEntity;
    }

    public void agendarCliente(String nome, String horarioMarcado){
        clientesAgendados.put(nome, horarioMarcado);
    }

    // Opcional: retorna o mapa completo (para testes)
    public Map<String, String> getClientesAgendados() {
        return clientesAgendados;
    }
}



