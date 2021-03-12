package com.konecta.jeison.konecta.controller;

import com.konecta.jeison.konecta.model.Empleado;
import com.konecta.jeison.konecta.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v001/empleado")
@CrossOrigin(origins = "*")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<Empleado> saveEmpleado(
            @RequestBody Empleado empleado
            ) throws Exception {

        Empleado empleadoTemp = empleadoService.save(empleado);
        if (empleadoTemp != null){
            return new ResponseEntity( empleado, HttpStatus.OK);
        }else{
          return null;
        }


    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Empleado>> getAll() throws Exception{
     List<Empleado> empleados = empleadoService.getAllEmpleado();
      if (!empleados.isEmpty()){
          return new ResponseEntity( empleados, HttpStatus.OK);
      }else{
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    @GetMapping(value = "/{id:[0-9]+}")
    public ResponseEntity<Empleado> findById(@PathVariable long id) throws Exception{
        Empleado empleadoTemp = empleadoService.getEmpleadoById(id);
        if (empleadoTemp != null){
            return new ResponseEntity( empleadoTemp, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }


    @DeleteMapping(value = "/{id:[0-9]+}")
    public ResponseEntity<Empleado> Delete(@PathVariable long id) throws Exception{
        try {
            empleadoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }





}
