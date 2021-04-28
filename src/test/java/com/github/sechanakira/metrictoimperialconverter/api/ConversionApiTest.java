package com.github.sechanakira.metrictoimperialconverter.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sechanakira.metrictoimperialconverter.dto.Conversion;
import com.github.sechanakira.metrictoimperialconverter.dto.ConversionRequest;
import com.github.sechanakira.metrictoimperialconverter.persistence.service.MetricImperialConversionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ConversionApi.class)
class ConversionApiTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private MetricImperialConversionService service;

    @Test
    void givenCorrectInputConvertShouldReturnOK() throws Exception {

        final ConversionRequest request = new ConversionRequest();

        given(service.convert(request)).willReturn(1.0);

        mvc.perform(post("/conversion")
                .content(mapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void givenCorrectInputAddShouldReturnOK() throws Exception {
        final Conversion request = new Conversion();

        given(service.add(request)).willReturn(request);

        mvc.perform(post("/conversion/add")
                .content(mapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void givenCorrectInputListShouldReturnOK() throws Exception {

        given(service.list()).willReturn(Collections.emptyList());

        mvc.perform(get("/conversion")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
