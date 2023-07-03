/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
*/

package com.ihammert.handlers;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CdUser {
    public static boolean verificaNum(String numero) {

        if (numero == null || numero.length() == 0) {
            System.out.println("Vazio...");
            return false;
        }
        try {
            Double.parseDouble(numero);
            if(Double.parseDouble(numero) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    public static String validarCPF(String cpf) {
        cpf = cpf.replaceAll("\\D", ""); // Remove caracteres não numéricos

        if (cpf.length() != 11) {
            return "CPF inválido";
        }

        if (cpf.matches("(\\d)\\1*")) {
            return "CPF inválido";
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 > 9) {
            digito1 = 0;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 > 9) {
            digito2 = 0;
        }

        if (Character.getNumericValue(cpf.charAt(9)) != digito1 || Character.getNumericValue(cpf.charAt(10)) != digito2) {
            return "CPF inválido";
        }

        return "CPF válido";
    }

    public static String validarTelefone(String telefone) {
        telefone = telefone.replaceAll("\\D", ""); // Remove caracteres não numéricos

        if (telefone.length() < 10 || telefone.length() > 11) {
            return "Telefone inválido";
        }

        return "Telefone válido";
    }

    public static String validarEmail(String email) {
        String regex = "^[\\w.-]+@[\\w.-]+\\.[\\w]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            return "Email inválido";
        }

        return "Email válido";
    }

 

    public static boolean verificaSoLetra(String palavra) {
        if (palavra == null || palavra.length() == 0) {
            System.out.println("Vazio...");
            return false;
        }

        if (palavra.length() == 1) {
            return !verificaNum(palavra);
        }

        for (int i = 0; i < palavra.length(); i++) {
            if (verificaNum(palavra.substring(i, i + 1))) {
                return false;
            }
        }

        return true;

    }
    
    public static void Cadastro() {
         
    }
    
    
}
