/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */


package com.ihammert.utils;

import java.util.Scanner;
import java.text.DecimalFormat;

public class PaymentAuth {

    double value = 0;
    boolean invalid = true;

    enum CardMethod {
        DEBIT,
        CREDIT
    }

    public PaymentAuth(double value) {
        this.value = value;
    }

    public boolean handleAuthCard() {
        Scanner cardMachine = new Scanner(System.in);

        System.out.println("Qual o tipo de cartao? (DEBIT ou CREDIT)");
        CardMethod cardMethod = CardMethod.valueOf(cardMachine.next().toUpperCase());

        String bufferHandler = cardMachine.nextLine();
        
        do {
            if (cardMethod == CardMethod.DEBIT) {
                System.out.println("Cartao de debito selecionado!");
                System.out.println("Digite os numeros do cartao,  ou x para sair: ");
                String numbers = cardMachine.nextLine();
                System.out.println("Digite a senha do cartao, ou x para sair: ");
                String password = cardMachine.nextLine();

                if (numbers.length() == 16 && password.length() == 6) {
                    System.out.println("Pagamento efetuado com sucesso!");
                    this.invalid = false;
                } else if (numbers.equals("x") || password.equals("x")) {
                    return false;
                } else {
                    System.out.println("Dados do cartao invalidos");
                }

            } else if (cardMethod == CardMethod.CREDIT) {
                System.out.println("Cartao de credito selecionado!");
                System.out.println("Digite os numeros do cartao,  ou x para sair: ");
                String numbers = cardMachine.nextLine();
                System.out.println("Digite a senha do cartao, ou x para sair: ");
                String password = cardMachine.nextLine();

                if (numbers.length() == 16 && password.length() == 4) {
                    System.out.println("Pagamento efetuado com sucesso!");
                    this.invalid = false;
                } else if (numbers.equals("x") || password.equals("x")) {
                    return false;
                } else {
                    System.out.println("Dados do cartao invalidos");
                }
            }
        } while (invalid);

        return true;

    }

    public boolean handleCash() {
        Scanner cashier = new Scanner(System.in);

        do {
            System.out.println("Pagamento  em dinheiro selecionado!");
            System.out.println("Total: " + this.value + ", troco para quanto?");
            double payment = cashier.nextFloat();
            double change = payment - this.value;

            if (change < 0) {
                System.out.println();
                System.out.println("Valor recebido insuficiente!");
                System.out.println();

                this.invalid = true;
            } else {
                DecimalFormat floatFormatter = new DecimalFormat("0.00");

                System.out.println("Troco para devolver: " + floatFormatter.format(change));
                boolean notPayed = true;
                System.out.println();

                String bufferHandler = cashier.nextLine();

                do {
                    System.out.println("Confirmar pagamento? (S/N)");
                    String action = cashier.nextLine();

                    if (action.equals("S") || action.equals("s")) {
                        System.out.println();
                        System.out.println("Pagamento efetuado com sucesso!");

                        notPayed = false;
                        invalid = false;
                    } else {
                        System.out.println();
                        System.out.println("Aguardando confirmaçao do pagamento...");
                        System.out.println();

                    }
                } while (notPayed);
            }

        } while (invalid);

        return true;
    }
}