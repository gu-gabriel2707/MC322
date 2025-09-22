import java.util.Random;
//Ação de combate especial dos heróis, cada herói tem uma habilidade especial diferente
public class AtaqueEspecial implements AcaoDeCombate {
    public void executar(Combatente usuario, Combatente alvo) {
        if (usuario instanceof Saci) {
            Saci saci = (Saci) usuario;
            if(saci.mana >= 30){
                System.out.println(saci.getNome() + " conjura TORNADO em " + alvo.getNome());
                int danoHabilidade = saci.getforca() * 3; //valor do dano da habilidade
                alvo.receberDano(danoHabilidade);
                saci.mana -= 30; //gasto da mana para usar habilidade
            }
            else{
                System.out.println(saci.getNome() + " não possúi mana o suficiente para conjurar feitiço poderoso");
                System.out.println("Usará um ataque normal");
                System.out.println();
                System.out.println(saci.getNome() + " dá uma voadora em " + alvo.getNome()); //em briga de saci todo chute é voadora
                int dano = saci.getforca();
                alvo.receberDano(dano);
                saci.mana += 10; //meio de recuperar a mana é o ataque comum
            }
        }else{
            if(usuario instanceof BotoRosa){
                BotoRosa boto = (BotoRosa) usuario;
                if(boto.mana > 50){
                    System.out.println(boto.nome + " se cura usando magia ");
                    boto.pontosDeVida += 40; //quantidade de cura da habilidade
                    System.out.println(boto.getNome() + " usará um ataque normal");
                    System.out.println();
                    System.out.println(boto.getNome() + " dá um Golpe de Rabo em " + alvo.getNome());
                    int dano = boto.getforca();
                    alvo.receberDano(dano);
                }else{
                boto.mana += 50; //Se o boto não tiver mana suficiente para se curar, ele ganhará 50 de mana, mas não atacará na rodada.
                }
        
            }else{
                if(usuario instanceof Curupira){
                    Curupira curupira = (Curupira) usuario;
                    if(curupira.mana >= 50){
                        System.out.println(curupira.getNome() + " está com o ALVO NA MIRA");
                        curupira.aptidao = 150; //usar a habilidade garante dois ataques críticos
                        curupira.mana = 0; //gasto de mana (Curupiras não possuem acumulo de mana, usar a habilidade sempre vai zerar ela)
                    }else{
                        System.out.println("Curupira ainda não possui um alvo em sua mira"); //aviso se não houver mana suficiente
                        System.out.println("Usará um ataque normal");
                        System.out.println();
                    }
                    Random gerador = new Random();
                    if(curupira.aptidao > gerador.nextInt(100)){ //chance de dar golpe crítico
                        System.out.println("Curupira executa um tiro duplo em " + alvo.getNome());
                        int dano = curupira.forca * 2; //valor do golpe crítico
                        alvo.receberDano(dano);
                        curupira.aptidao -= 50; //gasto de aptidão por golpe crítico
                    }else{
                        System.out.println("Curupira executa um tiro comum em " + alvo.getNome());
                        int dano = curupira.forca; //dano do ataque comum
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