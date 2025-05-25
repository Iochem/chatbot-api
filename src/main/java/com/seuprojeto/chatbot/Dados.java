package com.seuprojeto.chatbot;

import java.util.*;

public class Dados {
    public Map<String, List<String>> diaHorario = new HashMap<>();
    public List<String> cortes = new ArrayList<>();

    public Dados() {
        inicializarDados();
        inicializarCortes();
    }

    public void inicializarDados(){
        diaHorario.put("Dia 3", Arrays.asList("14h00", "15h00", "16h00"));
        diaHorario.put("Dia 4", Arrays.asList("13h00", "16h00", "17h00"));
    }
    public void inicializarCortes(){
        cortes.add("Corte simples");
        cortes.add("Corte com navalha");
        cortes.add("Barba");
    }

    //Metodo para mostrar os dias e horários disponíveis
    public void mostrarDiasHorarios(){
        for(String a: diaHorario.keySet()){
            System.out.print(a + " : "); //Vai imprimir só os dias
            for(String b : diaHorario.get(a)){
                System.out.print( b + " ");//Vai imprimir só os horários
            }
            System.out.println("  ");//Para pular linha a cada impressão
        }  }

    //Metodo para mostrar os cortes
    public void mostrarCortes(){
        for(String num : cortes){
            System.out.println(num);
        }
    }
}


