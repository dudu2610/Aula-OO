package com.mycompany.trabalhodeoo;

//Alunos:
//Carlos Eduardo de Souza Duque - Matrícula: 202165502B
//Carlos Gustavo Ferreira Rezende - Matrícula: 202065503B
//Pedro de Araújo Bhering Bittencourt - Matrícula: 202165114A
//Rayane Moraes da Silva - Matrícula: 201565565AC

import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author pense_4bc3gvu
 */
public class Pedido {

    private String idPedido;
    private float valorTotal;
    private String formaPgto;
    private String notaFiscal;
    private Map<Produto, String> listaProdComprados;

    public Pedido() {
        this.idPedido = "2";
        this.valorTotal = 0;
        this.formaPgto = "";
        this.notaFiscal = "";
        this.listaProdComprados = new HashMap<>();
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public void FormaPgto(){
        System.out.println("1 - Dinheiro: ");
        System.out.println("2 - Cartao: ");        
        System.out.println("3 - Cheque: ");    
    }
    
    public void setFormaPgto(String formaPgto) {
        switch(formaPgto)
        {
            case "1":
                this.formaPgto = "Dinheiro";
                break;
            case "2":
                this.formaPgto = "Cartao";
                break;
            case "3":
                this.formaPgto = "Cheque";
                break;
        }
        
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public void setListaProdComprados(Produto produto, String qtd) {
        this.listaProdComprados.put(produto, qtd);
    }

    public Map<Produto, String> getListaProdComprados() {
        return this.listaProdComprados;
    }

    public void setValorTotal() {
        for (Produto product : getListaProdComprados().keySet()){
            this.valorTotal += Float.parseFloat(product.getPreco()) * Integer.parseInt(this.listaProdComprados.get(product));
        }
    }
    
    public String getIdPedido() {
        return this.idPedido;
    }

    public String getFormaPgto() {
        return this.formaPgto;
    }

    public String getNotaFiscal() {
        return this.notaFiscal;
    }
    
    public float getValorTotal() {
        return this.valorTotal;
    }

}
