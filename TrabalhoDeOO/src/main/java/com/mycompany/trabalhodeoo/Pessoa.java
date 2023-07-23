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
public class Pessoa {

    protected String nome;
    protected String telefone;
    protected Endereco endereco;

    
    public Pessoa(String _nome, String _telefone, Endereco _endereco)
    {
       this.nome = "";
       this.telefone = "";
       this.endereco = new Endereco();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }
}
