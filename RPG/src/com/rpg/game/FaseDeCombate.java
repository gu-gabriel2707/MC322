package com.rpg.game;
import com.rpg.personagens.herois.Heroi;
import com.rpg.personagens.monstros.Monstro;
import com.rpg.cenario.*;

public class FaseDeCombate implements Fase {
    public int nivel;
    public TipoCenario ambiente;
    public Monstro[] monstros = new Monstro[3];

    public int iniciar(Heroi heroi){ //Inicia a fase de combate com o herói recebido como parâmetro e retorna 0 se o herói morrer ou 1 se ele vencer todos os monstros
        System.out.println("Cenário atual: " + this.ambiente);
        System.out.println("Descrição: " + ambiente.getDescricao());
        ambiente.aplicarEfeitos(heroi); //Aplica os efeitos do cenário no herói
        System.out.println("Iniciando fase de combate com o herói: " + heroi.getNome());
        if(SimDeBatalha.batalha(heroi, monstros[0]) == false)
                return 0;
        else if(SimDeBatalha.batalha(heroi, monstros[1]) == false)
                return 0;
        else if(SimDeBatalha.batalha(heroi, monstros[2]) == false)
                return 0;
        else
            return 1;
    }
    public boolean isConcluida(){
        return false;
    }
    public TipoCenario getTipoDeCenario(){
        return this.ambiente;
    }
    public Monstro[] getMonstros() {
        return this.monstros;
    }
}
