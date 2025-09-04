public class Main {

    public static void main(String[] args) throws Exception {
        Curupira heroi = new Curupira("Moonwalk pra Frente", 100, 40, 1, 0); //Aqui o heroi é escolhido, podendo ser um objeto de classe Curupira, Saci ou BotoRosa

        Monstro[] monstros = new Monstro[3]; //Os monstros serão escolhidos, podendo ser Cuca, Mapinguari ou Boitatá
        monstros[0] = new Boitatá("Boitatá, A Cobra Flamejante", 50, 10, 0);
        monstros[1] = new Cuca("Cuca, A Bruxa", 30, 12, 0);
        monstros[2] = new Mapinguari("Mapinguari, O Bixo Feio", 200, 20, 0);
        
        //Essa "lore" provavelmente será alterada em breve, nessa primeira tarefa os dev's não pensaram em nada legal.
        System.out.println("Era apenas mais um dia comum na floresta, Ainda ouço os gritos daqueles que ousam não acreditar nas grandes lendas do folclore brasileiro");
        System.out.println("\"Já chega disso\" disse " + heroi.nome + " \"Não posso viver com medo, preciso ver eles com meus próprios olhos, afinal, apenas eu posso salvar essa aldeia\"");
        System.out.println(heroi.nome +" decidiu que era hora de se arriscar e liberar seu povo.");
        heroi.exibirStatus();
        System.out.println("O primeiro desafio a aparecer em sua frente é:");

        monstros[0].exibirStatus(); //Exibe status do primeiro monstro

        System.out.println("A batalha está prestes a começar.");

        /*A batalha ocorrerá dentro dos "for", com os heróis utilizando seu ataque especial sempre que disponível e sendo seguido com uma rodada de ataque do herói seguido do ataque do monstro
         * Caso a vida do herói chegue a 0, sera exibido a mensagem de "Game Over" e o programa se encerrará
         * Caso a vida do monstro chegue a 0, seguiremos para a próxima batalha
        */

        for(;;){
            if(((heroi.Type == 0)&&(heroi.mana >= 30))||((heroi.Type == 1)&&(heroi.mana >= 50))){ //Verificando se a habilidade custa 30 ou 50 de mana
                heroi.usarHabilidadeEspecial(monstros[0]);
            }else{
                heroi.atacar(monstros[0]);
            }
            if(heroi.pontosDeVida <= 0){ //heroi morreu
                System.out.println("Game Over");
                return; //encerra tudo
            }
            if(monstros[0].pontosDeVida > 0){ //monstro morreu
                monstros[0].atacar(heroi);
            }else{
                break; //sai do looping
            }
        }
        
        System.out.println(heroi.getnome() + " Ainda possui " + heroi.pontosDeVida + ", mas segunda batalha fica logo adiante, no momento em que mais um monstro aparece em sua frente:");
        monstros[1].exibirStatus();
        for(;;){
            if(((heroi.Type == 0)&&(heroi.mana >= 30))||((heroi.Type == 1)&&(heroi.mana >= 50))){
                heroi.usarHabilidadeEspecial(monstros[1]);
            }else{
                heroi.atacar(monstros[1]);
            }
            if(heroi.pontosDeVida <= 0){
                System.out.println("Game Over");
                return;
            }
            if(monstros[1].pontosDeVida > 0){
                monstros[1].atacar(heroi);
            }else{
                break;
            } 
        }

        System.out.println("A terceira e última batalha está na frente de " + heroi.getnome() + ", ele respira fundo e segue em frente, mesmo tendo " + heroi.pontosDeVida + " de vida");
        monstros[2].exibirStatus();
        for(;;){
            if(((heroi.Type == 0)&&(heroi.mana >= 30))||((heroi.Type == 1)&&(heroi.mana >= 50))){
                heroi.usarHabilidadeEspecial(monstros[2]);
            }else{
                heroi.atacar(monstros[2]);
            }
            if(heroi.pontosDeVida <= 0){
                System.out.println("Game Over");
                return;
            }
            if(monstros[2].pontosDeVida > 0){
                monstros[2].atacar(heroi);
            }else{
                break;
            }
        }

        //caso o herói vença todas as batalhas ele será parabenizado... Pelo menos por enquanto.
        System.out.println("\"Eu consegui\" disse " + heroi.nome + "\"finalmente libertei meu povo, vou contar a todos sobre todas essas lendas das quais enfrentei\"");
        System.out.println("Parabéns por sobreviver a todos os desafios herói! Este é o fim de sua batalha...Por enquanto");
    }
}