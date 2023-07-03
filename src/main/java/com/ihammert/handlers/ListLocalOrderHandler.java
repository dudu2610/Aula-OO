/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.handlers;

import com.ihammert.entities.LocalOrderEntity;
import com.ihammert.repositories.JSONLocalOrdersRepository;
import java.util.List;

public class ListLocalOrderHandler {

    public static List<LocalOrderEntity> handle() {
        List<LocalOrderEntity> orders;
        
        try {
            JSONLocalOrdersRepository jsonLocalOrdersRepository = new JSONLocalOrdersRepository();
            orders = jsonLocalOrdersRepository.getAll();

        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
            return null;
        } 
        return orders;
    }
}
