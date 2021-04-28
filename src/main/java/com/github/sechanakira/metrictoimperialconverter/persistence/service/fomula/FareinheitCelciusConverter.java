package com.github.sechanakira.metrictoimperialconverter.persistence.service.fomula;

public class FareinheitCelciusConverter implements ConversionFormula {

    @Override
    public Double convertFrom(double unit) {
        return (unit * 9 / 5) + 32;
    }

    @Override
    public Double convertTo(double unit) {
        return (unit - 32) / 1.8;
    }
}
