package com.seuprojeto.chatbot.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class HorarioDTO {
    private Long id;
    private LocalDate dia;
    private LocalTime horario;
    private boolean disponivel = true;
}
