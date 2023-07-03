/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
*/

/*package com.ihammert.handlers;

import com.ihammert.entities.OrderEntity;
import com.ihammert.entities.OrderItemEntity;
import com.ihammert.utils.PaymentAuth;
import com.ihammert.inMemoryDatabase.OrderInMemoryDatabase;
import com.ihammert.inMemoryDatabase.ProductInMemoryDataBase;
import java.text.DecimalFormat;

import java.util.ArrayList;

public class FinishOrderHandler {

    public static void handle(String paymentMethod, int id) {
        try {
            OrderInMemoryDatabase orderInMemoryDatabase = new OrderInMemoryDatabase();
            ProductInMemoryDataBase productInMemoryDatabase = new ProductInMemoryDataBase();

            ArrayList<OrderEntity> orders = orderInMemoryDatabase.getAll();

            if (!orderInMemoryDatabase.checkIfExists(id)) {
                throw new Error("Mesa nao aberta!");
            }

            if (!paymentMethod.equals("cash") && !paymentMethod.equals("card")) {
                throw new Error("Metodo de pagamento invalido!");
            }

            OrderEntity orderToFinish = orderInMemoryDatabase.getByTableId(id);
            ArrayList<OrderItemEntity> productsToCalculate = orderToFinish.getAllItems();
            
            System.out.println();
            orderToFinish.print();
            System.out.println();
            
            double total = 0;
            for (OrderItemEntity product : productsToCalculate) {
                total +=  product.getTotalValue();
            }
            
            DecimalFormat floatFormatter = new DecimalFormat("0.00");
            System.out.println("Valor total: " + floatFormatter.format(total));

            PaymentAuth paymentAuth = new PaymentAuth(total);

            if (paymentMethod.equals("cash")) {
                paymentAuth.handleCash();
            } else {
                paymentAuth.handleAuthCard();
            }

            orders.remove(orderToFinish);

        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }
    }
}
*/