package com.monsanto.springbatch.sample;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * User: Rasesh Desai
 * Date: 6/21/13
 * Time: 11:56 AM
 */
public class PurchaseProcessor_UT {

    @Test
    public void testProcess_BuildsSavingsItemBasedOnPurchase() throws Exception {
        Integer refNo = 1;
        Integer customerId = 2;
        String party = "Starbucks";
        String category = "FOOD";
        Double purchaseAmount = 10.55;
        Purchase purchase = new Purchase(refNo, customerId, party, category, purchaseAmount);

        PurchaseProcessor purchaseProcessor = new PurchaseProcessor();

        Saving saving = purchaseProcessor.process(purchase);
        assertEquals(customerId, saving.getCustomerId());
        assertEquals(party, saving.getSpendingRef());
        assertEquals(purchaseAmount, saving.getPurchaseAmount());
    }

    @Test
    public void testProcess_RoundsThePurchaseItemToNextDollarValueAndAddsItAsSavingAmount() throws Exception {
        Integer refNo = 1;
        Integer customerId = 2;
        String party = "Starbucks";
        String category = "FOOD";
        Double purchaseAmount = 10.55;
        Purchase purchase = new Purchase(refNo, customerId, party, category, purchaseAmount);

        PurchaseProcessor purchaseProcessor = new PurchaseProcessor();

        Saving saving = purchaseProcessor.process(purchase);
        assertEquals(customerId, saving.getCustomerId());
        assertEquals(party, saving.getSpendingRef());
        assertEquals(purchaseAmount, saving.getPurchaseAmount());
        assertNotNull(saving.getSavingAmount());
        assertEquals(0.45, saving.getSavingAmount(), 0.0000009);
    }
}
