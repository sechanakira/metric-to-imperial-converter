package com.github.sechanakira.metrictoimperialconverter.persistence.service;

import com.github.sechanakira.metrictoimperialconverter.dto.Conversion;
import com.github.sechanakira.metrictoimperialconverter.dto.ConversionRequest;
import com.github.sechanakira.metrictoimperialconverter.exception.ConversionNotFoundException;
import com.github.sechanakira.metrictoimperialconverter.persistence.domain.ConversionType;
import com.github.sechanakira.metrictoimperialconverter.persistence.domain.MetricImperialConversion;
import com.github.sechanakira.metrictoimperialconverter.persistence.repository.MetricImperialConversionRepository;
import com.github.sechanakira.metrictoimperialconverter.persistence.service.fomula.ConversionFormula;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class MetricImperialConversionService {

    private final MetricImperialConversionRepository repository;

    public MetricImperialConversionService(final MetricImperialConversionRepository repository) {
        this.repository = repository;
    }

    public Double convert(final ConversionRequest dto) {
        final Optional<MetricImperialConversion> conversion = repository.findConversionBySourceUnitAndDestinationUnit(dto.getSourceUnit(), dto.getDestinationUnit());
        final Optional<MetricImperialConversion> inverseConversion = repository.findConversionBySourceUnitAndDestinationUnit(dto.getDestinationUnit(), dto.getSourceUnit());
        if (conversion.isPresent()) {
            if (conversion.get().getConversionType() == ConversionType.RATE) {
                return conversion.get().getToRate() * dto.getAmount();
            } else {
                try {
                    final Object converter = Class.forName(conversion.get().getConverter()).getDeclaredConstructor().newInstance();
                    return ((ConversionFormula) converter).convertFrom(dto.getAmount());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                throw new ConversionNotFoundException();
            }
        } else {
            if (inverseConversion.isPresent()) {
                if (inverseConversion.get().getConversionType() == ConversionType.RATE) {
                    return inverseConversion.get().getFromRate() * dto.getAmount();
                } else {
                    try {
                        final Object converter = Class.forName(inverseConversion.get().getConverter()).getDeclaredConstructor().newInstance();
                        return ((ConversionFormula) converter).convertTo(dto.getAmount());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    throw new ConversionNotFoundException();
                }
            }
            throw new ConversionNotFoundException();
        }
    }

    public Conversion add(final Conversion dto) {
        if (!repository.findConversionBySourceUnitAndDestinationUnit(dto.getSourceUnit(), dto.getDestinationUnit()).isPresent()) {
            final MetricImperialConversion conversion = new MetricImperialConversion();
            conversion.setDestinationUnit(dto.getDestinationUnit());
            conversion.setSourceUnit(dto.getSourceUnit());
            conversion.setName(dto.getName());
            conversion.setFromRate(dto.getFromRate());
            conversion.setToRate(dto.getToRate());
            conversion.setConversionType(ConversionType.valueOf(dto.getConversionType()));
            conversion.setConverter(dto.getConverter());
            repository.saveAndFlush(conversion);
        }
        return dto;
    }

    public List<Conversion> list() {
        final List<Conversion> conversions = new LinkedList<>();
        repository.findAll().forEach(metricImperialConversion -> {
            final Conversion conversion = new Conversion();
            conversion.setDestinationUnit(metricImperialConversion.getDestinationUnit());
            conversion.setSourceUnit(metricImperialConversion.getSourceUnit());
            conversion.setFromRate(metricImperialConversion.getFromRate());
            conversion.setToRate(metricImperialConversion.getToRate());
            conversion.setName(metricImperialConversion.getName());
            conversion.setConverter(metricImperialConversion.getConverter());
            conversions.add(conversion);
        });
        return conversions;
    }
}
