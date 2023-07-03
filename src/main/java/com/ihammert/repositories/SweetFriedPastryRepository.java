/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.repositories;

import java.util.List;

public interface SweetFriedPastryRepository<T> {
    
    String DIRECTORY = "data";
    
    public List<T> getAll();
    public T getByName(String name);
    public T getById(int id);
    public boolean checkIfExistsById(int id);
    public boolean checkIfExistsByName(String name);
    public int getIdByName(String name);
    public boolean checkIfExistsByCategoryId(int id);
    // POST
    public void create(T product);

    // DELETE
    public void delete(T product);
}
