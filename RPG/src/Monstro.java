import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public abstract class Monstro extends Personagem implements Lootavel{
    protected int xpConcedido;
    protected List<AcaoDeCombate> acoes;

    public Monstro(String nome, int pontosDeVida, int forca, int xpConcedido) {
        super(nome, pontosDeVida, forca);
        this.xpConcedido = xpConcedido;
        this.acoes = new ArrayList<>();
        acoes.add(new AtaqueMonstro());
        acoes.add(new AtaqueEspMonstro());
    }
    public void escolherAcao(Combatente alvo){ //Como aqui será uma IA que controlará, fizemos uma verificação para cada monstro, se ele tiver recurso suficiente para usar a habilidade especial, ele a usará, senão usará o ataque normal
        if (this instanceof Cuca){
            Cuca cuca = (Cuca) this;
            if(cuca.mana >= 30)
                acoes.get(1).executar(this, alvo);
            else
                acoes.get(0).executar(this, alvo);
        }else{
            if(this instanceof Mapinguari){
                Mapinguari mapinguari = (Mapinguari) this;
                if(mapinguari.Raiva >= 50)
                    acoes.get(1).executar(this, alvo);
                else
                    acoes.get(0).executar(this, alvo);
            }else
                acoes.get(0).executar(this, alvo);
        }
    }
    public void ganhaArma(){ //Monstros tem chances específicas para conseguirem suas armas específicas, com uma chance também de ficarem sem nenhuma arma que sera retratada como uma arma de dano 0
        Random gerador = new Random();
        int chance = gerador.nextInt(1000);
        if(chance <= 300){
            if (this instanceof Boitatá)   
                this.arma = new Arco(15, 2, "Arco Flamejante");
            if (this instanceof Cuca)
                this.arma = new Cajado(20, 3, "Cajado Escamoso");
            if (this instanceof Mapinguari)
                this.arma = new Espada(25, 4, "Espada de Dentes");
        }if(chance > 300 && chance <= 500){
            if (this instanceof Boitatá)   
                this.arma = new Arco(30, 4, "Espada Flamejante");
            if (this instanceof Cuca)
                this.arma = new Cajado(20, 2, "Arco de Escamas");
            if (this instanceof Mapinguari)
                this.arma = new Espada(15, 2, "Cajado de Ossos");
        }if(chance > 500 && chance <= 700){
            if (this instanceof Boitatá)   
                this.arma = new Arco(30, 4, "Cajado Solar");
            if (this instanceof Cuca)
                this.arma = new Cajado(20, 3, "Espada de Jacaré");
            if (this instanceof Mapinguari)
                this.arma = new Espada(20, 3, "Arco de Ossos");
        }else{
            this.arma = new Espada(0, 0, "Nenhuma arma");
        }
    }
    public String getArma(){
        if(this.arma != null){
            return "O monstro está utilizando um(a) " + this.arma.getNome();
        }else{
            return "O monstro não tem nenhuma arma";
        }
    }
    public Arma droparLoot(){ //Chance de dropar a arma que está equipada, 50% de chance
        Random gerador = new Random();
        int chance = gerador.nextInt(100);
        if (chance <= 50 && this.arma != null){
            System.out.println(this.nome + " dropou a arma: " + this.arma.getNome());
            return this.arma;
        }
        else{
            System.out.println(this.nome + " não dropou nenhuma arma");
            return null;
        }
    }
}

