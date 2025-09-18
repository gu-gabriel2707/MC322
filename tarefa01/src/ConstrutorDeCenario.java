import java.util.Random;

public class ConstrutorDeCenario{

    public static Fase[] gerarFases(int n){
        Random gerador = new Random();
        Fase[] fases = new Fase[n];

        for (int i = 0 ; i < n ; i++){
            fases[i] = new Fase();
            fases[i].nivel = i;
            int rdm = gerador.nextInt(3);
            if (rdm == 0){
                fases[i].ambiente = "floresta";
                fases[i].monstros[0] = new Mapinguari("Mapinguari da Floresta", 200, 10 + 10*i, 40 + 10*i);
                fases[i].monstros[1] = new Boitatá("Boitatá da Floresta", 150 + 30*i, 25 + 10*i, 20 + 15*i);
                fases[i].monstros[2] = new Cuca("Cuca da Floresta", 100 + 10*i, 30 + 10*i, 30 + 5*i);
            }if (rdm == 1){
                fases[i].ambiente = "montanhas";
                fases[i].monstros[0] = new Mapinguari("Mapinguari das Montanhas", 200, 15 + 5*i, 30 + 10*i);
                fases[i].monstros[1] = new Boitatá("Boitatá das Montanhas", 150 + 10*i, 25 + 5*i, 20 + 10*i);
                fases[i].monstros[2] = new Cuca("Cuca da Montanhas", 100 + 20*i, 30 + 15*i, 30 + 10*i);
            }if (rdm == 2){
                fases[i].ambiente = "neve";
                fases[i].monstros[0] = new Mapinguari("Mapinguari Albino", 200 + 20*i, 20 + 10*i, 50 + 10*i);
                fases[i].monstros[1] = new Boitatá("Boitatá Albino", 150 + 5*i, 20 + 5*i, 15 + 10*i);
                fases[i].monstros[2] = new Cuca("Cuca Albino", 100 + 15*i, 30 + 10*i, 25 + 10*i);
            }
        }
        return fases;
    }
}