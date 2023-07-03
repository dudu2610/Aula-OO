/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.handlers;

import com.ihammert.core.AbstractOrderEntity;
import com.ihammert.core.AbstractProductEntity;
import com.ihammert.repositories.JSONDeliveryOrdersRepository;
import com.ihammert.repositories.JSONLocalOrdersRepository;
import com.ihammert.repositories.JSONProductRepository;

public class UpdateItemFromOrder {

    public static void handle(String orderId, int productId, int quantity, boolean isLocal) {
        try {
            JSONProductRepository jsonProductRepository = new JSONProductRepository();

            AbstractProductEntity product = jsonProductRepository.getById(productId);
            if (product == null) {
                throw new Error("Produto nao existe!");
            }

            if (isLocal) {
                JSONLocalOrdersRepository jsonLocalOrdersRepository = new JSONLocalOrdersRepository();

                AbstractOrderEntity order = jsonLocalOrdersRepository.getById(orderId);
                if (order == null) {
                    throw new Error("Mesa nao disponivel no momento!");
                }

                jsonLocalOrdersRepository.updateAProductFromOrder(orderId, productId, quantity);

            } else {

                JSONDeliveryOrdersRepository jsonDeliveryOrdersRepository = new JSONDeliveryOrdersRepository();

                boolean orderExists = jsonDeliveryOrdersRepository.checkIfExistsById(orderId);
                if (!orderExists) {
                    throw new Error("Pedido nao disponivel no momento!");
                }

                jsonDeliveryOrdersRepository.updateAProductFromOrder(orderId, productId, quantity);

            }
        } catch (Exception err) {
            System.out.println("Erro: " + err);
        }
    }
}
