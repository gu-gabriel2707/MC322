package com.rpg.personagens.herois;
public class Saci extends Heroi {

    public Saci(String nome, double pontosDeVida, double forca, int nivel, int experiencia, int expProximoNivel) {
        super(nome, pontosDeVida, forca, nivel, experiencia, expProximoNivel);
        this.mana = 20; //mana inicial
    }

    //introdução do personagem, exibição de status e explicação básica dos ataques da classe
    public void exibirStatus(){
        System.out.println(this.nome +" é o herói travesso que enfrentará esse desafio em uma perna só");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                               NÍVEL DE PODER");
        System.out.println("Vida máxima: " + this.pontosDeVida);
        System.out.println("Força de ataque: " + this.forca);
        System.out.println("Nível de combate: " + this.nivel);
        System.out.println("Experiencia concedida: " + this.experiencia);
        System.out.println("Mana inicial: " + this.mana);
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("                                             ATAQUES DISPONÍVEIS");
        System.out.println("Voadora causa " + this.forca + " de dano e concedem 10 de mana");
        System.out.println("TORNADO é um feitiço poderoso que causa " + this.forca*3);
        System.out.println("                                               EFEITO PASSIVO");
        System.out.println("Sacis conseguem lançar feitiços poderosos, mas devem ter mana o suficiente para isso");
        System.out.println("####################################################################################################################################");
    }
}
