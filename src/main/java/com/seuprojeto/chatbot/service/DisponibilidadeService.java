package com.seuprojeto.chatbot.service;

import com.seuprojeto.chatbot.entity.HorarioDisponivelEntity;
import com.seuprojeto.chatbot.repository.HorarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DisponibilidadeService { //Vai conter a lógica de verificação e atualização dos dias e horarios
    private HorarioRepository horarioRepo;

    //Mostrar todos os horarios disponíveis
    public List<HorarioDisponivelEntity> MostrarDiasHorariosLivres() {
        return horarioRepo.findByDisponivelTrue();
    }

    //Verifica se dia e horário está disponível para o ClienteService adicionar ao banco
    public Boolean isDisponivel(LocalDate dia, LocalTime hora) {
        return horarioRepo.findByDiaAndHorarioAndDisponivelTrue(dia, hora) // Busca no banco
                .map(entity -> { // se existir, executa esta ação
                    entity.setDisponivel(false); // marca como ocupado
                    horarioRepo.save(entity);    // salva a alteração
                    disponibilidadeDia(dia);     // atualiza status do dia
                    return true;
                })
                .orElse(false);  // retorna false se não encontrou horário disponível
    }

    public boolean isOcupado(LocalDate dia, LocalTime hora) {
        // Busca todos os horários ocupados nesse dia e filtra
        return horarioRepo.findByDiaAndDisponivelFalse(dia).stream()
                .filter(h -> h.getHorario().equals(hora))
                .findFirst() // retorna Optional<HorarioDisponivelEntity>- 1° constado
                .map(h -> { // se existir, executa ação e retorna true
                    h.setDisponivel(true);
                    horarioRepo.save(h);
                    disponibilidadeDia(dia);
                    return true;
                })
                .orElse(false); // se não existir, retorna false
    }
}
