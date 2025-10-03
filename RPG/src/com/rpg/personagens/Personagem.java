package com.rpg.personagens;
import com.rpg.combate.Combatente;
import com.rpg.itens.Arma;

public abstract class Personagem implements Combatente {
    // variaveis obrigatorias
    public String nome;
    public double pontosDeVida;
    public double forca;
    public Arma arma;

    public Personagem(String nome, double pontosDeVida, double forca){
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.arma = null;
        
    }

    public String getNome(){
        return this.nome;
    }
    public double getpontosDeVida(){
        return this.pontosDeVida;
    }

    public boolean estaVivo(){
        if(this.pontosDeVida > 0){
            return true;
        }else{
            return false;
        }
    }

    public double getforca(){
        return this.forca;
    }

    public void receberDano(double dano){
        pontosDeVida -= dano;
    }
    public void receberCura(int cura){
        pontosDeVida += cura;
    }

    //mostrar status
    public void exibirStatus(){
        System.out.println("nome:" +nome);
        System.out.println("pontos de vida:" +pontosDeVida);
        System.out.println("força:" +forca);
    }
}