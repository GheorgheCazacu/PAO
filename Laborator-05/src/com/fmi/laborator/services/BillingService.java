package com.fmi.laborator.services;

import com.fmi.laborator.model.Invoice;

public class BillingService implements Service {
    private static BillingService ourInstance = new BillingService();

    public static BillingService getInstance() {
        return ourInstance;
    }

    private BillingService() {
    }


    Invoice[] invoices = {
            new Invoice(), new Invoice()
    };


    @Override
    public void saveInvoice(Invoice invoice) {
        // TODO write the code
    }
}
