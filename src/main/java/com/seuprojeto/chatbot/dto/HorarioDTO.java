package com.seuprojeto.chatbot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HorarioDTO {
    private Long id;
    private LocalDate dia;
    private LocalTime horario;
    private boolean disponivel = true;
}
