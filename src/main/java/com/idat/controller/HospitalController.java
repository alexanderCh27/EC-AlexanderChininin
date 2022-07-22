package com.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.dto.request.HospitalEditar;
import com.idat.dto.request.HospitalRegistrar;
import com.idat.model.Hospital;
import com.idat.service.HospitalService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class HospitalController {

	 @Autowired
	    private HospitalService servicio;

	    @RequestMapping(path = "/hospital/listar", method = RequestMethod.GET)
	    public ResponseEntity<List<Hospital>> listarHospitales(){
	        return new ResponseEntity<List<Hospital>>(servicio.listar(), HttpStatus.CREATED);  
	    }

	    @RequestMapping(path = "/hospital/guardar", method = RequestMethod.POST)
	    public ResponseEntity<Void> guardar(@RequestBody HospitalRegistrar hospital){
	        servicio.registro(hospital);
	        return  new ResponseEntity<Void>(HttpStatus.CREATED);    
	    }

	    @RequestMapping(path = "/hospital/listar/{id}" , method = RequestMethod.GET)
	    public ResponseEntity<Hospital> listarPorId(@PathVariable Integer id) {
	        Hospital c = servicio.buscarId(id);
	        if(c != null) {
	            return new ResponseEntity<Hospital>(c, HttpStatus.OK);
	        }
	        return new ResponseEntity<Hospital>(HttpStatus.NOT_FOUND);
	    }

	    @RequestMapping(path = "/hospital/editar", method = RequestMethod.PUT)
	    public ResponseEntity<Void> editar(@RequestBody HospitalEditar hospital){
	        Hospital c = servicio.buscarId(hospital.getIdHospital());
	        if(c != null) {
	            servicio.actualizarHospital(hospital);
	            return new ResponseEntity<Void>(HttpStatus.OK);
	        }
	        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	    }

	    @RequestMapping(path = "/hospital/eliminar/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
	        Hospital c = servicio.buscarId(id);
	        if(c != null) {
	            servicio.eliminar(id);
	            return new ResponseEntity<Void>(HttpStatus.OK);
	        }
	        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	    }
	
}
