public abstract class Arma implements Item {
    protected int dano;
    protected int minNivel;
    protected String nome;

    public Arma(int dano, int minNivel, String nome) {
        this.nome = nome;
        this.dano = dano;
        this.minNivel = minNivel;
    }

    public int getDano() {
        return dano;
    }

    public int getMinNivel() {
        return minNivel;
    }
    public String getNome(){
        return this.nome;
    }
}

