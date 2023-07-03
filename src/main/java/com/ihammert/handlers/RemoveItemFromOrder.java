/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.handlers;

import com.ihammert.core.AbstractProductEntity;
import com.ihammert.entities.DeliveryOrderEntity;
import com.ihammert.entities.LocalOrderEntity;
import com.ihammert.repositories.JSONDeliveryOrdersRepository;
import com.ihammert.repositories.JSONLocalOrdersRepository;
import com.ihammert.repositories.JSONProductRepository;

public class RemoveItemFromOrder {

    public static void handle(String orderId, int productId, boolean isLocal) {
        try {
            JSONProductRepository jsonProductRepository = new JSONProductRepository();

            AbstractProductEntity product = jsonProductRepository.getById(productId);
            if (product == null) {
                throw new Error("Produto nao existe!");
            }

            if (isLocal) {
                JSONLocalOrdersRepository jsonLocalOrdersRepository = new JSONLocalOrdersRepository();

                LocalOrderEntity order = jsonLocalOrdersRepository.getById(orderId);
                if (order == null) {
                    throw new Error("Pedido nao existe!");
                }

                jsonLocalOrdersRepository.removeProductOrder(orderId, productId);

            } else {
                JSONDeliveryOrdersRepository jsonDeliveryOrdersRepository = new JSONDeliveryOrdersRepository();

                DeliveryOrderEntity order = jsonDeliveryOrdersRepository.getById(orderId);
                if (order == null) {
                    throw new Error("Pedido nao existe!");
                }

                jsonDeliveryOrdersRepository.removeProductOrder(orderId, productId);
            }
        } catch (Exception err) {
            System.out.println("Erro: " + err);
        }
    }

}
