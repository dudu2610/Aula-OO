package com.ihammert.handlers;

import com.ihammert.entities.DeliveryOrderEntity;
import com.ihammert.repositories.JSONDeliveryOrdersRepository;
import java.util.List;

public class ListDeliveryOrderHandler {
    
     public static List<DeliveryOrderEntity> handle() {
        List<DeliveryOrderEntity> orders;
        
        try {
            JSONDeliveryOrdersRepository jsonDeliveryOrdersRepository = new JSONDeliveryOrdersRepository();
            orders = jsonDeliveryOrdersRepository.getAll();

        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
            return null;
        } 
        return orders;
    }
}
