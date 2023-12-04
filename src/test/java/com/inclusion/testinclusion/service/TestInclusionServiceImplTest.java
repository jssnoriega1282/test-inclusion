package com.inclusion.testinclusion.service;

import com.inclusion.testinclusion.dto.TestInclusionDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestInclusionServiceImplTest {

    @InjectMocks
    private TestInclusionServiceImpl testInclusionService;

    private List<TestInclusionDTO> datos;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        datos = new ArrayList<>();
        for(int t=0;t<50000;t++){
            int numeroX = (int)(Math.random()*50000+1);
            int numeroY = (int)(Math.random()*numeroX+1);//y NUNCA DEBE SER MAYOR X
            int numeroN = (int)(Math.random()*(numeroX-numeroY+1)+numeroY);//n NUNCA DEBE SER MENOR A Y
            datos.add(new TestInclusionDTO(numeroX,numeroY,numeroN));
        }

    }

    @Test
    void obtenerDatos() {
        for(TestInclusionDTO dato: datos){
            assertNotNull(testInclusionService.obtenerDatos(dato.getX(), dato.getY(), dato.getN()));
        }
    }
}