public abstract class Heroi extends Personagem{
   //variáveis obrigatórias
    public int nivel;
    public int experiencia;

    public Heroi(String nome, int pontosDeVida, int forca, int nivel, int experiencia) {
        super(nome, pontosDeVida, forca);
        this.nivel = nivel;
        this.experiencia = experiencia;
    }

    public void ganharExperiencia(int xp){
        experiencia =+ xp; //ganho d xp
    }

    public void exibirStatus(){ //exibir status básico
        System.out.println("nome:" +nome);
        System.out.println("pontos de vida:" +pontosDeVida);
        System.out.println("força:" +forca);
        System.out.println("nivel:" +nivel);
        System.out.println("experiencia:" +experiencia);
    }

    public abstract void usarHabilidadeEspecial(Personagem alvo); //definião do usarHabilidade
}
