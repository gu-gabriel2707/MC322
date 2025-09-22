// Enum para representar os tipos de cenário, cada um com seus próprios efeitos de acordo com o tipo de heroi
public enum TipoCenario {
    FLORESTA("Uma floresta cheia de desafios e de monstros. Boitatas e Curupiras costumam ser mais fortes nesse tipo de cenário") {
        public void aplicarEfeitos(Heroi heroi) {
            if (heroi instanceof Curupira) {
                Curupira curupira = (Curupira) heroi;
                curupira.forca += 5;
                System.out.println(curupira.getNome() + " recebeu um bônus de 5 de força por estar na floresta!");
                curupira.mana += 20;
                System.out.println(curupira.getNome() + " recebeu 20 de mana adicional por estar na floresta");
            } else {
                heroi.forca -= 5;
                System.out.println(heroi.nome + " perdeu 5 de força por não estar em seu habitat natural");
            }
        }
    },
    RIO("Um rio raso, mas suficiente para se notar diferentes tipos de vida. Botos Rosas e Cucas costumam ser mais fortes nesse tipo de cenário") {
        public void aplicarEfeitos(Heroi heroi) {
            if (heroi instanceof BotoRosa) {
                BotoRosa boto = (BotoRosa) heroi;
                boto.pontosDeVida += 25;
                System.out.println(boto.getNome() + " recebeu um bônus de 25 de força por estar no rio!");
                boto.mana += 20;
                System.out.println(boto.getNome() + " recebeu 20 de mana adicional por estar no rio");
            } else {
                heroi.forca -= 5;
                System.out.println(heroi.nome + " perdeu 5 de força por não estar em seu habitat natural");
                heroi.pontosDeVida -= 10;
                System.out.println(heroi.nome + " perdeu 10 de vida por não estar em seu habitat natural");
            }
        }
    },
    MONTANHAS("Montanhas rochosas e traiçoeiras. Mapinguaris e Saci costumam ser mais fortes nesse tipo de cenário") {
        public void aplicarEfeitos(Heroi heroi) {
            if (heroi instanceof Saci) {
                Saci saci = (Saci) heroi;
                saci.forca += 10;
                System.out.println(saci.getNome() + " recebeu um bônus de 10 de força por estar nas montanhas!");
                saci.pontosDeVida += 30;
                System.out.println(saci.getNome() + " recebeu 30 de vida adicional por estar nas montanhas");
            } else {
                heroi.forca -= 5;
                System.out.println(heroi.nome + " perdeu 5 de força por não estar em seu habitat natural");
                heroi.pontosDeVida -= 5;
                System.out.println(heroi.nome + " perdeu 15 de vida por não estar em seu habitat natural");
            }
        }
    };

    private final String descricao;

    TipoCenario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract void aplicarEfeitos(Heroi heroi);
}

