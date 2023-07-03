/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ihammert.entities.LocalOrderEntity;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONLocalOrdersRepository implements LocalOrdersRepository<LocalOrderEntity> {

    private static final String PATH = DIRECTORY + File.separator + "local-orders.json";
    private String json;

    @Override
    public List<LocalOrderEntity> getAll() {
        Gson gson = new Gson();

        json = FileOperations.read(PATH);

        List<LocalOrderEntity> orders = new ArrayList<>();
        if (!json.trim().equals("")) {

            Type listType = new TypeToken<List<LocalOrderEntity>>() {
            }.getType();
            orders = gson.fromJson(json, listType);

            if (orders == null) {
                orders = new ArrayList<>();
            }
        }

        return orders;
    }

    @Override
    public LocalOrderEntity getTableById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LocalOrderEntity getByUserId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LocalOrderEntity getItemByProductId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean checkIfExistsById(int id) {
        List<LocalOrderEntity> ordersContent = this.getAll();

        for (LocalOrderEntity order : ordersContent) {
            if (order.getTableNumber() == id) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void create(LocalOrderEntity order) {
        Gson gson = new Gson();

        List<LocalOrderEntity> ordersContent = this.getAll();

        if (ordersContent == null) {
            List<LocalOrderEntity> orders = new ArrayList<>();
            orders.add(order);
            gson.toJson(orders);
        } else {
            List<LocalOrderEntity> orders = this.getAll();
            orders.add(order);
            this.json = gson.toJson(orders);
        }

        File dir = new File(DIRECTORY);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        FileOperations.write(PATH, json);
    }

    @Override
    public void addProductToOrder(int orderId, int productId, int quantity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateAProductFromOrder(String orderId, int productId, int newQuantity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeProductOrder(String orderId, int productId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(LocalOrderEntity order) {
        Gson gson = new Gson();

        List<LocalOrderEntity> ordersContent = this.getAll();

        List<LocalOrderEntity> orders = new ArrayList<>();

        for (LocalOrderEntity item : ordersContent) {
            if (!item.getId().equals(order.getId())) {
                orders.add(item);
            }
        }

        this.json = gson.toJson(orders);

        File dir = new File(DIRECTORY);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        FileOperations.write(PATH, json);
    }

    @Override
    public LocalOrderEntity getById(String id) {
        List<LocalOrderEntity> ordersContent = this.getAll();

        for (LocalOrderEntity order : ordersContent) {
            if (order.getId().equals(id)) {
                return order;
            }
        }

        return null;
    }
}
