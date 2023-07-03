/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.repositories;

import com.ihammert.core.AbstractUserEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlo
 * @param <T>
 */
public interface UsersRepository <T>{
    String DIRECTORY = "data";
    
  
    public abstract List<T> getAll();
    public AbstractUserEntity getBynome(String nome);
    public AbstractUserEntity getBycpf(String cpf);
    public AbstractUserEntity getBylogin(String login);
    
    public void create(T order);
    
    
    public boolean checkIfExistsName(String nome);  
    public boolean checkIfExistsSenha(String senha);    
    public boolean checkIfExistsCpf(String cpf);
    public boolean checkIfExistslogin(String login);
    
    public abstract void delete(T product);
    

    public void listUsers(); 
    
    
}
