/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.trabalhodeoo;

//Alunos:
//Carlos Eduardo de Souza Duque - Matrícula: 202165502B
//Carlos Gustavo Ferreira Rezende - Matrícula: 202065503B
//Pedro de Araújo Bhering Bittencourt - Matrícula: 202165114A
//Rayane Moraes da Silva - Matrícula: 201565565AC

import Cadastros.*;
import java.util.*;
import InterfacesJFrame.*;
/**
 *
 * @author pense_4bc3gvu
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
public class TrabalhoDeOO {

    public static void imprimeMenu()
    {
        System.out.println("-----Menu de opcoes-----");
        System.out.println("");
        System.out.println("(1) Cadastrar funcionarios; ");
        System.out.println("(2) Atualizar estoque; ");
        System.out.println("(3) Cadastrar cliente; ");
        System.out.println("(4) Realizar pedido;");
        System.out.println("(5) Sair;");
        System.out.println("");
        System.out.print("Digite a opcao desejada: ");
    }
    
    
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
       
        AcessoConta acessoConta = new AcessoConta();
            
        Scanner teclado = new Scanner(System.in);
        String op = "";

        /*Como ainda não foi feito banco de dados, a primeira coisa que o usuário deverá fazer
        será cadastrar um primeiro administrador que será capaz de adicionar os demais funcionários
        podendo ser eles admistradores ou outra função que pode ser definida pelo administrador.
        No entanto, quando for verificado que já há ao mínimo um administrador,essa opção será pulada e aparecerá no menu;
        Como ainda não foi feita a verificação dos dados do banco de dados, que possivelmente será em um arquivo .txt,
        pularemos essa etapa;
        */

        while (!op.equals("5")) {
           imprimeMenu();
           op = teclado.nextLine();
           if (op.equals("1"))
               Cadastro.cdFuncionario();
            else if(op.equals("2"))
                Cadastro.cdEstoque();
            else if(op.equals("3"))
                Cadastro.cdCliente();
           else if(op.equals("4"))
                Cadastro.cdPedido();
           if(!op.equals("1") && !op.equals("2") && !op.equals("3") && !op.equals("4") && !op.equals("5"))
           {
               System.out.println("");
               System.out.println("Opcao invalida...");
               System.out.println("");
           }
        }
    }
}
