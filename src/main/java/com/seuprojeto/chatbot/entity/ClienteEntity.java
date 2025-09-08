package com.seuprojeto.chatbot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
//@Entity - futuramente
public class ClienteEntity { //Classe que vai receber o nome e o horarioMarcado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Será gerado automaticamente pelo banco
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true) //Campo não pode ser nulo nem repetido
    private LocalDateTime dataHoraAgendamento;
}
