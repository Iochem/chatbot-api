package com.seuprojeto.chatbot.entity;

import java.util.UUID;

//import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/*
Anotações biblioteca lombok:
@Getter -Gera automaticamente os métodos get para todos os atributos.
@Setter - Gera automaticamente os métodos set para todos os atributos.
@NoArgsConstructor — Gera um construtor sem argumentos.
@AllArgsConstructor — Gera um construtor com todos os campos como parâmetros.
@RequiredArgsConstructor - Instalação. Gera construtor com todos os final (injeção de dependência)
*/

@Setter
@Getter
@NoArgsConstructor
@Component
//@Entity - futuramente
public class ClienteEntity { //Classe que vai receber o nome e o horarioMarcado
    //@Id
    private UUID id;
    private String nome;
    private String horarioMarcado;

}
