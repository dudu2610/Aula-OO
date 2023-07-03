package com.ihammert.entities;

import com.ihammert.core.AbstractOrderEntity;

public class DeliveryOrderEntity extends AbstractOrderEntity {

    private final String neighborhood;
    private final String street;
    private final int residenceNumber;
    private final String complement;

    public DeliveryOrderEntity(
            String customerName,
            String neighborhood,
            String street,
            int residenceNumber,
            String complement
    ) {
        super(customerName, false);

        this.neighborhood = neighborhood;
        this.street = street;
        this.residenceNumber = residenceNumber;
        this.complement = complement;
    }

    public String getAdress() {
        String fullAdress = this.street + ", " + this.residenceNumber + ", " + this.complement + ", " + this.neighborhood;
        return fullAdress;
    }

    public String getId() {
        return this.id;
    }
/*
    public String format() {
        DecimalFormat floatFormatter = new DecimalFormat("0.00");

        String formattedTotal = "+ " + this.product.getProductName() + " - " + this.quantity + "x";
        
        return formattedTotal;
    }
*/
    @Override
    public double totalValue() {
        double total = 0;

        for (OrderItemEntity item : cart) {
            total += item.getTotalValue();
        }
        
        this.subtotal = total + 7;
        
        // 7 reais fixos do frete
        return this.subtotal;
    }
}
