package com.seuprojeto.chatbot.repository;


import com.seuprojeto.chatbot.entity.ClienteEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteRepository, Long> {

    // Busca um agendamento pelo nome do cliente e pela data/hora completa
    Optional<ClienteEntity> findByNomeAndDataHoraAgendamento(String nome, LocalDateTime dataHoraAgendamento);

}



