public class BotoRosa extends Heroi{
    
    public BotoRosa(String nome, int pontosDeVida, int forca, int nivel, int experiencia, int expProximoNivel) {
        super(nome, pontosDeVida, forca, nivel, experiencia, expProximoNivel);
        this.mana = 0; //mana inicial
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
