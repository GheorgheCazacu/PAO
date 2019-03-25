package com.fmi.laborator.model;

public interface InvoiceItem {
    Product getProduct();
    Double getTVA();
    Double getNumberOfPieces();
    Double getFinalPrice();
}
