package com.example.turismoapp3.servicios;

import com.example.turismoapp3.modelos.Mercancia;
import com.example.turismoapp3.modelos.Zona;
import com.example.turismoapp3.repositorios.ZonaRepositorio;
import com.example.turismoapp3.validaciones.ZonaValidacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZonaServicio {

    @Autowired
    ZonaRepositorio objetoZonaRepositorio;
    @Autowired
    ZonaValidacion objetoZonaValidacion;

    public Zona registrarZona(Zona datosARegistrar) throws Exception{
        try{
            //validaciones
          /*  if(!this.objetoOfertaValidacion.validarTitulo(datosARegistrar.getTitulo())){
                throw new Exception("error en el servicio");
            }*/

            //falta validar el nit

            //SI PASO TODOS LOS IF ESTOY LISTO PARA LLAMAR AL REPO
            return(this.objetoZonaRepositorio.save(datosARegistrar));

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Zona modificarZona(Integer id, Zona datosAModificar)throws Exception{
        try{

            //validamos la informacion
            if(!this.objetoZonaValidacion.validarNombre(datosAModificar.getNombre())){
                throw new Exception("error en el dato entregado");
            }

            //buscar que la empresa que tiene el id que envia el usuario exista en BD
            Optional<Zona> zonaEncontrada=this.objetoZonaRepositorio.findById(id);
            //pregunto si lo que busque esta vacio (QUE NO ESTA)
            if(zonaEncontrada.isEmpty()){
                throw new Exception("zona no encontrada");
            }
            //Rutina POR SI SI LA ENCONTRE
            //1.Convierto el opcional en la entidad respectiva
            Zona zonaQueExiste=zonaEncontrada.get();

            //2. A la empresa que existe le cambio la informacion que el usuario necesita
            zonaQueExiste.setNombre(datosAModificar.getNombre());

            //3. Guardar la informacion que se acaba de editar (SET)
            return (this.objetoZonaRepositorio.save(zonaQueExiste));


        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }


    public List<Zona> buscarTodasZona() throws Exception{
        try{
            List<Zona>listaZona= this.objetoZonaRepositorio.findAll();
            return listaZona;

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Zona buscarZonaPorId(Integer id) throws Exception{
        try{
            Optional<Zona> mercanciaOptional= this.objetoZonaRepositorio.findById(id);
            if(mercanciaOptional.isEmpty()){
                throw new Exception("zona no encontrada");
            }
            return mercanciaOptional.get();
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean eliminarZona(Integer id) throws  Exception{
        try{

            Optional<Zona> empresaOpcional=this.objetoZonaRepositorio.findById(id);

            if(empresaOpcional.isPresent()){
                this.objetoZonaRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("zona no encontrada");
            }


        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
