/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhodeoo;

//Alunos:
//Carlos Eduardo de Souza Duque - Matrícula: 202165502B
//Carlos Gustavo Ferreira Rezende - Matrícula: 202065503B
//Pedro de Araújo Bhering Bittencourt - Matrícula: 202165114A
//Rayane Moraes da Silva - Matrícula: 201565565AC


/**
 *
 * @author pense_4bc3gvu
 */
public class PessoaFis extends Pessoa {
    protected String cpf;
    
    public PessoaFis(String _nome, String _telefone, Endereco _endereco) {
		super(_nome, _telefone, _endereco);
                this.cpf = "";
    }
    
    
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }
    
    public String getCpf()
    {
        return this.cpf;
    }
    
}
