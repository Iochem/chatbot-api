package com.seuprojeto.chatbot.repository;


import com.seuprojeto.chatbot.entity.ClienteEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.HashMap;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class ClienteRepository {
    private final Map<String, String> clientesAgendados = new HashMap<>();
    private ClienteEntity clienteEntity;

    public void agendarCliente(String nome, String horarioMarcado){
        clientesAgendados.put(nome, horarioMarcado);
    }

    //Remove agendamento do map caso verifique que ele exista no AgendamentoService
    public void removerCliente(String nome, String horarioCancelamento){
        clientesAgendados.remove(nome);;
    }
}



