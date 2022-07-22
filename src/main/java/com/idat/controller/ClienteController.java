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

import com.idat.dto.request.ClienteEditar;
import com.idat.dto.request.ClienteRegistrar;
import com.idat.dto.response.ClienteList;
import com.idat.model.Cliente;
import com.idat.service.ClienteService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ClienteController {
	 @Autowired
	    private ClienteService servicio;

	    @RequestMapping(path = "/cliente/listar", method = RequestMethod.GET)
	    public ResponseEntity<List<Cliente>> listarClientes(){
	        return new ResponseEntity<List<Cliente>>(servicio.listar(), HttpStatus.CREATED);  
	    }

	    @RequestMapping(path = "/cliente/guardar", method = RequestMethod.POST)
	    public ResponseEntity<Void> guardar(@RequestBody ClienteRegistrar cliente){
	        servicio.registo(cliente);
	        return  new ResponseEntity<Void>(HttpStatus.CREATED);    
	    }

	    @RequestMapping(path = "/cliente/listar/{id}" , method = RequestMethod.GET)
	    public ResponseEntity<ClienteList> listarPorId(@PathVariable Integer id) {
	        ClienteList c = servicio.buscarId(id);
	        if(c != null) {
	            return new ResponseEntity<ClienteList>(c, HttpStatus.OK);
	        }
	        return new ResponseEntity<ClienteList>(HttpStatus.NOT_FOUND);
	    }

	    @RequestMapping(path = "/cliente/editar", method = RequestMethod.PUT)
	    public ResponseEntity<Void> editar(@RequestBody ClienteEditar cliente){
	        ClienteList c = servicio.buscarId(cliente.getIdCliente());
	        if(c != null) {
	            servicio.actualizarCliente(cliente);
	            return new ResponseEntity<Void>(HttpStatus.OK);
	        }
	        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	    }

	    @RequestMapping(path = "/cliente/eliminar/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
	    	 ClienteList c  = servicio.buscarId(id);
	        if(c != null) {
	            servicio.eliminar(id);
	            return new ResponseEntity<Void>(HttpStatus.OK);
	        }
	        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	    }
}
