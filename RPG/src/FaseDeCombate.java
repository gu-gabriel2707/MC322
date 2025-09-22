public class FaseDeCombate implements Fase {
    public int nivel;
    public TipoCenario ambiente;
    public Monstro[] monstros = new Monstro[3];

    public int iniciar(Heroi heroi){ //Inicia a fase de combate com o herói recebido como parâmetro e retorna 0 se o herói morrer ou 1 se ele vencer todos os monstros
        System.out.println("Cenário atual: " + this.ambiente);
        System.out.println("Descrição: " + ambiente.getDescricao());
        ambiente.aplicarEfeitos(heroi); //Aplica os efeitos do cenário no herói
        System.out.println("Iniciando fase de combate com o herói: " + heroi.getNome());
        if(simDeBatalha.batalha(heroi, monstros[0]) == 0)
                return 0;
        else if(simDeBatalha.batalha(heroi, monstros[1]) == 0)
                return 0;
        else if(simDeBatalha.batalha(heroi, monstros[2]) == 0)
                return 0;
        else
            return 1;
    }
    public boolean isConcluida(){
        return false;
    }
    public TipoCenario getTipoDeCenario(){
        return this.ambiente;
    }
}
