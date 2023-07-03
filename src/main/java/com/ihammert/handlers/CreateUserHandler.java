/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
*/

package com.ihammert.handlers;
import com.ihammert.core.AbstractUserEntity;
import com.ihammert.entities.Adm;
import com.ihammert.entities.Atendente;
import com.ihammert.entities.Estoquista;
import com.ihammert.repositories.*;
import java.util.*;
import javax.swing.JOptionPane;

public class CreateUserHandler {
    
    public  static void handleAdm(String nome, String telefone,String cpf,String cargo,String email,String login,String senha){
        try{
            JSOMAdm jSONUsersRepository = new JSOMAdm();
            boolean UserIsRegistered = jSONUsersRepository.checkIfExistsCpf(cpf);
            Adm newUser = new Adm(nome, telefone, cpf, cargo, email, login, senha);
            
            if (UserIsRegistered== true)
                printUserExists();               
           
           else{
               jSONUsersRepository.create(newUser);
           }           
           

        }catch(Exception err){
            System.out.println("Erro: " + err.getMessage());
        }
    }
    
    public  static void handleAtendente(String nome, String telefone,String cpf,String cargo,String email,String login,String senha){
        try{
            JSONAtendente jSONUsersRepository = new JSONAtendente();
            boolean UserIsRegistered = jSONUsersRepository.checkIfExistsCpf(cpf);
            Atendente newUser = new Atendente(nome, telefone, cpf, cargo, email, login, senha) {};
            
            if (UserIsRegistered== true)
                printUserExists();               
           
            else{
                jSONUsersRepository.create(newUser);
           }           
           

        }catch(Exception err){
            System.out.println("Erro: " + err.getMessage());
        }
        
    }
    
    public  static void handleEstoquista(String nome, String telefone,String cpf,String cargo,String email,String login,String senha){
        try{
            JSONEstoquista jSONUsersRepository = new JSONEstoquista();
            boolean UserIsRegistered = jSONUsersRepository.checkIfExistsCpf(cpf);
            Estoquista newUser = new Estoquista(nome, telefone, cpf, cargo, email, login, senha);
            
            if (UserIsRegistered== true)
                printUserExists();               
           
           else{
               jSONUsersRepository.create(newUser);
           }           
           

        }catch(Exception err){
            System.out.println("Erro: " + err.getMessage());
        }
    }
    public static void printUserExists(){
         JOptionPane.showMessageDialog(null, "User já está cadastrado!", null, 0);
    }
}

    

