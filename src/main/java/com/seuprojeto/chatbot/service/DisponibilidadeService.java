package com.seuprojeto.chatbot.service;

import com.seuprojeto.chatbot.entity.HorarioDisponivelEntity;
import com.seuprojeto.chatbot.repository.HorarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
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

    @Transactional
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

    @Transactional
    public void disponibilidadeDia(LocalDate dia) {
        //Checa existência de horários livres e status atual do dia
        boolean horariosDispo = horarioRepo.existsByDiaAndDisponivelTrue(dia);
        HorarioDisponivelEntity diaEntidade = horarioRepo.findFirstByDia(dia).get(); //Pega o 1° registro
        boolean diaDispo = diaEntidade.isDisponivel();

        if (!horariosDispo && diaDispo) {
            diaEntidade.setDisponivel(false);
            horarioRepo.save(diaEntidade); // Todos os horários ocupados → marca dia como indisponível
        } else if (horariosDispo && !diaDispo) {
            diaEntidade.setDisponivel(true); // Algum horário livre → marca dia como disponível
            horarioRepo.save(diaEntidade);
        }
    }
}


