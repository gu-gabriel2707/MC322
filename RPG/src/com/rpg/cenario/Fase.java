package com.rpg.cenario;
import com.rpg.personagens.herois.*;
import com.rpg.personagens.monstros.*;

public interface Fase {
    int iniciar(Heroi heroi);
    boolean isConcluida();
    TipoCenario getTipoDeCenario();
    Monstro[] getMonstros();
}

