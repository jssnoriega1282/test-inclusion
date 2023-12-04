package com.inclusion.testinclusion.controller;

import com.inclusion.testinclusion.dto.TestInclusionDTO;
import com.inclusion.testinclusion.service.TestInclusionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TestInclusionControllerTest {

    private final static String BASE_URL = "/api/obtenerDatos";

    @InjectMocks
    private TestInclusionController testInclusionController;

    @Mock
    private TestInclusionServiceImpl inclusionService;

    @Test
    void obtenerDatos() {
        TestInclusionDTO dto = buildTestInclusionDTO(7,5,12345, 12339);
        when(inclusionService.obtenerDatos(any(),any(),any())).thenReturn(dto);
        ResponseEntity<TestInclusionDTO> responseEntity = (ResponseEntity<TestInclusionDTO>) testInclusionController.obtenerDatos(7,5,12345);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void obtenerDatosValidacionY() {
        ResponseEntity<String> responseEntity = (ResponseEntity<String>) testInclusionController.obtenerDatos(7,10,9);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void obtenerDatosValidacionN() {
        ResponseEntity<String> responseEntity = (ResponseEntity<String>) testInclusionController.obtenerDatos(7,5,4);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    private TestInclusionDTO buildTestInclusionDTO(Integer x, Integer y, Integer n, Integer k){
        TestInclusionDTO dto = new TestInclusionDTO(x,y,n);
        dto.setK(x);
        return dto;
    }

    @Test
    void testObtenerDatos() {
        TestInclusionDTO dto = buildTestInclusionDTO(7,5,12345, null);
        TestInclusionDTO dtoResponse = buildTestInclusionDTO(7,5,12345, 12339);
        when(inclusionService.obtenerDatos(any(),any(),any())).thenReturn(dtoResponse);
        ResponseEntity<TestInclusionDTO> responseEntity = (ResponseEntity<TestInclusionDTO>) testInclusionController.obtenerDatos(dto);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void obtenerDatosValidacionDTOAndY() {
        TestInclusionDTO dto = buildTestInclusionDTO(7,10,12345, null);
        ResponseEntity<String> responseEntity = (ResponseEntity<String>) testInclusionController.obtenerDatos(dto);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
}