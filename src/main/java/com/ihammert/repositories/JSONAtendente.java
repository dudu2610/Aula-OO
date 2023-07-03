/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ihammert.repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ihammert.core.AbstractUserEntity;
import com.ihammert.entities.Atendente;
import static com.ihammert.repositories.UsersRepository.DIRECTORY;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ice
 */
public class JSONAtendente implements UsersRepository<Atendente>{

    private static final String PATH = DIRECTORY+ File.separator +"usersAtendente.json";
    private String json;
    
    @Override
    public List getAll() {
        Gson gson = new Gson();
        
        json = FileOperations.read(PATH);

        List<Atendente> users = new ArrayList<>();
        if(!json.trim().equals("")) {

            Type tipoLista = new TypeToken<List<Atendente>>() {
            }.getType();
            users = gson.fromJson(json, tipoLista);

            if (users == null)
                users = new ArrayList<>();
        }

        return users;    }
    

    @Override
    public void create(Atendente user) {
        Gson gson = new Gson();
        
        List<Atendente> usersContent = this.getAll();
        
        if (usersContent == null) {
            List<Atendente> users = new ArrayList<>();
            users.add(user);
            gson.toJson(users);
        } else {
            List<Atendente> users = this.getAll();
            users.add(user);
            this.json = gson.toJson(users);
        }

        File diretorio = new File(DIRECTORY);
        if(!diretorio.exists())
            diretorio.mkdirs();

        FileOperations.write(PATH, json);
    }
    
    @Override
    public boolean checkIfExistslogin(String login) {
        List<Atendente> users = this.getAll();
        if(users!=null)
        for (Atendente user : users) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
    return false;
    }
    
    @Override
    public Atendente getBylogin(String login) {
        List<Atendente> users = this.getAll();
        if(users!=null)
        for (Atendente user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }

    return null;
    }
    
    @Override
    public boolean checkIfExistsName(String nome) {
        List<Atendente> users = this.getAll();
        if(users!=null)
        for (Atendente user : users) {
            if (user.getNome().equals(nome)) {
                return true;
            }
        }
    return false;
    }
    
     @Override
    public boolean checkIfExistsSenha(String senha) {
        List<Atendente> users = this.getAll();
        if(users!=null)
        for (Atendente user : users) {
            if (user.getSenha().equals(senha)) {
                return true;
            }
        }
    return false;
    }
    
    @Override
    public boolean checkIfExistsCpf(String cpf) {
        List<Atendente> users = this.getAll();
        if(users!=null)
        for (Atendente user : users) {
            if (user.getCpf().equals(cpf)) {
                return true;
            }
        }
    return false;
    }
     
    @Override
    public Atendente getBynome(String nome) {
        List<Atendente> users = this.getAll();
        if(users!=null)
        for (Atendente user : users) {
            if (user.getNome().equals(nome)) {
                return user;
            }
        }

    return null;
    }
    
    @Override
    public Atendente getBycpf(String cpf) {
        List<Atendente> users = this.getAll();
        if(users!=null)
        for (Atendente user : users) {
            if (user.getCpf().equals(cpf)) {
                return user;
            }
        }

    return null;
    }
    
    @Override
    public void listUsers() {
        List<Atendente> users = this.getAll();
        if(users!=null)
        for (Atendente user : users) {
            System.out.println("    Nome:" + user.getNome());
        }
    }
    
    @Override
    public void delete(Atendente user) {
        Gson gson = new Gson();

        List<Atendente> userContent = this.getAll();

        List<Atendente> users = new ArrayList<>();

        for (Atendente item : userContent) {
            if (item.getCpf() != user.getCpf()) {
                users.add(item);
            }
        }

        this.json = gson.toJson(users);

        File dir = new File(DIRECTORY);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        FileOperations.write(PATH, json);
    }
    
}
