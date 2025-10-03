package com.rpg.combate;
import com.rpg.personagens.monstros.*;;
//Ação de combate especial dos monstros, cada monstro tem uma habilidade especial diferente

public class AtaqueEspMonstro implements AcaoDeCombate {
    public void executar(Combatente atacante, Combatente alvo) {
        if(atacante instanceof Cuca){
            Cuca cuca = (Cuca) atacante;
            System.out.println(cuca.nome + "conjura BOLA DE FOGO em " + alvo.getNome());
            double dano = cuca.forca * 3 + cuca.arma.getDano(); // valor do dano da habilidade
            alvo.receberDano(dano);
            cuca.mana -= 30; //gasto de mana
        }else{
            if(atacante instanceof Mapinguari){
                Mapinguari mapinguari = (Mapinguari) atacante;
                System.out.println(mapinguari.nome + " da uma grande mordida em " + alvo.getNome());
                double dano = mapinguari.forca * 5 + mapinguari.arma.getDano(); // valor do dano da habilidade
                alvo.receberDano(dano);
                mapinguari.Raiva -= 50; //gasto de raiva
            }
        }
    }   
}
