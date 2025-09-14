package com.seuprojeto.chatbot.commandLineRunner;


import com.seuprojeto.chatbot.entity.HorarioDisponivelEntity;
import com.seuprojeto.chatbot.repository.HorarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class DadosIniciaisLoader implements CommandLineRunner {

    private final HorarioRepository horarioRepo;

    @Override
    public void run(String... args) {
        if (horarioRepo.count() == 0) {

            // Map com cada dia e seus horários específicos
            Map<LocalDate, List<LocalTime>> diasComHorarios = Map.of(
                    LocalDate.of(2025, 9, 3), List.of(LocalTime.of(14, 0), LocalTime.of(16, 0), LocalTime.of(17, 0)),
                    LocalDate.of(2025, 9, 4), List.of(LocalTime.of(15, 0), LocalTime.of(18, 0), LocalTime.of(19, 0)),
                    LocalDate.of(2025, 9, 7), List.of(LocalTime.of(12, 0), LocalTime.of(14, 0))
            );

            // Loop para salvar todos os horários
            diasComHorarios.forEach((dia, horarios) ->
                    horarios.forEach(horario ->
                            horarioRepo.save(new HorarioDisponivelEntity(null, dia, horario, true))
                    )
            );
        }
    }
}

