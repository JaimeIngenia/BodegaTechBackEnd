package com.example.turismoapp3.servicios;

import com.example.turismoapp3.modelos.Mercancia;
import com.example.turismoapp3.repositorios.MercanciaRepositorio;
import com.example.turismoapp3.validaciones.MercanciaValidacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercanciaServicio {
    @Autowired
    MercanciaRepositorio objetoMercanciaRepositorio;
    @Autowired
    MercanciaValidacion objetoMercanciaValidacion;

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

    public Mercancia modificarMercancia(Integer id, Mercancia datosAModificar)throws Exception{
        try{

            //validamos la informacion
            if(!this.objetoMercanciaValidacion.validarNombre(datosAModificar.getNombre())){
                throw new Exception("error en el dato entregado");
            }

            //buscar que la empresa que tiene el id que envia el usuario exista en BD
            Optional<Mercancia> mercanciaEncontrada=this.objetoMercanciaRepositorio.findById(id);
            //pregunto si lo que busque esta vacio (QUE NO ESTA)
            if(mercanciaEncontrada.isEmpty()){
                throw new Exception("Mercancia no encontrada");
            }
            //Rutina POR SI SI LA ENCONTRE
            //1.Convierto el opcional en la entidad respectiva
            Mercancia mercanciaQueExiste=mercanciaEncontrada.get();

            //2. A la empresa que existe le cambio la informacion que el usuario necesita
            mercanciaQueExiste.setNombre(datosAModificar.getNombre());
            mercanciaQueExiste.setDescripcion(datosAModificar.getDescripcion());
            mercanciaQueExiste.setFechaEntrada(datosAModificar.getFechaEntrada());
            mercanciaQueExiste.setMotivoDevolucion(datosAModificar.getMotivoDevolucion());
            mercanciaQueExiste.setVolumen(datosAModificar.getVolumen());


            //3. Guardar la informacion que se acaba de editar (SET)
            return (this.objetoMercanciaRepositorio.save(mercanciaQueExiste));


        }catch(Exception error){
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

    public Mercancia buscarMercanciaPorId(Integer id) throws Exception{
        try{
            Optional<Mercancia> mercanciaOptional= this.objetoMercanciaRepositorio.findById(id);
            if(mercanciaOptional.isEmpty()){
                throw new Exception("Mercancia no encontrada");
            }
            return mercanciaOptional.get();
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean eliminarMercancia(Integer id) throws  Exception{
        try{

            Optional<Mercancia> empresaOpcional=this.objetoMercanciaRepositorio.findById(id);

            if(empresaOpcional.isPresent()){
                this.objetoMercanciaRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("mercancia no encontrada");
            }


        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
