package com.monsanto.springbatch.sample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA.
 * User: Rasesh Desai
 * Date: 6/21/13
 * Time: 12:03 PM
 */
@Entity
@Table(name = "PURCHASE")
public class Purchase {

    @Id
    @Column(name = "REF_NO")
    private Integer refNo;

    @Column(name ="CUSTOMER_ID")
    private Integer customerId;

    @Column(name ="PARTY")
    private String party;

    @Column(name ="CATEGORY")
    private String category;

    @Column(name ="AMOUNT")
    private Double purchaseAmount;

    public Purchase() {
    }

    public Purchase(Integer refNo, Integer customerId, String party, String category, Double purchaseAmount) {

        this.refNo = refNo;
        this.customerId = customerId;
        this.party = party;
        this.category = category;
        this.purchaseAmount = purchaseAmount;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getParty() {
        return party;
    }

    public Double getPurchaseAmount() {
        return purchaseAmount;
    }

    public Integer getRefNo() {
        return refNo;
    }

    public String getCategory() {
        return category;
    }
}
