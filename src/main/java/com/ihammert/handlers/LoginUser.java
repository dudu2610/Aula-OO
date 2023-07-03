/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
*/

package com.ihammert.handlers;
import com.ihammert.core.AbstractUserEntity;
import java.util.*;
import com.ihammert.repositories.JSONUsersRepository;

public class LoginUser {
    
        public static boolean Inicializa(String username, String senha){

        JSONUsersRepository jSONUsersRepository = new JSONUsersRepository();
        List<AbstractUserEntity> users = new ArrayList<>();
        users = jSONUsersRepository.getAll();
        if(users!=null){
        AbstractUserEntity userIsRegistered = jSONUsersRepository.getBylogin(username);
        
        if(userIsRegistered!=null && userIsRegistered.getLogin().equals(username)&&
                userIsRegistered.getSenha().equals(senha))
            return true;  
            
        return false;
        }
        return false;   
        } 
}
        
        