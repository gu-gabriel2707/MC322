public abstract class Monstro extends Personagem{
    public int xpConcedido;

    public Monstro(String nome, int pontosDeVida, int forca, int xpConcedido) {
        super(nome, pontosDeVida, forca);
        this.xpConcedido = xpConcedido;
    }

    //exibir Status básico
    public void exibirStatus(){
        System.out.println("nome:" +nome);
        System.out.println("pontos de vida:" +pontosDeVida);
        System.out.println("força:" +forca);
        System.out.println("xp concedido:" +xpConcedido);
    }

}
