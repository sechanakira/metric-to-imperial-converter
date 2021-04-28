package com.github.sechanakira.metrictoimperialconverter.persistence.service.fomula;

public interface ConversionFormula {

    Double convertFrom(double unit);

    Double convertTo(double unit);
}
