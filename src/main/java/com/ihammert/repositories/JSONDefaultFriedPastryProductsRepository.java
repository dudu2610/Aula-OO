/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.repositories;

import com.ihammert.entities.DefaultFriedPastryEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONDefaultFriedPastryProductsRepository implements DefaultFriedPastryRepository<DefaultFriedPastryEntity> {

    private static final String PATH = DIRECTORY + File.separator + "DefaultFriedPastry-products.json";
    private String json;

    @Override
    public List getAll() {
        Gson gson = new Gson();

        json = FileOperations.read(PATH);

        List<DefaultFriedPastryEntity> product = new ArrayList<>();
        if (!json.trim().equals("")) {

            Type listType = new TypeToken<List<DefaultFriedPastryEntity>>() {
            }.getType();
            product = gson.fromJson(json, listType);

            if (product == null) {
                product = new ArrayList<>();
            }
        }

        return product;
    }

    @Override
    public DefaultFriedPastryEntity getByName(String name) {
       List<DefaultFriedPastryEntity> productContent = this.getAll();

        for (DefaultFriedPastryEntity product : productContent) {
            if (product.getProductName().equals(name)){
                return product;
            }
        }

        return null;
    }

    @Override
    public DefaultFriedPastryEntity getById(int id) {
        List<DefaultFriedPastryEntity> productContent = this.getAll();

        for (DefaultFriedPastryEntity product : productContent) {
            if (product.getProductId() == id ){
                return product;
            }
        }

        return null;
    }

    @Override
    public void create(DefaultFriedPastryEntity product) {
        Gson gson = new Gson();

        List<DefaultFriedPastryEntity> productsContent = this.getAll();

        if (productsContent == null) {
            List<DefaultFriedPastryEntity> products = new ArrayList<>();
            products.add(product);
            gson.toJson(products);
        } else {
            List<DefaultFriedPastryEntity> products = this.getAll();
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
    public void delete(DefaultFriedPastryEntity product) {
        Gson gson = new Gson();

        List<DefaultFriedPastryEntity> productContent = this.getAll();

        List<DefaultFriedPastryEntity> products = new ArrayList<>();

        for (DefaultFriedPastryEntity item : productContent) {
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
       List<DefaultFriedPastryEntity> productsContent = this.getAll();
        for (DefaultFriedPastryEntity product : productsContent) {
            if (product.getProductId() == id) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean checkIfExistsByName(String name) {
        List<DefaultFriedPastryEntity> productsContent = this.getAll();

        for (DefaultFriedPastryEntity product : productsContent) {
            if (product.getProductName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int getIdByName(String name) {
        List<DefaultFriedPastryEntity> productsContent = this.getAll();

        for (DefaultFriedPastryEntity product : productsContent) {
            if (product.getProductName().equals(name)) {
                return product.getProductId();
            }
        }

        return -1;
    }

    @Override
    public boolean checkIfExistsByCategoryId(int id) {
         List<DefaultFriedPastryEntity> productsContent = this.getAll();

        for (DefaultFriedPastryEntity product : productsContent) {
            if (product.getProductCategoryId() == id) {
                return true;
            }
        }

        return false;
    }

}
