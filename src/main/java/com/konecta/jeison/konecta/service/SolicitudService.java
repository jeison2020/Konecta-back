package com.konecta.jeison.konecta.service;

import com.konecta.jeison.konecta.model.Empleado;
import com.konecta.jeison.konecta.model.Solicitud;
import com.konecta.jeison.konecta.repository.SolicitudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;
    Logger logger = LoggerFactory.getLogger(SolicitudService.class);


    public Solicitud save(Solicitud solicitud) throws Exception{
        try{
         return solicitudRepository.save(solicitud);

        }catch (Exception e){
            logger.debug("", e);
            throw new  Exception(e);

        }

    }

    public Solicitud getSolicitudById(long id) throws Exception {
        try{
            return solicitudRepository.findById(id).orElse(null);

        }catch (Exception e){
            logger.debug("", e);
            throw new  Exception(e);

        }

    }

    public List<Solicitud> getAllSolicitud() throws Exception {
        try{
            return solicitudRepository.findAll();
        }catch (Exception e){
            logger.debug("", e);
            throw new  Exception(e);

        }

    }

    public void delete(long id) throws Exception {
        try{
            solicitudRepository.deleteById(id);
        }catch (Exception e){
            logger.debug("", e);
            throw new Exception(e);

        }
    }


}
