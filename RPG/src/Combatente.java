public interface Combatente {
    String getNome();
    boolean estaVivo();
    void receberDano(int dano);
    void receberCura(int cura);
    abstract void escolherAcao(Combatente alvo);
    int getforca();
}
