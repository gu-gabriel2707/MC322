import java.util.Random;

public class Curupira extends Heroi{
    public int Type;
    public int aptidao; //variavel utilizada para calcular a chance de acertar um ataque critico (2x o dano)
    public int mana; //recurso usado para ativar as habilidades

    public Curupira(String nome, int pontosDeVida, int forca, int nivel, int experiencia, int expProximoNivel) {
        super(nome, pontosDeVida, forca, nivel, experiencia, expProximoNivel);
        this.Type = 1;
        this.aptidao = 0;
        this.mana = 0;
        arma = new Arco(0,0);
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

    public void atacar(Personagem alvo){
        Random gerador = new Random();
        if(aptidao > gerador.nextInt(100)){ //chance de dar golpe crítico
            System.out.println("Curupira executa um tiro duplo em " + alvo.getnome());
            int dano = this.forca * 2; //valor do golpe crítico
            alvo.receberDano(dano);
            this.aptidao -= 50; //gasto de aptidão por golpe crítico
        }
        else{
            System.out.println("Curupira executa um tiro comum em " + alvo.getnome());
            int dano = this.forca; //dano do ataque comum
            alvo.receberDano(dano);
            this.aptidao += 10;
        }
        this.mana += 10; //recuperação de mana
        AjustarAptidao();
    }

    public void usarHabilidadeEspecial(Personagem alvo){
        if(mana >= 50){
            System.out.println("Curupira está com o ALVO NA MIRA"); 
            this.aptidao = 150; //usar a habilidade garante dois ataques críticos
            this.mana = 0; //gasto de mana
        }
        else{
            System.out.println("Curupira ainda não possui um alvo em sua mira"); //aviso se não houver mana suficiente
        }
        atacar(alvo);
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
