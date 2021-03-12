package com.konecta.jeison.konecta.service;

import com.konecta.jeison.konecta.model.Empleado;

import com.konecta.jeison.konecta.repository.EmpleadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

     Logger logger = LoggerFactory.getLogger(EmpleadoService.class);

     @Autowired
     private EmpleadoRepository empleadoRepository;


     public Empleado save(Empleado empleado) throws Exception {
          try{
              return empleadoRepository.save(empleado);
          }catch (Exception e){
               logger.debug("", e);
               throw new Exception(e);

          }

     }


     public Empleado getEmpleadoById(long id) throws Exception {
          try{
               return  empleadoRepository.findById(id).orElse(null);
          }catch (Exception e){
               logger.debug("", e);
               throw new Exception(e);

          }


     }

     public List<Empleado> getAllEmpleado() throws Exception {
          try{
               return empleadoRepository.findAll();
          }catch (Exception e){
               logger.debug("", e);
               throw new Exception(e);

          }
     }


     public void delete(long id) throws Exception {
          try{
                empleadoRepository.deleteById(id);
          }catch (Exception e){
               logger.debug("", e);
               throw new Exception(e);

          }
     }


}
