public abstract class Personagem implements Combatente {
    // variaveis obrigatorias
    protected String nome;
    protected int pontosDeVida;
    protected int forca;
    protected Arma arma;

    public Personagem(String nome, int pontosDeVida, int forca){
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.arma = null;
        
    }

    public String getNome(){
        return this.nome;
    }
    public int getpontosDeVida(){
        return this.pontosDeVida;
    }

    public boolean estaVivo(){
        if(this.pontosDeVida > 0){
            return true;
        }else{
            return false;
        }
    }

    public int getforca(){
        return this.forca;
    }

    public void receberDano(int dano){
        pontosDeVida -= dano;
    }
    public void receberCura(int cura){
        pontosDeVida += cura;
    }

    //mostrar status
    public void exibirStatus(){
        System.out.println("nome:" +nome);
        System.out.println("pontos de vida:" +pontosDeVida);
        System.out.println("força:" +forca);
    }
}