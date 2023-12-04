package com.inclusion.testinclusion.service;

import com.inclusion.testinclusion.dto.TestInclusionDTO;
import org.springframework.stereotype.Service;

@Service
public class TestInclusionServiceImpl implements TestInclusionService {

    @Override
    public TestInclusionDTO obtenerDatos(Integer X, Integer Y, Integer N) {
        TestInclusionDTO datos = new TestInclusionDTO(X,Y,N);
        datos.setK( datos.getN() - ( (datos.getN() - datos.getY() ) % datos.getX() ) );
        return datos;
    }

}
