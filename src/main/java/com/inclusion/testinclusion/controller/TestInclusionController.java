package com.inclusion.testinclusion.controller;

import com.inclusion.testinclusion.dto.TestInclusionDTO;
import com.inclusion.testinclusion.service.TestInclusionService;
import com.inclusion.testinclusion.service.TestInclusionServiceImpl;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/api")
public class TestInclusionController {

    @Autowired
    private TestInclusionServiceImpl testInclusionService;

    @GetMapping(value = "/obtenerDatos", name = "obtenerDatos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerDatos(@Parameter(name = "x",
            required = true,
            description = "Valor de la variable X") Integer x,
                                          @Parameter(name = "y", required = true,
                                                  description = "Valor de la variable Y. Este valor no puede ser mayor a la variable X ") Integer y,
                                          @Parameter(name = "n", required = true,
                                                  description = "Valor de la variable N. Este valor no puede ser menor a la variable Y") Integer n){
        String mensajeValidacion = validarDatosEntrada(x, y, n);
        if(mensajeValidacion != null){
            return new ResponseEntity<String>(mensajeValidacion, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<TestInclusionDTO>(testInclusionService.obtenerDatos(x,y,n), HttpStatus.OK);
    }

    @PostMapping(value = "/obtenerDatos", name = "obtenerDatos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerDatos(@RequestBody TestInclusionDTO datos){
        String mensajeValidacion = validarDatosEntrada(datos.getX(), datos.getY(), datos.getN());
        if(mensajeValidacion != null){
            return new ResponseEntity<String>(mensajeValidacion, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<TestInclusionDTO>(testInclusionService.obtenerDatos(datos.getX(), datos.getY(), datos.getN()), HttpStatus.OK);
    }



    /**
     * Metodo que valida los datos de entrada del servicio.
     * @param X Valor de la variable X.
     * @param Y Valor de la variable Y.
     * @param N Valor de la variable N.
     * @return Si el valor es diferente de null se ha generado una validación no exitosa en los datos de entrada.
     */
    private String validarDatosEntrada(Integer X, Integer Y, Integer N){
        String mensaje = null;
        if(Y.intValue() > X){
            mensaje = "El valor de Y no puede ser mayor que X";
        } else if(N.intValue() < Y) {
            mensaje = "El valor de N no puede ser menor que Y";
        }
        return mensaje;
    }
}
