/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
*/

package com.ihammert.core;
import java.security.SecureRandom;

public abstract class AbstractUserEntity {

    private String nome;
    private String telefone;
    private String cpf;
    private String senha;
    private String email;
    public int cargologin=1;
    private String cargo;
    private String login;

    public AbstractUserEntity(String nome, String telefone, String cpf,String cargo, String email, String login,String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
        this.cargo = cargo;
        this.login = login;
    }
    
    @Override
    public String toString() {
        return nome + " - " + cargo;
    }

   public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

}
