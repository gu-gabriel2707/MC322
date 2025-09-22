public class Main {

    public static void main(String[] args) throws Exception {
        Curupira heroi = new Curupira("Moonwalk pra Frente", 220, 40, 1, 0, 100); //Aqui o heroi é escolhido, podendo ser um objeto de classe Curupira, Saci ou BotoRosa
        int n = 3; // Número de fases que o herói irá enfrentar

        FaseDeCombate[] fases = new FaseDeCombate[n]; //"playlist" de fases
        GeradorDeFases gerador = new ConstrutorDeCenario(); // Objeto que gera as fases

        fases = gerador.gerar(n); //Geração das fases

        //Essa "lore" provavelmente será alterada em breve, nessa primeira tarefa os dev's não pensaram em nada legal.
        System.out.println("Era apenas mais um dia comum na floresta, Ainda ouço os gritos daqueles que ousam não acreditar nas grandes lendas do folclore brasileiro");
        System.out.println("\"Já chega disso\" disse " + heroi.nome + " \"Não posso viver com medo, preciso ver eles com meus próprios olhos, afinal, apenas eu posso salvar essa aldeia\"");
        System.out.println(heroi.nome +" decidiu que era hora de se arriscar e liberar seu povo.");

        heroi.exibirStatus(); //Exibição do status do herói escolhido

        /*A batalha ocorrerá dentro dos "for", com os heróis utilizando seu ataque especial sempre que disponível e sendo seguido com uma rodada de ataque do herói seguido do ataque do monstro
         * Caso a vida do herói chegue a 0, sera exibido a mensagem de "Game Over" e o programa se encerrará
         * Caso a vida do monstro chegue a 0, seguiremos para a próxima batalha
        */
        for (int i = 0 ; i<n ; i++){
            System.out.println("Uma nova fase se inicia, o herói esta full life novamente");
            if(fases[i].iniciar(heroi) == 0){ //Se o heroi morrer o jogo acaba
                System.out.println("GAME OVER");
                return;
            }
            heroi.pontosDeVida += 220 + 20*heroi.nivel; //Recuperação de vida do herói após cada fase
        }
        //caso o herói vença todas as batalhas ele será parabenizado... Pelo menos por enquanto.
        System.out.println("\"Eu consegui\" disse " + heroi.nome + "\"finalmente libertei meu povo, vou contar a todos sobre todas essas lendas das quais enfrentei\"");
        System.out.println("Parabéns por sobreviver a todos os desafios herói! Este é o fim de sua batalha...Por enquanto");
    }
}
