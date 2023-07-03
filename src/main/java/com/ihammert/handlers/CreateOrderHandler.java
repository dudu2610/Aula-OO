/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.handlers;

import com.ihammert.entities.LocalOrderEntity;
import com.ihammert.repositories.JSONDeliveryOrdersRepository;
import com.ihammert.entities.DeliveryOrderEntity;
import com.ihammert.repositories.JSONLocalOrdersRepository;

public class CreateOrderHandler {

    public static void handle(String customerName, boolean isDelivery) {
        try {
            if (!isDelivery) {
                int tableNumber = 3;
                String userId = "130463766268";
                
                JSONLocalOrdersRepository jsonLocalOrdersRepository = new JSONLocalOrdersRepository();
                
                boolean isTableAlreadyInUse = jsonLocalOrdersRepository.checkIfExistsById(tableNumber);
                
                if (isTableAlreadyInUse) {
                    throw new Error("Mesa ja esta em uso");
                }
                
                LocalOrderEntity newLocalOrder = new LocalOrderEntity(customerName, userId, tableNumber);
                jsonLocalOrdersRepository.create(newLocalOrder);

            } else {
                DeliveryOrderEntity newDeliveryOrder = new DeliveryOrderEntity(customerName,"neighborhood","street",610,"complement");
                JSONDeliveryOrdersRepository jsonDeliveryOrdersRepository = new JSONDeliveryOrdersRepository();
                jsonDeliveryOrdersRepository.create(newDeliveryOrder);
            }

        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }
    }
}
