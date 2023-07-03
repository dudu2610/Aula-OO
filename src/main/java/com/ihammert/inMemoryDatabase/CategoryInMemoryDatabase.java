/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.inMemoryDatabase;

import java.util.ArrayList;
import com.ihammert.inMemoryDatabase.ProductInMemoryDataBase;
import com.ihammert.entities.CategoryEntity;
import java.util.Scanner;

public class CategoryInMemoryDatabase {
    
/*
    public static ArrayList<CategoryEntity> StorageCategories = new ArrayList<>();
    public Scanner teclado = new Scanner(System.in);

    public boolean categoryExists(String categoryName) {
        for (CategoryEntity category : StorageCategories) {
            if (category.getCategoryName().equals(categoryName)) {
                return true;
            }
        }
        return false;
    }

    public void editCategoryNamePerId(ArrayList<CategoryEntity> StorageCategory) {
        System.out.println("Informe o ID da categoria a ser editada: ");
        int categoryId = teclado.nextInt();
        System.out.println("Informe o novo nome da categoria: ");
        String newCategoryName = teclado.next();
        for (CategoryEntity p : StorageCategory) {
            if (p.getId() == categoryId) {
                p.setCategoryName(newCategoryName);
            }
        }
    }

    public boolean CategoryExist(ArrayList<CategoryEntity> storageCategory, String categoryName) {
        for (CategoryEntity category : storageCategory) {
            if (category.getCategoryName().equals(categoryName)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<CategoryEntity> getAll() {
        return StorageCategories;
    }

    public CategoryEntity getCategoryById(ArrayList<CategoryEntity> StorageCategory, int categoryId) {
        for (CategoryEntity p : StorageCategory) {
            if (p.getId() == categoryId) {
                return p;
            }
        }
        return null;
    }

    public CategoryEntity getByName(String name) {
        for (CategoryEntity categoria : StorageCategories) {
            if (categoria.getCategoryName().equals(name)) {
                return categoria;
            }
        }
        return null;
    }

    public int getIdByName(String name) {
        for (CategoryEntity categoria : StorageCategories) {
            if (categoria.getCategoryName().equals(name)) {
                return categoria.getId();
            }
        }
        return 0;
    }
*/
    
}