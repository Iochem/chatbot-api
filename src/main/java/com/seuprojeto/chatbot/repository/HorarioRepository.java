package com.seuprojeto.chatbot.repository;

import com.seuprojeto.chatbot.entity.HorarioDisponivelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HorarioRepository extends JpaRepository<HorarioDisponivelEntity, Long>{
    //gera uma query para verificar se existe um registro com aquelas condições.
    //And combina os dois campos (dia e hora).
    boolean existsByDiaAndHora(String dia, String hora);

    // Retorna todos os horários livres
    List<HorarioDisponivelEntity> findByDisponivelTrue();
}
