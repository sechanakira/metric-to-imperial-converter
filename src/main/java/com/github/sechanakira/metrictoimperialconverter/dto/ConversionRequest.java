package com.github.sechanakira.metrictoimperialconverter.dto;

import javax.validation.constraints.NotNull;

public class ConversionRequest {

    @NotNull(message = "sourceUnit cannot be null")
    private String sourceUnit;

    @NotNull(message = "destinationUnit cannot be null")
    private String destinationUnit;

    @NotNull(message = "amount cannot be null")
    private Double amount;

    public String getSourceUnit() {
        return sourceUnit;
    }

    public void setSourceUnit(String sourceUnit) {
        this.sourceUnit = sourceUnit;
    }

    public String getDestinationUnit() {
        return destinationUnit;
    }

    public void setDestinationUnit(String destinationUnit) {
        this.destinationUnit = destinationUnit;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
