/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.repositories;

import com.ihammert.entities.CannedJuiceEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class JSONCannedJuiceRepository implements CannedJuiceRpository<CannedJuiceEntity>{
    
    private static final String PATH = DIRECTORY + File.separator + "CannedJuice-products.json";
    private String json;
    
    @Override
    public List getAll() {
        Gson gson = new Gson();

        json = FileOperations.read(PATH);

        List<CannedJuiceEntity> product = new ArrayList<>();
        if (!json.trim().equals("")) {

            Type listType = new TypeToken<List<CannedJuiceEntity>>() {
            }.getType();
            product = gson.fromJson(json, listType);

            if (product == null) {
                product = new ArrayList<>();
            }
        }

        return product;
    }

    @Override
    public CannedJuiceEntity getByName(String name) {
       List<CannedJuiceEntity> productContent = this.getAll();

        for (CannedJuiceEntity product : productContent) {
            if (product.getProductName().equals(name)){
                return product;
            }
        }

        return null;
    }

    @Override
    public CannedJuiceEntity getById(int id) {
        List<CannedJuiceEntity> productContent = this.getAll();

        for (CannedJuiceEntity product : productContent) {
            if (product.getProductId() == id ){
                return product;
            }
        }

        return null;
    }

    @Override
    public void create(CannedJuiceEntity product) {
        Gson gson = new Gson();

        List<CannedJuiceEntity> productsContent = this.getAll();

        if (productsContent == null) {
            List<CannedJuiceEntity> products = new ArrayList<>();
            products.add(product);
            gson.toJson(products);
        } else {
            List<CannedJuiceEntity> products = this.getAll();
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
    public void delete(CannedJuiceEntity product) {
        Gson gson = new Gson();

        List<CannedJuiceEntity> productContent = this.getAll();

        List<CannedJuiceEntity> products = new ArrayList<>();

        for (CannedJuiceEntity item : productContent) {
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
       List<CannedJuiceEntity> productsContent = this.getAll();

        for (CannedJuiceEntity product : productsContent) {
            if (product.getProductId() == id) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean checkIfExistsByName(String name) {
        List<CannedJuiceEntity> productsContent = this.getAll();

        for (CannedJuiceEntity product : productsContent) {
            if (product.getProductName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int getIdByName(String name) {
        List<CannedJuiceEntity> productsContent = this.getAll();

        for (CannedJuiceEntity product : productsContent) {
            if (product.getProductName().equals(name)) {
                return product.getProductId();
            }
        }

        return -1;
    }

    @Override
    public boolean checkIfExistsByCategoryId(int id) {
        List<CannedJuiceEntity> productsContent = this.getAll();

        for (CannedJuiceEntity product : productsContent) {
            if (product.getProductCategoryId() == id) {
                return true;
            }
        }

        return false;
    }
}
