package com.example.turismoapp3.controladores;

import com.example.turismoapp3.modelos.Zona;
import com.example.turismoapp3.servicios.ZonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zona")
public class ZonaControlador {

    @Autowired
    ZonaServicio objetoZonaServicio;

    @PostMapping
    public ResponseEntity<?> registrarZona(@RequestBody Zona datosZona){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(objetoZonaServicio.registrarZona(datosZona));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarZona(@RequestBody Zona datosNuevosZona, @PathVariable Integer id){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(objetoZonaServicio.modificarZona(id,datosNuevosZona));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }


    @GetMapping
    public ResponseEntity<?> buscarTodasZona(){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(objetoZonaServicio.buscarTodasZona());

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUnaZona(@PathVariable Integer id){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(objetoZonaServicio.buscarZonaPorId(id));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarZona(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(objetoZonaServicio.eliminarZona(id));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

}
