/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.teste;

import java.text.DecimalFormat;

/**
 *
 * @author ice
 */
public class Bingo {

    DecimalFormat df = new DecimalFormat("00");

    private static double numero_cartela = 0;

    private int[][] cartela = new int[5][5];

    public Bingo() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0) {
                    cartela[j][i] = (int) (15 * Math.random());
                }

                if (i == 1) {
                    cartela[j][i] = (int) (16 + Math.random() * 14);
                }

                if (i == 2) {
                    cartela[j][i] = (int) (31 + Math.random() * 14);
                }

                if (i == 3) {
                    cartela[j][i] = (int) (46 + Math.random() * 14);
                }

                if (i == 4) {
                    cartela[j][i] = (int) (61 + Math.random() * 14);
                }

            }
            numero_cartela++;
        }
    }

    public void print_cartela() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 2 && j == 2) {
                    System.out.print("$$ ");
                } else {
                    String s = df.format(cartela[i][j]);
                    System.out.print(s + " ");
                }

            }
            System.out.println("");
        }
        System.out.println("");
    }
}
