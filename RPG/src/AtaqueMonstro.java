import java.util.Random;
//Ação de combate normal dos monstros, cada monstro tem um ataque normal diferente
public class AtaqueMonstro implements AcaoDeCombate {
    public void executar(Combatente atacante, Combatente alvo) {
        if(atacante instanceof Cuca){
            Cuca cuca = (Cuca) atacante;
            System.out.println(cuca.nome + " usa Míssil Mágico em " + alvo.getNome());
            int dano = cuca.forca + cuca.arma.getDano();
            alvo.receberDano(dano);
            cuca.mana += 10; //recuperaão da mana
        }else{
            if(atacante instanceof Mapinguari){
                Mapinguari mapinguari = (Mapinguari) atacante;
                System.out.println(mapinguari.nome + " usa grito feroz olhando para " + alvo.getNome()); //Mapinguaris não causam dano com seu ataque normal, mas possui uma habilidade poderosa
                mapinguari.Raiva += 20; //meio de aumentar a raiva
            }else{
                Boitatá boitata = (Boitatá) atacante;
                System.out.println(boitata.nome + " usa Calda Flamejante e deixa " + alvo.getNome() + " queimando");
                Random gerador = new Random();
                if(gerador.nextInt(100)>80){ //chance de queimar e aumento do stack (acumulo), 20% de chance de queimar
                    boitata.queimar = true;
                    boitata.stack += 1;
                }
                int dano = boitata.forca + boitata.arma.getDano();;
                if(boitata.queimar == true){
                    dano += 5 * boitata.stack; //dano do queimar é baseado na quantidade de stack
                }
                alvo.receberDano(dano);
            }
        }
    }
}
