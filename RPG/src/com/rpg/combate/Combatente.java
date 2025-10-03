package com.rpg.combate;
public interface Combatente {
    String getNome();
    boolean estaVivo();
    void receberDano(double dano);
    void receberCura(int cura);
    abstract void escolherAcao(Combatente alvo);
    double getforca();
}
