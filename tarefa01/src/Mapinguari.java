public class Mapinguari extends Monstro {
    public int Raiva;

    public Mapinguari(String nome, int pontosDeVida, int forca, int xpConcedido){
        super(nome, pontosDeVida, forca, xpConcedido);
        this.Raiva = 0; //Raiva inicial
    }

    public void atacar(Personagem alvo){
        if(Raiva >= 50){ //Mapinguari dara seu ataque rodada sim, rodada não, mas não se engane, seu ataque é muito poderoso.
            System.out.println(this.nome + " da uma grande mordida em " + alvo.getnome());
            int dano = this.forca * 5;
            alvo.receberDano(dano);
            this.Raiva -= 50;
        }
        else{ //Quando não conseguir atacar, Mapinguari dara um grito para demonstrar e aumentar a sua raiva
            System.out.println(this.nome + " usa grito feroz olhando para " + alvo.getnome());
            int dano = this.forca;
            alvo.receberDano(dano);
            this.Raiva += 50;
        }
    }

     //introdução do personagem, exibição de status e explicação básica dos ataques da classe
    public void exibirStatus(){
        System.out.println("########################################################################################################");
        System.out.println(this.nome +", um ENORME monstro da espécie Mapinguari, o lendário guardião");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("                                             NÍVEL DE PODER");
        System.out.println("Vida máxima: " + this.pontosDeVida);
        System.out.println("Força de ataque: " + this.forca);
        System.out.println("Experiencia concedida: " + this.xpConcedido);
        System.out.println("Mana inicial: " + this.Raiva);
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("                                           ATAQUES DISPONÍVEIS");
        System.out.println("Grito Feroz não causa dano, apenas recupera a raiva de um Mapinguari");
        System.out.println("Grande Mordida é um ataque que causa " + this.forca * 5 + " de dano");
        System.out.println("########################################################################################################");
    }
}