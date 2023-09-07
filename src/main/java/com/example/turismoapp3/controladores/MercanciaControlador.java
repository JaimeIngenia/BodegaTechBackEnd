package com.example.turismoapp3.controladores;

import com.example.turismoapp3.modelos.Mercancia;
import com.example.turismoapp3.servicios.MercanciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mercancia")
public class MercanciaControlador {
    @Autowired
    MercanciaServicio  objetoMercanciaServicio;

    @PostMapping
    public ResponseEntity<?> registrarMercancia(@RequestBody Mercancia datosMercancia){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(objetoMercanciaServicio.registrarMercancia(datosMercancia));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodasMercancias(){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(objetoMercanciaServicio.buscarTodasMercancias());

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
}
