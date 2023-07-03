package com.ihammert.handlers;

import com.ihammert.entities.DeliveryOrderEntity;
import com.ihammert.entities.LocalOrderEntity;
import com.ihammert.repositories.JSONLocalOrdersRepository;
import com.ihammert.repositories.JSONDeliveryOrdersRepository;

public class CancelOrder {

    public static void handle(String id, boolean isLocal) {
        try {
            if (isLocal) {
                JSONLocalOrdersRepository jsonLocalOrdersRepository = new JSONLocalOrdersRepository();
                LocalOrderEntity orderToRemove = jsonLocalOrdersRepository.getById(id);

                if (orderToRemove == null) {
                    throw new Error("Pedido nao encontrado");
                }

                jsonLocalOrdersRepository.delete(orderToRemove);

            } else {
                JSONDeliveryOrdersRepository jsonDeliveryOrdersRepository = new JSONDeliveryOrdersRepository();
                DeliveryOrderEntity orderToRemove = jsonDeliveryOrdersRepository.getById(id);

                if (orderToRemove == null) {
                    throw new Error("Pedido nao encontrado");
                }

                jsonDeliveryOrdersRepository.delete(orderToRemove);
            }
        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }
    }
}
