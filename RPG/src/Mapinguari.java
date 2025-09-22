public class Mapinguari extends Monstro {
    protected int Raiva;

    public Mapinguari(String nome, int pontosDeVida, int forca, int xpConcedido){
        super(nome, pontosDeVida, forca, xpConcedido);
        this.Raiva = 0; //Raiva inicial
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