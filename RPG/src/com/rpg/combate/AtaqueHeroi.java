package com.rpg.combate;
import java.util.Random;
import com.rpg.personagens.herois.*;;
//Ação de combate normal dos heróis, cada herói tem um ataque normal diferente
public class AtaqueHeroi implements AcaoDeCombate {
    public void executar(Combatente usuario, Combatente alvo) {
        if (usuario instanceof Saci) {

            System.out.println(usuario.getNome() + " dá uma voadora em " + usuario.getNome()); //em briga de saci todo chute é voadora
            double dano = usuario.getforca();
            alvo.receberDano(dano);
            Saci saciAtacante = (Saci) usuario;
            saciAtacante.mana += 10; //meio de recuperar a mana é o ataque comum
        }else{
            if(usuario instanceof BotoRosa){
                System.out.println(usuario.getNome() + " dá um Golpe de Rabo em " + alvo.getNome());
                double dano = usuario.getforca(); //dano do ataque normal
                alvo.receberDano(dano);
                BotoRosa botoAtacante = (BotoRosa) usuario;
                botoAtacante.mana += 20; //meio de recuperação de mana
            }else{
                if(usuario instanceof Curupira){
                    Random gerador = new Random();
                    Curupira curupira = (Curupira) usuario;
                    if(curupira.aptidao > gerador.nextInt(100)){ //chance de dar golpe crítico
                        System.out.println("Curupira executa um tiro duplo em " + alvo.getNome());
                        double dano = curupira.forca * 2; //valor do golpe crítico
                        alvo.receberDano(dano);
                        curupira.aptidao -= 50; //gasto de aptidão por golpe crítico
                    }else{
                        System.out.println("Curupira executa um tiro comum em " + alvo.getNome());
                        double dano = curupira.forca; //dano do ataque comum
                        alvo.receberDano(dano);
                        curupira.aptidao += 10;
                    }
                curupira.AjustarAptidao();
                curupira.mana += 10;
                }
            }
        }
    }
}
