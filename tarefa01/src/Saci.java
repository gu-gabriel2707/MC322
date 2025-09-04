public class Saci extends Heroi {
    public int Type;
    public int mana; //recurso usado para ativar as habilidades

    public Saci(String nome, int pontosDeVida, int forca, int nivel, int experiencia) {
        super(nome, pontosDeVida, forca, nivel, experiencia);
        this.mana = 40; //mana inicial
        this.Type = 0;
    }

    public void atacar(Personagem alvo){
        System.out.println(this.nome + " dá uma voadora em " + alvo.getnome()); //em briga de saci todo chute é voadora
        int dano = this.forca;
        alvo.receberDano(dano);
        this.mana += 10; //meio de recuperar a mana é o ataque comum
    }

    public void usarHabilidadeEspecial(Personagem alvo){
        if(mana >= 30){
            System.out.println(this.nome + " conjura TORNADO em " + alvo.getnome());
            int danoHabilidade = this.forca * 3; //valor do dano da habilidade
            alvo.receberDano(danoHabilidade);
            this.mana -= 30; //gasto da mana para usar habilidade
        }
        else{
            System.out.println(this.nome + " não possúi mana o suficiente para conjurar feitiço poderoso");
            atacar(alvo); //se não tiver mana o suficiente usará um ataque normal
        }
    }

    //introdução do personagem, exibição de status e explicação básica dos ataques da classe
    public void exibirStatus(){
        System.out.println(this.nome +" é o herói travesso que enfrentará esse desafio em uma perna só");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                               NÍVEL DE PODER");
        System.out.println("Vida máxima: " + this.pontosDeVida);
        System.out.println("Força de ataque: " + this.forca);
        System.out.println("Nível de combate: " + this.nivel);
        System.out.println("Experiencia concedida: " + this.experiencia);
        System.out.println("Mana inicial: " + this.mana);
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("                                             ATAQUES DISPONÍVEIS");
        System.out.println("Voadora causa " + this.forca + " de dano e concedem 10 de mana");
        System.out.println("TORNADO é um feitiço poderoso que causa " + this.forca*3);
        System.out.println("                                               EFEITO PASSIVO");
        System.out.println("Sacis conseguem lançar feitiços poderosos, mas devem ter mana o suficiente para isso");
        System.out.println("####################################################################################################################################");
    }
}
