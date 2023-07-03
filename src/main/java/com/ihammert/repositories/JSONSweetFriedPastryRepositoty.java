/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ihammert.entities.SweetFriedPastryEntity;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class JSONSweetFriedPastryRepositoty implements SweetFriedPastryRepository<SweetFriedPastryEntity>{
    
    private static final String PATH = DIRECTORY + File.separator + "SweerFriedPastry-products.json";
    private String json;

   @Override
    public List getAll() {
        Gson gson = new Gson();

        json = FileOperations.read(PATH);

        List<SweetFriedPastryEntity> product = new ArrayList<>();
        if (!json.trim().equals("")) {

            Type listType = new TypeToken<List<SweetFriedPastryEntity>>() {
            }.getType();
            product = gson.fromJson(json, listType);

            if (product == null) {
                product = new ArrayList<>();
            }
        }

        return product;
    }

    @Override
    public SweetFriedPastryEntity getByName(String name) {
       List<SweetFriedPastryEntity> productContent = this.getAll();

        for (SweetFriedPastryEntity product : productContent) {
            if (product.getProductName().equals(name)){
                return product;
            }
        }

        return null;
    }

    @Override
    public SweetFriedPastryEntity getById(int id) {
        List<SweetFriedPastryEntity> productContent = this.getAll();

        for (SweetFriedPastryEntity product : productContent) {
            if (product.getProductId() == id ){
                return product;
            }
        }

        return null;
    }

    @Override
    public void create(SweetFriedPastryEntity product) {
        Gson gson = new Gson();

        List<SweetFriedPastryEntity> productsContent = this.getAll();

        if (productsContent == null) {
            List<SweetFriedPastryEntity> products = new ArrayList<>();
            products.add(product);
            gson.toJson(products);
        } else {
            List<SweetFriedPastryEntity> products = this.getAll();
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
    public void delete(SweetFriedPastryEntity product) {
        Gson gson = new Gson();

        List<SweetFriedPastryEntity> productContent = this.getAll();

        List<SweetFriedPastryEntity> products = new ArrayList<>();

        for (SweetFriedPastryEntity item : productContent) {
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
       List<SweetFriedPastryEntity> productsContent = this.getAll();

        for (SweetFriedPastryEntity product : productsContent) {
            if (product.getProductId() == id) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean checkIfExistsByName(String name) {
        List<SweetFriedPastryEntity> productsContent = this.getAll();

        for (SweetFriedPastryEntity product : productsContent) {
            if (product.getProductName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int getIdByName(String name) {
        List<SweetFriedPastryEntity> productsContent = this.getAll();

        for (SweetFriedPastryEntity product : productsContent) {
            if (product.getProductName().equals(name)) {
                return product.getProductId();
            }
        }

        return -1;
    }

    @Override
    public boolean checkIfExistsByCategoryId(int id) {
        List<SweetFriedPastryEntity> productsContent = this.getAll();

        for (SweetFriedPastryEntity product : productsContent) {
            if (product.getProductCategoryId() == id) {
                return true;
            }
        }

        return false;
    }
    
}
