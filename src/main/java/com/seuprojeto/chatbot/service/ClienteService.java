package com.seuprojeto.chatbot.service;

import com.seuprojeto.chatbot.entity.ClienteEntity;
import com.seuprojeto.chatbot.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.HashMap;

@RequiredArgsConstructor
@Service
//Coordena a lógica de uso de ClienteRepository e ClienteEntity.
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteEntity clienteEntity;

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

    //Verifica se agendamento existe no map para ver se pode cancela-lo e exclui-lo do map
    public boolean verificarExistenciaAgendamento(String cancelarAgendamento){
        Map<String, String> clientesAgendados = clienteRepository.getClientesAgendados();

        String[] partes = cancelarAgendamento.split(" ");
        if (partes.length < 4) {
            System.out.println("Entrada inválida.");
            return false;
        }
        //Divide em partess
        String nomeCancelamento = partes[0];
        String horarioCancelamento = "Dia " + partes[2] + " " + partes[3];

        for(Map.Entry<String, String> entry : clientesAgendados.entrySet()){
            if(entry.getKey().equalsIgnoreCase(nomeCancelamento) && entry.getValue().equalsIgnoreCase(horarioCancelamento)){
                clienteRepository.removerCliente(nomeCancelamento, horarioCancelamento);
                return true; //Agendamento encontrado
            }}
        return false; //Agendameno não encontrado
    }

}

