/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ihammert.entities.ChocolateDessertEntity;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONChocolateDessertRepository implements ChocolateDessertRepository<ChocolateDessertEntity> {

    private static final String PATH = DIRECTORY + File.separator + "ChocolateDessert-products.json";
    private String json;

    @Override
    public List getAll() {
        Gson gson = new Gson();

        json = FileOperations.read(PATH);

        List<ChocolateDessertEntity> product = new ArrayList<>();
        if (!json.trim().equals("")) {

            Type listType = new TypeToken<List<ChocolateDessertEntity>>() {
            }.getType();
            product = gson.fromJson(json, listType);

            if (product == null) {
                product = new ArrayList<>();
            }
        }

        return product;
    }

    @Override
    public ChocolateDessertEntity getByName(String name) {
        List<ChocolateDessertEntity> productContent = this.getAll();

        for (ChocolateDessertEntity product : productContent) {
            if (product.getProductName().equals(name)) {
                return product;
            }
        }

        return null;
    }

    @Override
    public ChocolateDessertEntity getById(int id) {
        List<ChocolateDessertEntity> productContent = this.getAll();

        for (ChocolateDessertEntity product : productContent) {
            if (product.getProductId() == id) {
                return product;
            }
        }

        return null;
    }

    @Override
    public void create(ChocolateDessertEntity product) {
        Gson gson = new Gson();

        List<ChocolateDessertEntity> productsContent = this.getAll();

        if (productsContent == null) {
            List<ChocolateDessertEntity> products = new ArrayList<>();
            products.add(product);
            gson.toJson(products);
        } else {
            List<ChocolateDessertEntity> products = this.getAll();
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
    public void delete(ChocolateDessertEntity product) {
        Gson gson = new Gson();

        List<ChocolateDessertEntity> productContent = this.getAll();

        List<ChocolateDessertEntity> products = new ArrayList<>();

        for (ChocolateDessertEntity item : productContent) {
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
        List<ChocolateDessertEntity> productsContent = this.getAll();

        for (ChocolateDessertEntity product : productsContent) {
            if (product.getProductId() == id) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean checkIfExistsByName(String name) {
        List<ChocolateDessertEntity> productsContent = this.getAll();

        for (ChocolateDessertEntity product : productsContent) {
            if (product.getProductName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int getIdByName(String name) {
        List<ChocolateDessertEntity> productsContent = this.getAll();

        for (ChocolateDessertEntity product : productsContent) {
            if (product.getProductName().equals(name)) {
                return product.getProductId();
            }
        }

        return -1;
    }

    @Override
    public boolean checkIfExistsByCategoryId(int id) {
        List<ChocolateDessertEntity> productsContent = this.getAll();

        for (ChocolateDessertEntity product : productsContent) {
           if(product.getProductCategoryId() == id){
               return true;
           }
        }

        return false;
    }
}
