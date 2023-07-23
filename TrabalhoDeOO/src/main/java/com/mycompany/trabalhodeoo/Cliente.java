package com.mycompany.trabalhodeoo;

//Alunos:
//Carlos Eduardo de Souza Duque - Matrícula: 202165502B
//Carlos Gustavo Ferreira Rezende - Matrícula: 202065503B
//Pedro de Araújo Bhering Bittencourt - Matrícula: 202165114A
//Rayane Moraes da Silva - Matrícula: 201565565AC

import java.util.HashMap;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author pense_4bc3gvu
 */
public class Cliente extends Pessoa {

    private Map<PessoaFis, String> listadeClientesFis;
    private Map<PessoaJur, String> listadeClientesJur;
    private String tipoCliente;

    public Cliente(String _nome, String _telefone, Endereco _endereco) {
        super(_nome, _telefone, _endereco);
        this.listadeClientesFis = new HashMap<>();
        this.listadeClientesJur = new HashMap<>();
        this.tipoCliente = "";
    }

    public void setListaClientesPessoasFisicas(PessoaFis pessoa, String tipo) {
        this.listadeClientesFis.put(pessoa, tipo);
    }

    public Map<PessoaFis, String> getListaClientesPessoasFisicas() {
        return this.listadeClientesFis;
    }

    public void setListaClientesPessoasJuridicas(PessoaJur pessoa, String tipo) {
        this.listadeClientesJur.put(pessoa, tipo);
    }

    public Map<PessoaJur, String> getListaClientesPessoasJuridicas() {
        return this.listadeClientesJur;
    }
    
    public void setTipo(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getTipo() {
        return this.tipoCliente;
    }

}
