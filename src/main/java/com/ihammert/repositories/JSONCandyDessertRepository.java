/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ihammert.entities.CandyDessertEntity;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONCandyDessertRepository implements CandyDessertRepository<CandyDessertEntity>{
    
    private static final String PATH = DIRECTORY + File.separator + "CandyDessert-products.json";
    private String json;
    
    @Override
    public List getAll() {
        Gson gson = new Gson();

        json = FileOperations.read(PATH);

        List<CandyDessertEntity> product = new ArrayList<>();
        if (!json.trim().equals("")) {

            Type listType = new TypeToken<List<CandyDessertEntity>>() {
            }.getType();
            product = gson.fromJson(json, listType);

            if (product == null) {
                product = new ArrayList<>();
            }
        }

        return product;
    }

    @Override
    public CandyDessertEntity getByName(String name) {
       List<CandyDessertEntity> productContent = this.getAll();

        for (CandyDessertEntity product : productContent) {
            if (product.getProductName().equals(name)){
                return product;
            }
        }

        return null;
    }

    @Override
    public CandyDessertEntity getById(int id) {
        List<CandyDessertEntity> productContent = this.getAll();

        for (CandyDessertEntity product : productContent) {
            if (product.getProductId() == id ){
                return product;
            }
        }

        return null;
    }

    @Override
    public void create(CandyDessertEntity product) {
        Gson gson = new Gson();

        List<CandyDessertEntity> productsContent = this.getAll();

        if (productsContent == null) {
            List<CandyDessertEntity> products = new ArrayList<>();
            products.add(product);
            gson.toJson(products);
        } else {
            List<CandyDessertEntity> products = this.getAll();
            products.add(product);
            this.json = gson.toJson(products);
        }

        File dir = new File(DIRECTORY);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        FileOperations.write(PATH, json);
    }

    @Override
    public void delete(CandyDessertEntity product) {
        Gson gson = new Gson();

        List<CandyDessertEntity> productContent = this.getAll();

        List<CandyDessertEntity> products = new ArrayList<>();

        for (CandyDessertEntity item : productContent) {
            if (item.getProductId() != product.getProductId()) {
                products.add(item);
            }
        }

        this.json = gson.toJson(products);

        File dir = new File(DIRECTORY);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        FileOperations.write(PATH, json);
    }

    @Override
    public boolean checkIfExistsById(int id) {
       List<CandyDessertEntity> productsContent = this.getAll();

        for (CandyDessertEntity product : productsContent) {
            if (product.getProductId() == id) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean checkIfExistsByName(String name) {
        List<CandyDessertEntity> productsContent = this.getAll();

        for (CandyDessertEntity product : productsContent) {
            if (product.getProductName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int getIdByName(String name) {
        List<CandyDessertEntity> productsContent = this.getAll();

        for (CandyDessertEntity product : productsContent) {
            if (product.getProductName().equals(name)) {
                return product.getProductId();
            }
        }

        return -1;
    }

    @Override
    public boolean checkIfExistsByCategoryId(int id) {
       List<CandyDessertEntity> productsContent = this.getAll();

         for (CandyDessertEntity product : productsContent) {
            if (product.getProductCategoryId() == id) {
                return true;
            }
        }

        return false;
    }
}
