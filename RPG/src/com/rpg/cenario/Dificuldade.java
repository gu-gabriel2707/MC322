package com.rpg.cenario;

public enum Dificuldade {
    FACIL(0.8),   // Multiplicador de 80%
    NORMAL(1.0),  // Multiplicador de 100%
    DIFICIL(1.5); // Multiplicador de 150%

    private double multiplicador;

    Dificuldade(double multiplicador) {
        this.multiplicador = multiplicador;
    }

    public double getMultiplicador() {
        return multiplicador;
    }
}