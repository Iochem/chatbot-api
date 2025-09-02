package com.seuprojeto.chatbot.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO {

    private Long id;

    private String nome;

    private String horarioMarcado;

}
