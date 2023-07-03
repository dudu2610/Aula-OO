package com.ihammert.screens;

import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private int numero;
    private List<Produto> produtos;

    public Comanda(int numero) {
        this.numero = numero;
        this.produtos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public double getTotal() {
        double total = 0.0;
        for (Produto produto : produtos) {
            double valor = (double) produto.getPreco();
            int quantidade = (int) produto.getQuantidade();
            total += valor * quantidade;
        }
        return total;
    }
}
