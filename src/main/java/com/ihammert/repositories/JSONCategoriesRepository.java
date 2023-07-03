/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ihammert.entities.CategoryEntity;
import static com.ihammert.repositories.DeliveryOrdersRepository.DIRECTORY;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONCategoriesRepository implements CategoriesRepository <CategoryEntity> {
    
    private static final String PATH = DIRECTORY + File.separator + "categories.json";
    private String json;

    @Override
    public List<CategoryEntity> getAll() {
        Gson gson = new Gson();

        json = FileOperations.read(PATH);

        List<CategoryEntity> categoria = new ArrayList<>();
        if (!json.trim().equals("")) {

            Type listType = new TypeToken<List<CategoryEntity>>() {
            }.getType();
            categoria = gson.fromJson(json, listType);

            if (categoria == null) {
                categoria = new ArrayList<>();
            }
        }

        return categoria;
    }

    @Override
    public CategoryEntity getByName(String name) {
        List<CategoryEntity> categoryContent = this.getAll();

        for (CategoryEntity category : categoryContent) {
            if (category.getCategoryName().equals(name)){
                return category;
            }
        }

        return null;
    }

    @Override
    public CategoryEntity getById(int id) {
       List<CategoryEntity> categoryContent = this.getAll();

        for (CategoryEntity category : categoryContent) {
            if (category.getId() == id ){
                return category;
            }
        }

        return null;
    }

    @Override
    public boolean checkIfExistsById(int id) {
        List<CategoryEntity> categoryContent = this.getAll();

        for (CategoryEntity category : categoryContent) {
            if (category.getId() == id) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean checkIfExistsByName(String name) {
         List<CategoryEntity> categoryContent = this.getAll();

        for (CategoryEntity category : categoryContent) {
            if (category.getCategoryName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void create(CategoryEntity category) {
         Gson gson = new Gson();

        List<CategoryEntity> categoryContent = this.getAll();

        if (categoryContent == null) {
            List<CategoryEntity> categories = new ArrayList<>();
            categories.add(category);
            gson.toJson(categories);
        } else {
            List<CategoryEntity> categories = this.getAll();
            categories.add(category);
            this.json = gson.toJson(categories);
        }

        File dir = new File(DIRECTORY);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        FileOperations.write(PATH, json);
    }

    @Override
    public void delete(CategoryEntity category) {
        Gson gson = new Gson();

        List<CategoryEntity> categoryContent = this.getAll();

        List<CategoryEntity> categories = new ArrayList<>();

        for (CategoryEntity item : categoryContent) {
            if (item.getId() != category.getId()) {
                categories.add(item);
            }
        }

        this.json = gson.toJson(categories);

        File dir = new File(DIRECTORY);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        FileOperations.write(PATH, json);
    }

    @Override
    public int getIdByName(String name) {
        List<CategoryEntity> categoriesContent = this.getAll();

        for (CategoryEntity category : categoriesContent) {
            if (category.getCategoryName().equals(name)) {
                return category.getId();
            }
        }

        return -1;
    }
    
}
