package com.seuprojeto.chatbot.service;

import com.seuprojeto.chatbot.dto.ClienteDTO;
import com.seuprojeto.chatbot.entity.ClienteEntity;
import com.seuprojeto.chatbot.mapper.ClienteMapper;
import com.seuprojeto.chatbot.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@RequiredArgsConstructor
@Service
public class AgendamentoService {
    private final ClienteRepository clienteRepo;
    private final ClienteMapper mapper;
    private final DisponibilidadeService disponibilidadeServ;

    public ClienteDTO agendarHorario(ClienteDTO dto) {
        // Separa dia e hora só para verificar disponibilidade
        LocalDateTime agendamentoDataHora = dto.getDataHoraAgendamento();
        LocalDate dia = agendamentoDataHora.toLocalDate();
        LocalTime hora = agendamentoDataHora.toLocalTime();

        // Valida se dia e horário está disponível
        boolean existe = disponibilidadeServ.isDisponivel(dia, hora);

        if(!existe)throw new RuntimeException("Horário ocupado ou inexistente!");

        // Converte para entidade via Mapper
        ClienteEntity cliente = mapper.toEntity(dto);
        // Salva no banco
        clienteRepo.save(cliente);
        //Converte de volta para dto
        return mapper.toDTO(cliente);
    }

    public String cancelarHorario(ClienteDTO dto){
        //Busca no banco existência
        ClienteEntity agendamento = clienteRepo.findByNomeAndDataHoraAgendamento(dto.getNome(), dto.getDataHoraAgendamento())
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

        LocalDateTime agendamentoDataHora = dto.getDataHoraAgendamento();
        LocalDate dia = agendamentoDataHora.toLocalDate();
        LocalTime hora = agendamentoDataHora.toLocalTime();

        // Valida se dia e horário está indisponível
        boolean  indisponivel  =  disponibilidadeServ.isOcupado(dia, hora);
        if(!indisponivel)throw new RuntimeException("Horário inexistente!");

        clienteRepo.delete(agendamento);
        return "Agendamento cancelado!";
    }
}

