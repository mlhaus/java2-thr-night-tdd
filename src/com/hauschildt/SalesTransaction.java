package com.hauschildt;

import java.time.LocalDateTime;

public class SalesTransaction implements Comparable<SalesTransaction> {
    private int transactionId;
    private int salesPersonId;
    private LocalDateTime transactionDateTime;
    private int itemId;
    private double unitPrice;
    private int quantitySold;

    public static int DEFAULT_TRANSACTION_ID = 0;
    public static int DEFAULT_SALESPERSON_ID = 0;
    public static LocalDateTime DEFAULT_TRANSACTION_DATE_TIME = LocalDateTime.now();
    public static int DEFAULT_Item_ID = 0;
    public static double DEFAULT_UNIT_PRICE = 0;
    public static int DEFAULT_QUANTITY_SOLD = 0;

    public static int MIN_TRANSACTION_ID = 0;

    public SalesTransaction() {
        this(DEFAULT_TRANSACTION_ID, DEFAULT_SALESPERSON_ID, DEFAULT_TRANSACTION_DATE_TIME, DEFAULT_Item_ID, DEFAULT_UNIT_PRICE,DEFAULT_QUANTITY_SOLD);
    }

    public SalesTransaction(int transactionId, int salesPersonId, LocalDateTime transactionDateTime, int itemId, double unitPrice, int quantitySold) {
        this.transactionId = transactionId;
        this.salesPersonId = salesPersonId;
        this.transactionDateTime = transactionDateTime;
        this.itemId = itemId;
        this.unitPrice = unitPrice;
        this.quantitySold = quantitySold;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        validateTransactionId(transactionId);
        this.transactionId = transactionId;
    }

    private void validateTransactionId(int transactionId) {
        if(transactionId < MIN_TRANSACTION_ID) {
            throw new IllegalArgumentException("Negative numbers are not allowed.");
        }
    }

    public int getSalesPersonId() {
        return salesPersonId;
    }

    public void setSalesPersonId(int salesPersonId) {
        this.salesPersonId = salesPersonId;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    @Override
    public String toString() {
        return "SalesTransaction{" +
                "transactionId=" + transactionId +
                ", salesPersonId=" + salesPersonId +
                ", transactionDateTime=" + transactionDateTime +
                ", itemId=" + itemId +
                ", unitPrice=" + unitPrice +
                ", quantitySold=" + quantitySold +
                '}';
    }

    @Override
    public int compareTo(SalesTransaction o) {
        return this.transactionDateTime.compareTo(o.transactionDateTime);
    }
}
