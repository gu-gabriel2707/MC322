package com.rpg.cenario;
import java.util.Random;
import com.rpg.game.*;
import com.rpg.personagens.monstros.*;;

public class ConstrutorDeCenario implements GeradorDeFases{

    public FaseDeCombate[] gerar(int n, Dificuldade dificuldade){
        Random gerador = new Random();
        FaseDeCombate[] FaseDeCombate = new FaseDeCombate[n];
        double multiplicador = dificuldade.getMultiplicador();

        for (int i = 0 ; i < n ; i++){
            FaseDeCombate[i] = new FaseDeCombate();
            FaseDeCombate[i].nivel = i;
            int rdm = gerador.nextInt(3);
            if (rdm == 0){
                FaseDeCombate[i].ambiente = TipoCenario.FLORESTA; //Cenário de floresta
                FaseDeCombate[i].monstros[0] = new Mapinguari("Mapinguari da Floresta", 200*multiplicador, (10 + 10*i)*multiplicador, 30 + 10*i);
                FaseDeCombate[i].monstros[1] = new Boitatá("Boitatá da Floresta", (150 + 30*i)*multiplicador, (25 + 10*i)*multiplicador, 20 + 15*i);
                FaseDeCombate[i].monstros[2] = new Cuca("Cuca da Floresta", (100 + 10*i)*multiplicador, (30 + 10*i)*multiplicador, 30 + 5*i);
                //Cada monstro tem seu nome, vida, força e xp concedido aumentado de acordo com o nível da fase
            }if (rdm == 1){
                FaseDeCombate[i].ambiente = TipoCenario.MONTANHAS; //Cenário de montanhas
                FaseDeCombate[i].monstros[0] = new Mapinguari("Mapinguari das Montanhas", (200 + 20*i)*multiplicador, (15 + 10*i)*multiplicador, 40 + 10*i);
                FaseDeCombate[i].monstros[1] = new Boitatá("Boitatá das Montanhas", (150 + 10*i)*multiplicador, (25 + 5*i)*multiplicador, 20 + 10*i);
                FaseDeCombate[i].monstros[2] = new Cuca("Cuca da Montanhas", (100 + 10*i)*multiplicador, (30 + 10*i)*multiplicador, 30 + 10*i);
                //Cada monstro tem seu nome, vida, força e xp concedido aumentado de acordo com o nível da fase
            }if (rdm == 2){
                FaseDeCombate[i].ambiente = TipoCenario.RIO; //cenário de rio
                FaseDeCombate[i].monstros[0] = new Mapinguari("Mapinguari ", (200 + 20*i)*multiplicador, (20 + 10*i)*multiplicador, 50 + 10*i);
                FaseDeCombate[i].monstros[1] = new Boitatá("Boitatá de Água", (150 + 5*i)*multiplicador, (20 + 5*i)*multiplicador, 15 + 10*i);
                FaseDeCombate[i].monstros[2] = new Cuca("Cuca Escamosa", (100 + 20*i)*multiplicador, (30 + 15*i)*multiplicador, 40 + 10*i);
                //Cada monstro tem seu nome, vida, força e xp concedido aumentado de acordo com o nível da fase
            }
        }
        return FaseDeCombate; //Retorna o array de fases geradas
    }
}