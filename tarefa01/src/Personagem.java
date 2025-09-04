public abstract class Personagem {
    // variaveis obrigatorias
    public String nome;
    public int pontosDeVida;
    public int forca;

    public Personagem(String nome, int pontosDeVida, int forca){
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
    }

    public String getnome(){
        return this.nome;
    }
    public int getpontosDeVida(){
        return this.pontosDeVida;
    }
    public int getforca(){
        return this.forca;
    }

    public int receberDano(int dano){
        return pontosDeVida -= dano;
    }

    //mostrar status
    public void exibirStatus(){
        System.out.println("nome:" +nome);
        System.out.println("pontos de vida:" +pontosDeVida);
        System.out.println("força:" +forca);
    }

    //definição função de atacar
    public abstract void atacar(Personagem alvo);
}