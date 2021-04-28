package com.github.sechanakira.metrictoimperialconverter.dto;

public class Conversion {

    private String name;
    private String sourceUnit;
    private String destinationUnit;
    private Double toRate;
    private Double fromRate;
    private String converter;
    private String conversionType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Double getToRate() {
        return toRate;
    }

    public void setToRate(Double toRate) {
        this.toRate = toRate;
    }

    public Double getFromRate() {
        return fromRate;
    }

    public void setFromRate(Double fromRate) {
        this.fromRate = fromRate;
    }

    public String getConversionType() {
        return conversionType;
    }

    public void setConversionType(String conversionType) {
        this.conversionType = conversionType;
    }

    public String getConverter() {
        return converter;
    }

    public void setConverter(String converter) {
        this.converter = converter;
    }
}
