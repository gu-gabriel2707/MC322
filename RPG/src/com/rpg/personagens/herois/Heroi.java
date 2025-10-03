package com.rpg.personagens.herois;
import java.util.List;
import com.rpg.combate.*;
import com.rpg.itens.Arma;
import com.rpg.personagens.*;

import java.util.ArrayList;

public abstract class Heroi extends Personagem{
   //variáveis obrigatórias
    public int nivel;
    protected int experiencia;
    protected int expProximoNivel;
    protected int sorte;
    protected List<AcaoDeCombate> acoes;
    public int mana; //recurso usado para ativar as habilidades

    public Heroi(String nome, double pontosDeVida, double forca, int nivel, int experiencia, int sorte) {
        super(nome, pontosDeVida, forca);
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.expProximoNivel = 100;
        this.sorte = sorte;
        this.mana = 0; //mana inicial
        this.acoes = new ArrayList<>();
        acoes.add(new AtaqueHeroi());
        acoes.add(new AtaqueEspecial());
    }

    public void ganharExperiencia(int xp){
        experiencia =+ xp; //ganho de xp
        System.out.println(nome + " ganhou " + xp + "XP faltam " + (expProximoNivel - experiencia) + "XP para o proximo nível");
                if (this.experiencia >= this.expProximoNivel) {
                    subirDeNivel();
                }
    }

    protected void subirDeNivel() { //Caso chegue o momento, o herói sobe de nível
            this.nivel += 1; 
            this.experiencia -= this.expProximoNivel;
            this.expProximoNivel *= 1.5;

            this.forca += 5;
            this.pontosDeVida += 20;

            System.out.println("############################################");
            System.out.println(this.nome + " subiu para o nível " + this.nivel);
            System.out.println("############################################");
    }

    public void equiparArma(Arma novaArma){ //Equipar uma nova arma caso o nível seja suficiente e o dano da nova seja maior que a atual
        if(this.nivel >= novaArma.getMinNivel() && this.arma.getDano() < novaArma.getDano()){
            this.arma = novaArma;
            System.out.println(this.nome + "equipou" + this.arma);
        }else{
            System.out.println("nível muito baixo para usar essa arma");
        }
    }

    public void escolherAcao(Combatente alvo) { //Vão aparecer algumas mensagens de mana insuficiente para curupira e boto rosa, mas é só para exemplificar o uso do recurso
        if (mana >= 30)
            acoes.get(1).executar(this, alvo);
        else
            acoes.get(0).executar(this, alvo);
    }
    public String getArma(){
        if(this.arma != null){
            return this.arma.getNome();
        }else{
            return "Nenhuma arma equipada";
        }
    }
}
