package com.seuprojeto.chatbot.entity;

//import java.util.UUID;

//import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
//import lombok.Getter;

@Setter
@Getter
@NoArgsConstructor
@Component
//@Entity - futuramente
public class ClienteEntity { //Classe que vai receber o nome e o horarioMarcado
    //@Id
    //private final UUID id;
    private String nome;
    private String horarioMarcado;

}
