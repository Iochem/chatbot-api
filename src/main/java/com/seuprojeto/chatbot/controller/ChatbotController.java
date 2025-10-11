package com.seuprojeto.chatbot.controller;

import com.seuprojeto.chatbot.dto.ClienteDTO;
import com.seuprojeto.chatbot.entity.HorarioDisponivelEntity;
import com.seuprojeto.chatbot.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/clientes")
public class ChatbotController {
    private final AgendamentoService agendamentoServ;
    private final DisponibilidadeService disponibilidadeServ;

    //Método para enviar os dias e horários disponíveis
    // GET /api/clientes/disponibilidades
    @GetMapping("/disponibilidades")
    public List<HorarioDisponivelEntity> listarDisponibilidades(){
        return disponibilidadeServ.MostrarDiasHorariosLivres();
    }

    //Método para receber dados para o agendamento
    // POST /api/clientes/agendar
    @PostMapping("/agendar")
    public ResponseEntity<String> inserir(@RequestBody @Valid ClienteDTO cliente) {
        agendamentoServ.agendarHorario(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Agendamento realizado com sucesso"); // 201 CREATED
    }

    //Método para receber dados para o cancelamento
    // DELETE /api/clientes/cancelar
    @DeleteMapping("/cancelar")
    public ResponseEntity<String> cancelar(@RequestBody @Valid ClienteDTO cliente) {
        agendamentoServ.cancelarHorario(cliente);
        return ResponseEntity.ok("Agendamento cancelado com sucesso");
    }
}
