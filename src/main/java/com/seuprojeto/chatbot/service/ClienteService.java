package com.seuprojeto.chatbot.service;

import com.seuprojeto.chatbot.entity.ClienteEntity;
import com.seuprojeto.chatbot.repository.ClienteRepository;

import java.util.Map;
import java.util.HashMap;

//Coordena a lógica de uso de ClienteRepository e ClienteEntity.
public class ClienteService {
    private ClienteRepository clienteRepository;
    private ClienteEntity clienteEntity;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
        this.clienteEntity = clienteEntity;
    }

    //Verifica se o nome e o horário escolhido existe no map, para poder agendar
    public boolean validarCliente(String nome, String horarioMarcado ) {
        Map<String, String> clientesAgendados = clienteRepository.getClientesAgendados();
        if (clientesAgendados.containsKey(nome) || clientesAgendados.containsValue(horarioMarcado)) {
            System.out.println("❌ Cliente já agendado.");
            return false;//Impede que um cliente agende o mesmo horario
        }
        return true;
    }

    public void adicionarCliente(String nome, String horarioMarcado){
        clienteRepository.agendarCliente(nome, horarioMarcado);
    }
}

