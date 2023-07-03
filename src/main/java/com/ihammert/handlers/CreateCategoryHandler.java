/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.handlers;

import com.ihammert.entities.CategoryEntity;
import com.ihammert.repositories.JSONCategoriesRepository;
import javax.swing.JOptionPane;

public class CreateCategoryHandler {

    public static void categoryHandle(String name) {

        try {
            JSONCategoriesRepository jSONCategoriesRepository = new JSONCategoriesRepository();

            if (jSONCategoriesRepository.checkIfExistsByName(name)) {
                JOptionPane.showMessageDialog(null, "Categoria já está cadastrado!", null, 0);
            } else {
                CategoryEntity newCategory = new CategoryEntity(name);
                jSONCategoriesRepository.create(newCategory);

                JOptionPane.showMessageDialog(null, "Categoria registrado com sucesso!", "iHammert", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }
    }
}
