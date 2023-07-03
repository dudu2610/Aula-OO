package com.ihammert.screens;

//Substituida pela classa User.
public class Funcionario {
    private String nome;
    private String telefone;
    private String cpf;
    private String endereco;
    private String cargo;
    private String senha;
    private String login;

    public Funcionario(String nome, String telefone, String cpf, String endereco, String cargo, String login, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getSenha() {
        return cargo;
    }

    public void setSenha(String cargo) {
        this.cargo = cargo;
    }
    public String getLogin() {
        return cargo;
    }

    public void setLogin(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return nome + " - " + cargo;
    }
}