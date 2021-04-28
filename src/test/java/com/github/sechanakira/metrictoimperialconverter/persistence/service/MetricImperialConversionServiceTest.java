package com.github.sechanakira.metrictoimperialconverter.persistence.service;

import com.github.sechanakira.metrictoimperialconverter.dto.ConversionRequest;
import com.github.sechanakira.metrictoimperialconverter.persistence.domain.ConversionType;
import com.github.sechanakira.metrictoimperialconverter.persistence.domain.MetricImperialConversion;
import com.github.sechanakira.metrictoimperialconverter.persistence.repository.MetricImperialConversionRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MetricImperialConversionServiceTest {

    private MetricImperialConversionService service;

    @MockBean
    private MetricImperialConversionRepository repository;

    @BeforeAll
    void init() {
        service = new MetricImperialConversionService(repository);
    }

    @Test
    void conversionShouldReturnCorrectResultsForCelciusToFareinheitConversion() {
        final ConversionRequest dto = new ConversionRequest();
        dto.setAmount(120.00);
        dto.setSourceUnit("c");
        dto.setDestinationUnit("f");

        final MetricImperialConversion conversion = new MetricImperialConversion();
        conversion.setConversionType(ConversionType.FORMULA);
        conversion.setConverter("com.github.sechanakira.metrictoimperialconverter.persistence.service.fomula.FareinheitCelciusConverter");

        given(repository.findConversionBySourceUnitAndDestinationUnit("c", "f")).willReturn(Optional.of(conversion));

        assertEquals(248, service.convert(dto));
    }

    @Test
    void conversionShouldReturnCorrectResultsForFareinheitToCelciusConversion() {
        final ConversionRequest dto = new ConversionRequest();
        dto.setAmount(248.00);
        dto.setSourceUnit("f");
        dto.setDestinationUnit("c");

        final MetricImperialConversion conversion = new MetricImperialConversion();
        conversion.setConversionType(ConversionType.FORMULA);
        conversion.setConverter("com.github.sechanakira.metrictoimperialconverter.persistence.service.fomula.FareinheitCelciusConverter");

        given(repository.findConversionBySourceUnitAndDestinationUnit("c", "f")).willReturn(Optional.of(conversion));

        assertEquals(120, service.convert(dto));
    }

    @Test
    void standardConversionShouldWork() {
        final ConversionRequest dto = new ConversionRequest();
        dto.setAmount(200.00);
        dto.setSourceUnit("m");
        dto.setDestinationUnit("in");

        final MetricImperialConversion conversion = new MetricImperialConversion();
        conversion.setConversionType(ConversionType.RATE);
        conversion.setToRate(39.37);
        conversion.setFromRate(0.0254);

        given(repository.findConversionBySourceUnitAndDestinationUnit("m", "in")).willReturn(Optional.of(conversion));

        assertEquals(7873.999999999999, service.convert(dto));
    }
}
