public class BotoRosa extends Heroi{
    public int mana; //recurso usado para ativar as habilidades
    public int Type;

    public BotoRosa(String nome, int pontosDeVida, int forca, int nivel, int experiencia) {
        super(nome, pontosDeVida, forca, nivel, experiencia);
        this.Type = 1;
        this.mana = 0; //mana inicial
    }

    public void atacar(Personagem alvo){
        System.out.println(this.nome + " dá um Golpe de Rabo em " + alvo.getnome());
        int dano = this.forca; //dano do ataque normal
        alvo.receberDano(dano);
        this.mana += 20; //meio de recuperação de mana
    }

    public void usarHabilidadeEspecial(Personagem alvo){
        if(mana > 50){
            System.out.println(this.nome + " se cura usando magia ");
            this.pontosDeVida += 20; //quantidade de cura da habilidade
        }
        atacar(alvo); //após se curar ele faz sua rodada de ataque.
    }

    //introdução do personagem, exibição de status e explicação básica dos ataques da classe
    public void exibirStatus(){
        System.out.println(this.nome +" enfrentará todos desafios que vierem ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                               NÍVEL DE PODER");
        System.out.println("Vida máxima: " + this.pontosDeVida);
        System.out.println("Força de ataque: " + this.forca);
        System.out.println("Nível de combate: " + this.nivel);
        System.out.println("Experiencia concedida: " + this.experiencia);
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("                                             ATAQUES DISPONÍVEIS");
        System.out.println("Golpe de Rabo " + this.forca + " de dano e concedem 10 de mana");
        System.out.println("A Habilidade Especial da espécie Boto Rosa cura 20 de dano e gasta 50 de mana");
        System.out.println("####################################################################################################################################");
    }
}
