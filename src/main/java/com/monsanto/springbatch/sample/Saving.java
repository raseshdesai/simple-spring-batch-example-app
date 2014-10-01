package com.monsanto.springbatch.sample;

/**
 * Created by IntelliJ IDEA.
 * User: Rasesh Desai
 * Date: 6/21/13
 * Time: 12:04 PM
 */
public class Saving {
    private Integer customerId;
    private String spendingRef;
    private Double purchaseAmount;
    private Double savingAmount;

    public Saving(Integer customerId, String party, Double purchaseAmount, Double savingAmount) {

        this.customerId = customerId;
        this.spendingRef = party;
        this.purchaseAmount = purchaseAmount;
        this.savingAmount = savingAmount;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getSpendingRef() {
        return spendingRef;
    }

    public Double getPurchaseAmount() {
        return purchaseAmount;
    }

    public Double getSavingAmount() {
        return savingAmount;
    }
}
