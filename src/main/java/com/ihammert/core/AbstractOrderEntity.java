package com.ihammert.core;

import com.ihammert.entities.OrderItemEntity;
import java.util.ArrayList;
import java.util.Date;

public abstract class AbstractOrderEntity {

    protected String id;
    protected final String customerName;
    protected final boolean isLocal;
    protected ArrayList<OrderItemEntity> cart;
    protected String paymentMethod = "";
    protected double subtotal = 0;

    public AbstractOrderEntity(
        String customerName, 
        boolean isLocal
    ) {

        String localDiff = isLocal ? "local" : "delivery";
        
        Date actualTime = new Date();
        String uniqueIdGuarantee = String
                .valueOf(actualTime)
                .replace(" ", "")
                .concat(customerName)
                .concat(localDiff);
        

        this.id = uniqueIdGuarantee;
        this.customerName = customerName;
        this.isLocal = isLocal;
        this.cart = new ArrayList<>();
    }
    
    public ArrayList<OrderItemEntity> fetchCartItems() {
        return cart;
    }
    
    public abstract double totalValue();
}
