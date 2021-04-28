package com.github.sechanakira.metrictoimperialconverter.persistence.repository;

import com.github.sechanakira.metrictoimperialconverter.persistence.domain.MetricImperialConversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MetricImperialConversionRepository extends JpaRepository<MetricImperialConversion, Long> {
    Optional<MetricImperialConversion> findConversionBySourceUnit(final String sourceUnit);

    Optional<MetricImperialConversion> findConversionBySourceUnitAndDestinationUnit(final String sourceUnit, final String destinationUnit);
}
