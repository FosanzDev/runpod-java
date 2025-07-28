package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;

@GraphQLField(typeName = "Specifics")
public class Specifics {
    @GraphQLField(fallbackPriority = 0)
    private String stockStatus;
    
    @GraphQLField(fallbackPriority = 0)
    private Double securePrice;
    
    @GraphQLField(fallbackPriority = 0)
    private Double slsPrice;

    // Getters and Setters
    public String getStockStatus() { return stockStatus; }
    public void setStockStatus(String stockStatus) { this.stockStatus = stockStatus; }

    public Double getSecurePrice() { return securePrice; }
    public void setSecurePrice(Double securePrice) { this.securePrice = securePrice; }

    public Double getSlsPrice() { return slsPrice; }
    public void setSlsPrice(Double slsPrice) { this.slsPrice = slsPrice; }

    @Override
    public String toString() {
        return "Specifics{" +
                "stockStatus='" + stockStatus + '\'' +
                ", securePrice=" + securePrice +
                ", slsPrice=" + slsPrice +
                '}';
    }
}