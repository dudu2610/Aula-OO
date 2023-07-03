/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.ihammert.core.AbstractUserEntity;


public class JSONUsersRepository implements UsersRepository<AbstractUserEntity> {
    private static final String PATH = DIRECTORY+ File.separator +"users.json";
    private String json;
    
    @Override
    public List getAll() {
        Gson gson = createGsonWithAdapter();
        
        json = FileOperations.read(PATH);

        List<AbstractUserEntity> users = new ArrayList<>();
        if(!json.trim().equals("")) {

            Type tipoLista = new TypeToken<List<AbstractUserEntity>>() {
            }.getType();
            users = gson.fromJson(json, tipoLista);

            if (users == null)
                users = new ArrayList<>();
        }

        return users;    }
    
    private Gson createGsonWithAdapter() {
        return new GsonBuilder()
                .registerTypeAdapter(AbstractUserEntity.class, new AbstractUserEntityTypeAdapter())
                .create();
    }

    @Override
    public void create(AbstractUserEntity user) {
        Gson gson = createGsonWithAdapter();
        
        List<AbstractUserEntity> usersContent = this.getAll();
        
        if (usersContent == null) {
            List<AbstractUserEntity> users = new ArrayList<>();
            users.add(user);
            gson.toJson(users);
        } else {
            List<AbstractUserEntity> users = this.getAll();
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
        List<AbstractUserEntity> users = this.getAll();
        if(users!=null)
        for (AbstractUserEntity user : users) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
    return false;
    }
    
    @Override
    public AbstractUserEntity getBylogin(String login) {
        List<AbstractUserEntity> users = this.getAll();
        if(users!=null)
        for (AbstractUserEntity user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }

    return null;
    }
    
    @Override
    public boolean checkIfExistsName(String nome) {
        List<AbstractUserEntity> users = this.getAll();
        if(users!=null)
        for (AbstractUserEntity user : users) {
            if (user.getNome().equals(nome)) {
                return true;
            }
        }
    return false;
    }
    
     @Override
    public boolean checkIfExistsSenha(String senha) {
        List<AbstractUserEntity> users = this.getAll();
        if(users!=null)
        for (AbstractUserEntity user : users) {
            if (user.getSenha().equals(senha)) {
                return true;
            }
        }
    return false;
    }
    
    @Override
    public boolean checkIfExistsCpf(String cpf) {
        List<AbstractUserEntity> users = this.getAll();
        if(users!=null)
        for (AbstractUserEntity user : users) {
            if (user.getCpf().equals(cpf)) {
                return true;
            }
        }
    return false;
    }
     
    @Override
    public AbstractUserEntity getBynome(String nome) {
        List<AbstractUserEntity> users = this.getAll();
        if(users!=null)
        for (AbstractUserEntity user : users) {
            if (user.getNome().equals(nome)) {
                return user;
            }
        }

    return null;
    }
    
    @Override
    public AbstractUserEntity getBycpf(String cpf) {
        List<AbstractUserEntity> users = this.getAll();
        if(users!=null)
        for (AbstractUserEntity user : users) {
            if (user.getCpf().equals(cpf)) {
                return user;
            }
        }

    return null;
    }
    
    @Override
    public void listUsers() {
        List<AbstractUserEntity> users = this.getAll();
        if(users!=null)
        for (AbstractUserEntity user : users) {
            System.out.println("    Nome:" + user.getNome());
        }
    }
    
    @Override
    public void delete(AbstractUserEntity user) {
        Gson gson = new Gson();

        List<AbstractUserEntity> userContent = this.getAll();

        List<AbstractUserEntity> users = new ArrayList<>();

        for (AbstractUserEntity item : userContent) {
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
