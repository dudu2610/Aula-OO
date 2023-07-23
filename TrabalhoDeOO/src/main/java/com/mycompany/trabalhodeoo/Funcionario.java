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
import java.util.*;

/**
 *
 * @author pense_4bc3gvu
 */
public class Funcionario extends Pessoa {

    private Map<PessoaFis, String> listadeFuncsFis;
    private Map<PessoaJur, String> listadeFuncsJur;
    private String tipoFuncionario;

    public Funcionario(String _nome, String _telefone, Endereco _endereco) {
        super(_nome, _telefone, _endereco);
        this.listadeFuncsFis = new HashMap<>();
        this.listadeFuncsJur = new HashMap<>();
        this.tipoFuncionario = "";
    }

    public void setListaFuncsPessoasFisicas(PessoaFis pessoa, String tipo) {
        this.listadeFuncsFis.put(pessoa, tipo);
    }

    public Map<PessoaFis, String> getListaFuncsPessoasFisicas() {
        return this.listadeFuncsFis;
    }

    public void setListaFuncsPessoasJuridicas(PessoaJur pessoa, String tipo) {
        this.listadeFuncsJur.put(pessoa, tipo);
    }

    public Map<PessoaJur, String> getListaFuncsPessoasJuridicas() {
        return this.listadeFuncsJur;
    }

    public void setTipo(String tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public String getTipo() {
        return this.tipoFuncionario;
    }

}
