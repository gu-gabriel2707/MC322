package com.rpg.personagens.monstros;
public class Cuca extends Monstro{
    public int mana;//recurso usado para escolher tipo de ataque

    public Cuca(String nome, double pontosDeVida, double forca, int xpConcedido){
        super(nome, pontosDeVida, forca, xpConcedido);
        this.mana = 30; //mana inicial
    }

    //introdução do personagem, exibição de status e explicação básica dos ataques da classe
    public void exibirStatus(){
        System.out.println("########################################################################################################");
        System.out.println(this.nome +", um monstro da espécie Cuca, a bruxa que rapta crianças");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("                                             NÍVEL DE PODER");
        System.out.println("Vida máxima: " + this.pontosDeVida);
        System.out.println("Força de ataque: " + this.forca);
        System.out.println("Experiencia concedida: " + this.xpConcedido);
        System.out.println("Mana inicial: " + this.mana);
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("                                           ATAQUES DISPONÍVEIS");
        System.out.println("Míssil Mágico causa " + this.forca + " de dano");
        System.out.println("BOLA DE FOGO causa " + this.forca*3 + " de dano e deixa o alvo pegando fogo até o fim da batalha");
        System.out.println("########################################################################################################");
    }
}
