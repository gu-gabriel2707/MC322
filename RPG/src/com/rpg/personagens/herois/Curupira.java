package com.rpg.personagens.herois;
public class Curupira extends Heroi{
    public int aptidao; //variavel utilizada para calcular a chance de acertar um ataque critico (2x o dano)

    public Curupira(String nome, double pontosDeVida, double forca, int nivel, int experiencia, int expProximoNivel) {
        super(nome, pontosDeVida, forca, nivel, experiencia, expProximoNivel);
        this.aptidao = 0;
        this.mana = 0;
    }

    //ajuste da aptidão para não ser um valor negativo nem acima de 100
    public void AjustarAptidao(){
        if (aptidao > 100){
            this.aptidao = 100;
        }
        if (aptidao < 0){
            this.aptidao = 0;
        }
    }

    //introdução do personagem, exibição de status e explicação básica dos ataques da classe
    public void exibirStatus(){
        System.out.println(this.nome +" pegou seu arco e saiu para enfrentar o que tivesse pela floresta, os monstros que viviam por la não eram nada passíveis.");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                               NÍVEL DE PODER");
        System.out.println("Vida máxima: " + this.pontosDeVida);
        System.out.println("Força de ataque: " + this.forca);
        System.out.println("Nível de combate: " + this.nivel);
        System.out.println("Experiencia concedida: " + this.experiencia);
        System.out.println("Aptidão inicial: " + this.aptidao);
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("                                             ATAQUES DISPONÍVEIS");
        System.out.println("Tiro comum causa " + this.forca + " de dano e concedem 10 de aptidão");
        System.out.println("A cada 5 tiros simples, o arqueiro usa ALVO NA MIRA, aumentando sua aptidão para 150, garantindo que os próximos 2 tiros sejam duplos");
        System.out.println("Tiro duplo causa " + this.forca*2 + " de dano e gasta 50 de aptidão");
        System.out.println("                                               EFEITO PASSIVO");
        System.out.println("Curupiras possuem uma chance (baseada na aptidão) de lançarem ataques duplos, aumentando seu dano para 2x");
        System.out.println("####################################################################################################################################");
    }
}
