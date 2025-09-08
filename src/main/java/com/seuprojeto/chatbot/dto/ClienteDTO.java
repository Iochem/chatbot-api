package com.seuprojeto.chatbot.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO {

    Long id;
    private String nome;
    private LocalDateTime dataHoraAgendamento;

}
