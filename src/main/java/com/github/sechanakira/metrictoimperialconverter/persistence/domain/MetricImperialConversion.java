package com.github.sechanakira.metrictoimperialconverter.persistence.domain;

import javax.persistence.*;

@Entity
@Table(name = "conversion")
public class MetricImperialConversion {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "source_unit")
    private String sourceUnit;

    @Column(name = "destination_unit")
    private String destinationUnit;

    @Column(name = "to_rate")
    private Double toRate;

    @Column(name = "from_rate")
    private Double fromRate;

    @Column(name = "converter")
    private String converter;

    @Enumerated(EnumType.STRING)
    @Column(name = "conversion_type")
    private ConversionType conversionType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public ConversionType getConversionType() {
        return conversionType;
    }

    public void setConversionType(ConversionType conversionType) {
        this.conversionType = conversionType;
    }

    public String getConverter() {
        return converter;
    }

    public void setConverter(String converter) {
        this.converter = converter;
    }
}
