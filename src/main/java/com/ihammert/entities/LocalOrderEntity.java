package com.ihammert.entities;

import com.ihammert.core.AbstractOrderEntity;

public class LocalOrderEntity extends AbstractOrderEntity {

    private final String userId;
    private int tableNumber;

    public LocalOrderEntity(String customerName, String userId, int tableNumber) {
        super(customerName, true);

        this.validate(tableNumber);

        this.userId = userId;
    }

    public String getId() {
        return this.id;
    }

    private void validate(int tableNumber) {
        try {
            this.validateTable(tableNumber);

        } catch (Exception error) {
            System.out.println("Nao foi possivel criar o pedido, " + error.getMessage());
        }
    }

    private void validateTable(int tableNumber) {
        if (tableNumber < 0 || tableNumber <= 10) {
            this.tableNumber = tableNumber;
        } else {
            throw new Error("Mesa invalida");
        }

    }

    public String getCreatedById() {
        return this.userId;
    }

    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public double totalValue() {
        double total = 0;
        
        for(OrderItemEntity item : cart) {
            total += item.getTotalValue();
        }
        
        // 10% do garçom
        return total + (total * 0.1);
    }
}
