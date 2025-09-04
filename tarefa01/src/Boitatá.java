import java.util.Random;

public class Boitatá extends Monstro{
    public boolean queimar; //variável usada para verificar se o alvo será queimado
    public int stack = 0; //poder de queimar é cumulativo, essa é a variável do quão acumulado está

    public Boitatá(String nome, int pontosDeVida, int forca, int xpConcedido) {
        super(nome, pontosDeVida, forca, xpConcedido);
        Random gerador = new Random();
        if(gerador.nextInt(100)>80){ //chance de queimar e aumento do stack (acumulo), 20% de chance de queimar
            this.queimar = true;
            this.stack += 1;
        }
        else{
            this.queimar = false; //80% chance de não queimar
        }
    }

    public void atacar(Personagem alvo){
        System.out.println(this.nome + " usa Calda Flamejante e deixa " + alvo.getnome() + " queimando");
        int dano = this.forca;
        if(queimar == true){
            dano += 5 * this.stack; //dano do queimar é baseado na quantidade de stack

        }
        alvo.receberDano(dano);
    }

    //introdução do personagem, exibição de status e explicação básica dos ataques da classe
    public void exibirStatus(){
        System.out.println("#############################################################################################################");
        System.out.println(this.nome +", um monstro da espécie Boitatá, a cobra que pega fogo");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("                                               NÍVEL DE PODER");
        System.out.println("Vida máxima: " + this.pontosDeVida);
        System.out.println("Força de ataque: " + this.forca);
        System.out.println("Experiencia concedida: " + this.xpConcedido);
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("                                             ATAQUES DISPONÍVEIS");
        System.out.println("Calda Flamejante causa " + this.forca + " de dano e deixa o alvo pegando fogo até o fim da batalha");
        System.out.println("#############################################################################################################");
    }
}

