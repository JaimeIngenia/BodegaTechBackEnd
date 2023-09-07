package com.example.turismoapp3.servicios;

import com.example.turismoapp3.modelos.Mercancia;
import com.example.turismoapp3.repositorios.MercanciaRepositorio;
import com.example.turismoapp3.validaciones.MercanciaValidacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MercanciaServicio {
    @Autowired
    MercanciaRepositorio objetoMercanciaRepositorio;

    public Mercancia registrarMercancia(Mercancia datosARegistrar) throws Exception{
        try{
            //validaciones
          /*  if(!this.objetoOfertaValidacion.validarTitulo(datosARegistrar.getTitulo())){
                throw new Exception("error en el servicio");
            }*/

            //falta validar el nit

            //SI PASO TODOS LOS IF ESTOY LISTO PARA LLAMAR AL REPO
            return(this.objetoMercanciaRepositorio.save(datosARegistrar));

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Mercancia> buscarTodasMercancias() throws Exception{
        try{
            List<Mercancia>listaMercancia= this.objetoMercanciaRepositorio.findAll();
            return listaMercancia;

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
