public class Cuca extends Monstro{
    public int mana;//recurso usado para escolher tipo de ataque

    public Cuca(String nome, int pontosDeVida, int forca, int xpConcedido){
        super(nome, pontosDeVida, forca, xpConcedido);
        this.mana = 30; //mana inicial
        arma = new Cajado(xpConcedido/2 , 3);
    }

    public void atacar(Personagem alvo){
        if(mana >= 40){ //ataque forte
            System.out.println(this.nome + " conjura BOLA DE FOGO em" + alvo.getnome());
            int dano = this.forca * 3 + arma.getDano();
            alvo.receberDano(dano);
            this.mana -= 40; //gasto da mana
        }
        else{ //ataque fraco
            System.out.println(this.nome + " usa Míssil Mágico em" + alvo.getnome());
            int dano = this.forca + + arma.getDano();
            alvo.receberDano(dano);
            this.mana += 10; //recuperaão da mana
        }
    }

    //introdução do personagem, exibição de status e explicação básica dos ataques da classe
    public void exibirStatus(){
        System.out.println("########################################################################################################");
        System.out.println(this.nome +", um monstro da espécie Cuca, a bruxa que rapta crianças");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("                                             NÍVEL DE PODER");
        System.out.println("Vida máxima: " + this.pontosDeVida);
        System.out.println("Força de ataque: " + this.forca);
        System.out.println("Experiencia concedida: " + this.xpConcedido);
        System.out.println("Mana inicial: " + this.mana);
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("                                           ATAQUES DISPONÍVEIS");
        System.out.println("Míssil Mágico causa " + this.forca + " de dano");
        System.out.println("BOLA DE FOGO causa " + this.forca*3 + " de dano e deixa o alvo pegando fogo até o fim da batalha");
        System.out.println("########################################################################################################");
    }
}
