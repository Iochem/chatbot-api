package com.seuprojeto.chatbot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "horarios")
public class HorarioDisponivelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String dia;       // Ex: "Dia 3", ou "2025-07-20"

    @Column(nullable = false)
    private String horario;   // Ex: "14h00"

    private boolean disponivel = true; // true = livre, false = ocupado

}
