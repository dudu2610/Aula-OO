/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ihammert.entities;

import com.ihammert.core.AbstractUserEntity;

/**
 *
 * @author carlo
 */
public class Adm extends AbstractUserEntity {

    public Adm(String nome, String telefone, String cpf, String cargo, String email, String login, String senha) {
        super(nome, telefone, cpf, cargo, email, login, senha);
        super.cargologin =1;
    }
   
}
