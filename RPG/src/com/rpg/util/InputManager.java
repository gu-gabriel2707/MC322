package com.rpg.util;

import java.util.Scanner;

public class InputManager {
    private static Scanner scanner = new Scanner(System.in);

    public static int lerInteiro(String mensagem, int min, int max) {
        int valor;
        while (true) {
            System.out.print(mensagem + " [" + min + "," + max + "]: ");
            
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                
                if (valor >= min && valor <= max) {
                    break;
                } else {
                    System.out.println("Erro: O número precisa estar entre " + min + " e " + max);
                }
            } else {
                System.out.println("Erro: Entrada inválida. Digite um número inteiro.");
                scanner.next();
            }
        }
        scanner.nextLine();
        return valor;
    }

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public static boolean lerSimNao(String mensagem) {
        while (true) {
            String resposta = lerString(mensagem + " (s/n): ").toLowerCase();
            if (resposta.equals("s")) {
                return true;
            } else if (resposta.equals("n")) {
                return false;
            }
            System.out.println("Digite 's' para sim ou 'n' para não");
        }
    }

    public static void esperarEnter(String mensagem) {
        lerString(mensagem);
    }

    public static void fecharScanner() {
        scanner.close();
    }
}