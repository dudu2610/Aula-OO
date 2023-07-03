/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ihammert.repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ihammert.core.AbstractUserEntity;
import com.ihammert.entities.Adm;
import static com.ihammert.repositories.UsersRepository.DIRECTORY;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ice
 */
public class JSOMAdm implements UsersRepository<Adm>{

    private static final String PATH = DIRECTORY+ File.separator +"usersAdm.json";
    private String json;
    
    @Override
    public List getAll() {
        Gson gson = new Gson();
        
        json = FileOperations.read(PATH);

        List<Adm> users = new ArrayList<>();
        if(!json.trim().equals("")) {

            Type tipoLista = new TypeToken<List<Adm>>() {
            }.getType();
            users = gson.fromJson(json, tipoLista);

            if (users == null)
                users = new ArrayList<>();
        }

        return users;    }
    
    

    @Override
    public void create(Adm user) {
        Gson gson = new Gson();
        
        List<Adm> usersContent = this.getAll();
        
        if (usersContent == null) {
            List<Adm> users = new ArrayList<>();
            users.add(user);
            gson.toJson(users);
        } else {
            List<Adm> users = this.getAll();
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
        List<Adm> users = this.getAll();
        if(users!=null)
        for (Adm user : users) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
    return false;
    }
    
    @Override
    public Adm getBylogin(String login) {
        List<Adm> users = this.getAll();
        if(users!=null)
        for (Adm user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }

    return null;
    }
    
    @Override
    public boolean checkIfExistsName(String nome) {
        List<Adm> users = this.getAll();
        if(users!=null)
        for (Adm user : users) {
            if (user.getNome().equals(nome)) {
                return true;
            }
        }
    return false;
    }
    
     @Override
    public boolean checkIfExistsSenha(String senha) {
        List<Adm> users = this.getAll();
        if(users!=null)
        for (Adm user : users) {
            if (user.getSenha().equals(senha)) {
                return true;
            }
        }
    return false;
    }
    
    @Override
    public boolean checkIfExistsCpf(String cpf) {
        List<Adm> users = this.getAll();
        if(users!=null)
        for (Adm user : users) {
            if (user.getCpf().equals(cpf)) {
                return true;
            }
        }
    return false;
    }
     
    @Override
    public Adm getBynome(String nome) {
        List<Adm> users = this.getAll();
        if(users!=null)
        for (Adm user : users) {
            if (user.getNome().equals(nome)) {
                return user;
            }
        }

    return null;
    }
    
    @Override
    public Adm getBycpf(String cpf) {
        List<Adm> users = this.getAll();
        if(users!=null)
        for (Adm user : users) {
            if (user.getCpf().equals(cpf)) {
                return user;
            }
        }

    return null;
    }
    
    @Override
    public void listUsers() {
        List<Adm> users = this.getAll();
        if(users!=null)
        for (Adm user : users) {
            System.out.println("    Nome:" + user.getNome());
        }
    }
    
    @Override
    public void delete(Adm user) {
        Gson gson = new Gson();

        List<Adm> userContent = this.getAll();

        List<Adm> users = new ArrayList<>();

        for (Adm item : userContent) {
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
