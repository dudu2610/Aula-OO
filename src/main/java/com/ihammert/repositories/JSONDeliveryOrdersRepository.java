/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.repositories;

import com.ihammert.entities.*;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSONDeliveryOrdersRepository implements DeliveryOrdersRepository<DeliveryOrderEntity> {

    private static final String PATH = DIRECTORY + File.separator + "delivery-orders.json";
    private String json;

    @Override
    public List<DeliveryOrderEntity> getAll() {

        Gson gson = new Gson();

        json = FileOperations.read(PATH);

        List<DeliveryOrderEntity> orders = new ArrayList<>();
        if (!json.trim().equals("")) {

            Type listType = new TypeToken<List<DeliveryOrderEntity>>() {
            }.getType();
            orders = gson.fromJson(json, listType);

            if (orders == null) {
                orders = new ArrayList<>();
            }
        }

        return orders;
    }

    @Override
    public DeliveryOrderEntity getByUserId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DeliveryOrderEntity getItemByProductId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(DeliveryOrderEntity order) {
        Gson gson = new Gson();

        List<DeliveryOrderEntity> ordersContent = this.getAll();

        if (ordersContent == null) {
            List<DeliveryOrderEntity> orders = new ArrayList<>();
            orders.add(order);
            gson.toJson(orders);
        } else {
            List<DeliveryOrderEntity> orders = this.getAll();
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
    public void addProductToOrder(String orderId, int productId, int quantity) {
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
    public void delete(DeliveryOrderEntity order) {
        Gson gson = new Gson();

        List<DeliveryOrderEntity> ordersContent = this.getAll();

        List<DeliveryOrderEntity> orders = new ArrayList<>();

        for (DeliveryOrderEntity item : ordersContent) {
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
    public boolean checkIfExistsById(String id) {
        List<DeliveryOrderEntity> ordersContent = this.getAll();

        for (DeliveryOrderEntity order : ordersContent) {
            if (order.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public DeliveryOrderEntity getById(String id) {
        List<DeliveryOrderEntity> ordersContent = this.getAll();

        for (DeliveryOrderEntity order : ordersContent) {
            if (order.getId().equals(id)) {
                return order;
            }
        }

        return null;
    }

}
