package com.ihammert.handlers;

import com.ihammert.entities.CategoryEntity;
import com.ihammert.repositories.JSONCategoriesRepository;
import javax.swing.JOptionPane;

public class UpdateCategotyHandler {

    public static void update(String newName, String oldName) {

        try {
            JSONCategoriesRepository jSONCategoriesRepository = new JSONCategoriesRepository();
            
            CategoryEntity oldCategory = jSONCategoriesRepository.getByName(oldName);
            
            CategoryEntity editedCategory = new CategoryEntity(newName);
            editedCategory.setCategoryId(oldCategory.getId());
            jSONCategoriesRepository.delete(oldCategory);
            jSONCategoriesRepository.create(editedCategory);
            JOptionPane.showMessageDialog(null, "Categoria atualizada com sucesso!", "iHammert", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }

    }
}
