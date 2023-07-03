/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.handlers;

import com.ihammert.repositories.JSONDeliveryOrdersRepository;
import com.ihammert.repositories.JSONLocalOrdersRepository;
import com.ihammert.repositories.JSONProductRepository;
import com.ihammert.core.AbstractProductEntity;

public class AddItemToOrder {

    public static void handle(String orderId, int productId, int quantity, boolean isLocal) {
        try {
            JSONProductRepository jsonProductRepository = new JSONProductRepository();

            if (isLocal) {
                int tableNumber = 1;

                JSONLocalOrdersRepository jsonLocalOrdersRepository = new JSONLocalOrdersRepository();

                boolean tableExists = jsonLocalOrdersRepository.checkIfExistsById(tableNumber);
                if (!tableExists) {
                    throw new Error("Mesa nao disponivel no momento!");
                }

                AbstractProductEntity product = jsonProductRepository.getById(productId);
                if (product == null) {
                    throw new Error("Produto nao existe no momento!");
                }

                jsonLocalOrdersRepository.addProductToOrder(tableNumber, productId, quantity);
            } else {
                JSONDeliveryOrdersRepository jsonDeliveryOrdersRepository = new JSONDeliveryOrdersRepository();

                boolean orderExists = jsonDeliveryOrdersRepository.checkIfExistsById(orderId);
                if (!orderExists) {
                    throw new Error("Pedido nao existe no momento!");
                }

                AbstractProductEntity product = jsonProductRepository.getById(productId);
                if (product == null) {
                    throw new Error("Produto nao existe no momento!");
                }

                jsonDeliveryOrdersRepository.addProductToOrder(orderId, productId, quantity);

            }
        } catch (Exception err) {
            System.out.println("Erro: " + err);
        }
    }
}
