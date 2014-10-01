package com.monsanto.springbatch.sample;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created by IntelliJ IDEA.
 * User: Rasesh Desai
 * Date: 6/21/13
 * Time: 12:03 PM
 */
public class PurchaseProcessor implements ItemProcessor<Purchase, Saving>{

    public Saving process(Purchase purchase) {
        Double savingAmount = Math.ceil(purchase.getPurchaseAmount()) - purchase.getPurchaseAmount();
        return new Saving(purchase.getCustomerId(), purchase.getParty(), purchase.getPurchaseAmount(), savingAmount);
    }
}
