package com.konecta.jeison.konecta.controller;

import com.konecta.jeison.konecta.model.Empleado;
import com.konecta.jeison.konecta.model.Solicitud;
import com.konecta.jeison.konecta.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v001/solicitud")
@CrossOrigin(origins = "*")
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;



    @PostMapping
    public ResponseEntity<Solicitud> saveSolicitud(
            @RequestBody Solicitud solicitud
    ) throws Exception {

        Solicitud solicitudTemp = solicitudService.save(solicitud);
        if (solicitudTemp != null){
            return new ResponseEntity( solicitudTemp, HttpStatus.OK);
        }else{
            return null;
        }


    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Solicitud>> getAll() throws Exception{
        List<Solicitud> solicitudes = solicitudService.getAllSolicitud();
        if (!solicitudes.isEmpty()){
            return new ResponseEntity( solicitudes, HttpStatus.OK);
        }else{
            return null;
        }
    }

    @GetMapping(value = "/{id:[0-9]+}")
    public ResponseEntity<Solicitud> findById(@PathVariable long id) throws Exception{
        Solicitud solicitudTemp = solicitudService.getSolicitudById(id);
        if (solicitudTemp != null){
            return new ResponseEntity( solicitudTemp, HttpStatus.OK);
        }else{
            return null;
        }


    }


    @DeleteMapping(value = "/{id:[0-9]+}")
    public ResponseEntity<Empleado> Delete(@PathVariable long id) throws Exception{
        try {
            solicitudService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
