package com.seuprojeto.chatbot;

public class Dados {
    public String[][] diaHorario = {
            {"Dia 3", "14h00", "15h00", "16h00"}, //linha.length == 4
            {"Dia 6", "13h00", "14h10", "17h00"}  //linha.length == 4
    };
    public String[] corte = {
            "Corte simples: R$16,00",
            "Pezinho: R$10,00"
    };

    //Método para mostrar os dias e horários disponíveis
    public void mostrarDiasHorarios(){
        for (String[] linha : diaHorario) { //For para percorrer a matrix
            System.out.print(linha[0] + ": "); //Mostrar só os dias
            for (int i = 1; i < linha.length; i++) {
                System.out.print(linha[i] + " "); // Mostrar só os horários
            }
            System.out.println();//Para pular linha
        }
    }

    //Método para mostrar os cortes
    public void mostrarCortes(){
        for(String num : corte){ //Para a lista pular linha
            System.out.println(num);}
    }
}
