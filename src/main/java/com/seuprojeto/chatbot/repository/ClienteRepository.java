package com.seuprojeto.chatbot.repository;


import com.seuprojeto.chatbot.entity.ClienteEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.HashMap;

@Getter
@RequiredArgsConstructor
@Repository
public class ClienteRepository {
    private final Map<String, String> clientesAgendados = new HashMap<>();
    private final ClienteEntity clienteEntity;

    public void agendarCliente(String nome, String horarioMarcado){
        clientesAgendados.put(nome, horarioMarcado);
    }

    //Remove agendamento do map caso verifique que ele exista no AgendamentoService
    public void removerCliente(String nome, String horarioCancelamento){
        clientesAgendados.remove(nome);;
    }
}



