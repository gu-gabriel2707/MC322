package com.rpg.cenario;
import com.rpg.game.*;

public interface GeradorDeFases {
    public FaseDeCombate[] gerar(int n,Dificuldade dificuldade);
} 