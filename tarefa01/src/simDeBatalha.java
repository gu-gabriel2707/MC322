public class simDeBatalha {
    public static int batalha(Curupira heroi,  Monstro monstros){
        monstros.exibirStatus();
        for(;;){
            if(((heroi.Type == 0)&&(heroi.mana >= 30))||((heroi.Type == 1)&&(heroi.mana >= 50))){ //Verificando se a habilidade custa 30 ou 50 de mana
                heroi.usarHabilidadeEspecial(monstros);
                System.out.println("HP Monstro: " + monstros.pontosDeVida);
            }else{
                heroi.atacar(monstros);
                System.out.println("HP Monstro: " + monstros.pontosDeVida);
            }
            if(monstros.pontosDeVida > 0){ 
                monstros.atacar(heroi); // Monstro ataca
                System.out.println("HP Herói: " + heroi.pontosDeVida);
            }else{
                heroi.ganharExperiencia(monstros.xpConcedido);
                if (monstros.arma.getDano() > heroi.arma.getDano())
                    heroi.equiparArma(monstros.arma);
                return 1; //Retorna 1 pois o monstro morreu
            }
            if(heroi.pontosDeVida <= 0){ //heroi morreu
                System.out.println("Game Over");
                return 0; //Retorna 0 pois o herói morreu
            }
        }
    }
}
