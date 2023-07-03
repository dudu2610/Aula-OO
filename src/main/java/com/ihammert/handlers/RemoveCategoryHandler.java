package com.ihammert.handlers;

import com.ihammert.entities.CategoryEntity;
import com.ihammert.repositories.JSONCategoriesRepository;
import com.ihammert.repositories.JSONProductRepository;
import javax.swing.JOptionPane;

public class RemoveCategoryHandler {

    public static void remove(String name) {

        try {
            JSONCategoriesRepository jSONCategoriesRepository = new JSONCategoriesRepository();
            int id = jSONCategoriesRepository.getIdByName(name);
            
            CategoryEntity categoryToRemove = jSONCategoriesRepository.getById(id);
            JSONProductRepository jSONProductRepository = new JSONProductRepository();
            if(!jSONProductRepository.checkIfExistsByCategoryId(id)){
                jSONCategoriesRepository.delete(categoryToRemove);
                JOptionPane.showMessageDialog(null, "Categoira removida com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Impossível remover! Existem produtos nessa categoria.", null, 0);
            }
            
        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }
    }
}
