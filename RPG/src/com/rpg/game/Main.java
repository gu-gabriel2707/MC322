package com.rpg.game;

import com.rpg.cenario.*;
import com.rpg.itens.Arma;
import com.rpg.personagens.herois.*;
import com.rpg.personagens.monstros.Monstro;
import com.rpg.util.InputManager;

public class Main {

    public static void main(String[] args){
        while(true){
            System.out.println("\n########################################################################################################");
            System.out.println("                                      RPG - LENDAS DO FOLCLORE");
            System.out.println("########################################################################################################");
            System.out.println("[1] Iniciar Novo Jogo");
            System.out.println("[2] Ver Informações dos Heróis");
            System.out.println("[3] Ver Informações dos Monstros");
            System.out.println("[4] Sair do Jogo");

            int menu = InputManager.lerInteiro("Digite sua opção: ", 1, 4);

            if(menu == 4){
                System.out.println("Você saiu do jogo. As lendas aguardarão seu retorno!");
                InputManager.fecharScanner();
                break;
            }
            if(menu == 2){
                System.out.println("\n--- HERÓIS DISPONÍVEIS ---");
                System.out.println("Curupira: Arqueiro ágil e forte das matas.");
                System.out.println("Boto Rosa: Lutador dos rios que consegue se curar.");
                System.out.println("Saci: Mago travesso com poderes sobrenaturais.");
                InputManager.esperarEnter("\nPressione ENTER para voltar ao menu...");
                continue; 
            }
            if(menu == 3){
                System.out.println("\n--- MONSTROS DAS LENDAS ---");
                System.out.println("Mapinguari: Fera colossal das profundezas da floresta.");
                System.out.println("Boitatá: Serpente de fogo que protege os campos.");
                System.out.println("Cuca: Bruxa temível com poderes de jacaré.");
                InputManager.esperarEnter("\nPressione ENTER para voltar ao menu...");
                continue;
            }
            
            // --- INÍCIO DO JOGO (se a opção for 1) ---
            
            System.out.println("\n--- ESCOLHA SEU HERÓI ---");
            System.out.println("[1] Curupira");
            System.out.println("[2] Boto Rosa");
            System.out.println("[3] Saci");
            int escolhaHeroi = InputManager.lerInteiro("Opção >", 1, 3);

            Heroi heroi = null;
            // Mantendo seus valores originais para os heróis
            if(escolhaHeroi == 1) {
                heroi = new Curupira("Moonwalk pra Frente", 220, 40, 1,0,100);
            } else if(escolhaHeroi == 2){
                heroi = new BotoRosa("Boto Nada Suspeito", 150, 30, 1, 0, 100);
            } else if(escolhaHeroi == 3){
                heroi = new Saci("Chute é Voadora", 180, 50, 1, 0, 100);
            }

            System.out.println("\n--- SELECIONE A DIFICULDADE ---");
            System.out.println("[1] Fácil");
            System.out.println("[2] Normal");
            System.out.println("[3] Difícil");

            int escolhaDif = InputManager.lerInteiro("Opção >", 1, 3);
            Dificuldade dificuldade = Dificuldade.NORMAL;
            if (escolhaDif == 1) dificuldade = Dificuldade.FACIL;
            if (escolhaDif == 3) dificuldade = Dificuldade.DIFICIL;

            GeradorDeFases gerador = new ConstrutorDeCenario();
            int n = 3;
            Fase[] fases = gerador.gerar(n, dificuldade);

            System.out.println("\nEra apenas mais um dia comum na floresta, Ainda ouço os gritos daqueles que ousam não acreditar nas grandes lendas do folclore brasileiro");
            System.out.println("\"Já chega disso\" disse " + heroi.getNome() + " \"Não posso viver com medo, preciso ver eles com meus próprios olhos, afinal, apenas eu posso salvar essa aldeia\"");
            System.out.println(heroi.getNome() +" decidiu que era hora de se arriscar e liberar seu povo.");

            heroi.exibirStatus(); 
            InputManager.esperarEnter("Pressione ENTER para iniciar o jogo...");
            
            boolean heroiFoiDerrotado = false;
            for (Fase faseAtual : fases) {
                System.out.println("\n########################################################################################################");
                System.out.println("                                      INICIANDO FASE: " + faseAtual.getTipoDeCenario());
                System.out.println("########################################################################################################");
                faseAtual.getTipoDeCenario().aplicarEfeitos(heroi);

                for (Monstro monstroAtual : faseAtual.getMonstros()) {
                    boolean vitoriaNaBatalha = SimDeBatalha.batalha(heroi, monstroAtual);

                    if (!vitoriaNaBatalha) {
                        heroiFoiDerrotado = true;
                        break; // Herói morreu, sai do loop de monstros
                    }
                    
                    System.out.println("\n>> Você derrotou " + monstroAtual.getNome() + "! <<");
                    heroi.ganharExperiencia(monstroAtual.getXpConcedido());
                    
                    Arma armaDropada = monstroAtual.droparLoot();
                    
                    if (armaDropada != null) {
                        boolean desistiu = exibirMenuPosCombate(heroi, armaDropada);
                        if (desistiu) {
                            heroiFoiDerrotado = true; // Trata desistência como derrota
                            break;
                        }
                    }
                }
                
                if (heroiFoiDerrotado) {
                    break; // Sai do loop de fases
                }
                
                System.out.println("\n----- VOCÊ COMPLETOU A FASE: " + faseAtual.getTipoDeCenario() + "! -----");
                heroi.exibirStatus();
                InputManager.esperarEnter("Pressione ENTER para prosseguir...");
            }

            if (heroiFoiDerrotado) {
                System.out.println("\n########################################################################################################");
                System.out.println("                                      GAME OVER!");
                System.out.println("                  O herói foi valente, mas sucumbiu às lendas do folclore...");
                System.out.println("########################################################################################################");
            } else {
                System.out.println("\n\"Eu consegui\" disse " + heroi.getNome() + "\"finalmente libertei meu povo, vou contar a todos sobre todas as lendas das quais enfrentei\"");
                System.out.println("Parabéns por sobreviver a todos os desafios herói! Este é o fim de sua batalha...Por enquanto");
            }
            InputManager.esperarEnter("\nPressione ENTER para voltar ao menu principal...");
        } 
    }

    private static boolean exibirMenuPosCombate(Heroi heroi, Arma armaDropada) {
        System.out.println("O inimigo dropou: " + armaDropada.getNome() + " (Dano: +" + armaDropada.getDano() + ")");
        
        while(true) {
            System.out.println("\n--- O que fazer? ---");
            System.out.println("[1] Tentar Equipar a Arma");
            System.out.println("[2] Ver Status do Herói");
            System.out.println("[3] Ignorar Item e Continuar");
            System.out.println("[4] Desistir do Jogo");

            int escolha = InputManager.lerInteiro("Opção >", 1, 4);

            switch (escolha) {
                case 1:
                    heroi.exibirStatus();
                    InputManager.esperarEnter("Pressione ENTER para voltar...");
                    break;
                case 2:
                    System.out.println("Você deixou o item para trás.");
                    return false; // Sai do menu pós-combate
                case 3:
                    if (InputManager.lerSimNao("Tem certeza que deseja desistir?")) {
                        return true; // Sinaliza que o jogador desistiu
                    }
                    break;
            }
        }
    }
}