package com.rpg.game;

import com.rpg.itens.Arma;
import com.rpg.personagens.herois.*;
import com.rpg.personagens.monstros.Monstro;

public class SimDeBatalha {
    public static boolean batalha(Heroi heroi,  Monstro monstros){
        monstros.exibirStatus();
        monstros.ganhaArma();
        System.out.println("O monstro " + monstros.nome + " está atualmente com: " + monstros.getArma());
        System.out.println("O herói " + heroi.nome + " está atualmente com: " + heroi.getArma());
        System.out.println("Iniciando batalha entre o herói " + heroi.nome + " e o monstro " + monstros.nome);
        for(;;){
            heroi.escolherAcao(monstros);
            System.out.println("");
            System.out.println("O monstro está com " + monstros.pontosDeVida + " pontos de vida");
            System.out.println("");
            if(monstros.pontosDeVida <= 0){
                System.out.println("O monstro " + monstros.nome + " foi derrotado!");
                System.out.println("O herói " + heroi.nome + " ganhou " + monstros.xpConcedido + " pontos de experiência!");
                heroi.ganharExperiencia(monstros.xpConcedido);
                Arma novoItem = monstros.droparLoot(); //verifica se o monstro dropou uma arma
                if(novoItem != null){
                    System.out.println("O herói " + heroi.nome + " encontrou um(a) " + novoItem.getNome() + " com " + novoItem.getDano() + " de dano e " + novoItem.getMinNivel() + " de nível mínimo!");
                    System.out.println("O herói " + heroi.nome + " está atualmente com: " + heroi.getArma());
                    heroi.equiparArma(novoItem); //tenta equipar a nova arma
                    System.out.println("O herói " + heroi.nome + " agora está com: " + heroi.getArma());
                }
                return true; //retorna 1 se o herói vencer
            }
            monstros.escolherAcao(heroi);
            System.out.println("");
            System.out.println("O herói está com " + heroi.pontosDeVida + " pontos de vida");
            System.out.println("");
            if(heroi.pontosDeVida <= 0){
                System.out.println("O herói " + heroi.nome + " foi derrotado!");
                return false; //retorna 0 se o herói morrer
            }
        }
    }
}
