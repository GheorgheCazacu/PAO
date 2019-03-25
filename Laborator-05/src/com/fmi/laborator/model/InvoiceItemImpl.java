package com.fmi.laborator.model;

public class InvoiceItemImpl implements InvoiceItem {
    private Product product;
    private Double numberOfPices;
    public static final Double TVA = 19.0;


    @Override
    public Product getProduct() {
        return this.product;
    }

    @Override
    public Double getTVA() {
        return getFinalPrice() * (TVA / (100 + TVA));
    }

    @Override
    public Double getNumberOfPieces() {
        return this.numberOfPices;
    }

    @Override
    public Double getFinalPrice() {
        return this.numberOfPices * this.getProduct().getPrice();
    }
}
