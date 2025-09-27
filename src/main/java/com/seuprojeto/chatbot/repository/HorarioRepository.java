package com.seuprojeto.chatbot.repository;

import com.seuprojeto.chatbot.entity.HorarioDisponivelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface HorarioRepository extends JpaRepository<HorarioDisponivelEntity, Long>{
    //Busca o horário disponível específico
    Optional<HorarioDisponivelEntity> findByDiaAndHorarioAndDisponivelTrue(LocalDate dia, LocalTime horario);

    // Retorna todos os horários livres
    List<HorarioDisponivelEntity> findByDisponivelTrue();

    // Verifica se ainda existe algum horário livre no dia
    boolean existsByDiaAndDisponivelTrue(LocalDate dia);

    // Retorna todos os horários de um dia específico que já estão ocupados (disponivel = false)
    List<HorarioDisponivelEntity> findByDiaAndDisponivelFalse(LocalDate dia);

    // Retorna apenas um registro de um dia (serve para checar status do dia)
    Optional<HorarioDisponivelEntity> findFirstByDia(LocalDate dia);

}
