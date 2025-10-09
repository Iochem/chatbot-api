package com.seuprojeto.chatbot.controller;

import java.util.List;
import com.seuprojeto.chatbot.dto.ClienteDTO;
import com.seuprojeto.chatbot.entity.HorarioDisponivelEntity;
import com.seuprojeto.chatbot.service.AgendamentoService;
import com.seuprojeto.chatbot.service.DisponibilidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public void inserir(@RequestBody ClienteDTO cliente){
        agendamentoServ.agendarHorario(cliente);
    }

    //Método para receber dados para o cancelamento
    // DELETE /api/clientes/cancelar
    @DeleteMapping("/cancelar")
    public void cancelar(ClienteDTO cliente){
        agendamentoServ.cancelarHorario(cliente);
    }
}
