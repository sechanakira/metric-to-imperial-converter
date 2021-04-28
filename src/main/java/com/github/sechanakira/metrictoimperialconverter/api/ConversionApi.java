package com.github.sechanakira.metrictoimperialconverter.api;

import com.github.sechanakira.metrictoimperialconverter.dto.Conversion;
import com.github.sechanakira.metrictoimperialconverter.dto.ConversionRequest;
import com.github.sechanakira.metrictoimperialconverter.persistence.service.MetricImperialConversionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conversion")
public class ConversionApi {

    private final MetricImperialConversionService service;

    public ConversionApi(final MetricImperialConversionService service) {
        this.service = service;
    }

    @PostMapping
    public Double convert(@RequestBody final ConversionRequest dto) {
        return service.convert(dto);
    }

    @PostMapping
    @ResponseBody
    @RequestMapping("/add")
    public Conversion add(@RequestBody final Conversion dto) {
        return service.add(dto);
    }

    @GetMapping
    @ResponseBody
    public List<Conversion> list() {
        return service.list();
    }
}
