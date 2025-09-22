public class Boitatá extends Monstro{
    public boolean queimar; //variável usada para verificar se o alvo será queimado
    public int stack = 0; //poder de queimar é cumulativo, essa é a variável do quão acumulado está

    public Boitatá(String nome, int pontosDeVida, int forca, int xpConcedido) {
        super(nome, pontosDeVida, forca, xpConcedido);
        queimar = false;
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

