package com.mycompany.trabalhodeoo;

//Alunos:
//Carlos Eduardo de Souza Duque - Matrícula: 202165502B
//Carlos Gustavo Ferreira Rezende - Matrícula: 202065503B
//Pedro de Araújo Bhering Bittencourt - Matrícula: 202165114A
//Rayane Moraes da Silva - Matrícula: 201565565AC

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author pense_4bc3gvu
 */
public class Produto {
    
    private String idProduto;
    private String nomeProduto;
    private String preco;  
    
    public Produto()
    {
       this.idProduto = "";
       this.nomeProduto = "";
       this.preco = "";       
    }
    
    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getIdProduto() {
        return this.idProduto;
    }

    public String getNomeProduto() {
       return this.nomeProduto;
    }

    public String getPreco() {
        return this.preco;
    }

}

