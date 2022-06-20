/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.teste;

import java.util.Scanner;

/**
 *
 * @author ice
 */
public class jogarbingo {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int i = 0;
        int numero_jogador;

        System.out.println("Boas vindas ao nosso bingo");
        System.out.println("digite quantas pessoas irão jogar ");
        int jogadores = teclado.nextInt();

        Bingo[] a = new Bingo[jogadores];
        
        while (i == 0) {
            System.out.println("DIGITE O NÚMERO DO JOGADOR PARA VER SUA CARTELA ou -1 PARA SAIR");
            numero_jogador=teclado.nextInt();
            
            if(numero_jogador>0){
                a[numero_jogador-1] = new Bingo();
                a[numero_jogador-1].print_cartela(); 
            }
            else
                 i=1;
                   
        }
    }

}
