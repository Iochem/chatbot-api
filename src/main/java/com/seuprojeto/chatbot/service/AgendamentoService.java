package com.seuprojeto.chatbot.service;

import com.seuprojeto.chatbot.repository.DadosRepository;

public class AgendamentoService {
    private DadosRepository dadosRepository; //Usando isso essa classe tem acesso a tudo de dados

    public AgendamentoService(DadosRepository dadosRepository){
        this.dadosRepository = dadosRepository;
    }

    // Verifica se o horário existe nos dados disponíveis
    public boolean validarDiaHorario(String escolha){
        for(String chave : dadosRepository.getDiaHorario().keySet()){
            for(String valor : dadosRepository.getDiaHorario().get(chave)){
                String horarioCompleto = (chave + " " + valor).toLowerCase().trim();
                if(escolha.equals(horarioCompleto)){
                    return true;
                }
            }}
        System.out.println("❌ Horário indisponível.");
        return false;  // retorna false após verificar todos os horários
    }
}

