public abstract class Heroi extends Personagem{
   //variáveis obrigatórias
    public int nivel;
    public int experiencia;
    public int expProximoNivel;
    public int sorte;

    public Heroi(String nome, int pontosDeVida, int forca, int nivel, int experiencia, int sorte) {
        super(nome, pontosDeVida, forca);
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.expProximoNivel = 100;
        this.sorte = sorte;
    }

    protected void ganharExperiencia(int xp){
        experiencia =+ xp; //ganho d xp
        System.out.println(nome + " ganhou " + xp + "XP faltam " + (expProximoNivel - experiencia) + "XP para o proximo nível");
                if (this.experiencia >= this.expProximoNivel) {
            subirDeNivel();
        }
    }

    protected void subirDeNivel() {
            this.nivel += 1;
            this.experiencia -= this.expProximoNivel;
            this.expProximoNivel *= 1.5;

            this.forca += 5;
            this.pontosDeVida += 20;

            System.out.println("############################################");
            System.out.println(this.nome + " subiu para o nível " + this.nivel);
            System.out.println("############################################");
    }

    protected void equiparArma(Arma novaArma){
        if(this.nivel >= novaArma.getMinNivel()){
            this.arma = novaArma;
            System.out.println(this.nome + "equipou" + this.arma);
        }else{
            System.out.println("nível muito baixo para usar essa arma");
        }
    }

    public void exibirStatus(){ //exibir status básico
        System.out.println("nome:" +nome);
        System.out.println("pontos de vida:" +pontosDeVida);
        System.out.println("força:" +forca);
        System.out.println("nivel:" +nivel);
        System.out.println("experiencia:" +experiencia);
    }

    protected abstract void usarHabilidadeEspecial(Personagem alvo); //definição do usarHabilidade
}
