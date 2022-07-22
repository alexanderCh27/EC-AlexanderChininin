package com.idat.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.idat.dto.request.Login;
import com.idat.dto.request.UsuarioClienteEditar;
import com.idat.dto.request.UsuarioClienteRegistrar;
import com.idat.dto.response.LoginResponse;
import com.idat.model.UsuarioCliente;
import com.idat.security.JwtUtil;
import com.idat.security.UserDetailService;
import com.idat.service.UsuarioClienteService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class UsuarioClienteController {
	
		@Autowired
		private JwtUtil util;
		
		@Autowired
		private UserDetailService service;
		
		@Autowired
	    private UsuarioClienteService servicio;

	    @RequestMapping(path = "/usuario/listar", method = RequestMethod.GET)
	    public ResponseEntity<List<UsuarioCliente>> listarUsuarios(){
	        return new ResponseEntity<List<UsuarioCliente>>(servicio.listar(), HttpStatus.CREATED);  
	    }

	    @RequestMapping(path = "/usuario/guardar", method = RequestMethod.POST)
	    public ResponseEntity<Void> guardar(@RequestBody UsuarioClienteRegistrar usuario){
	        servicio.registro(usuario);
	        return  new ResponseEntity<Void>(HttpStatus.CREATED);    
	    }

	    @RequestMapping(path = "/usuario/listar/{id}" , method = RequestMethod.GET)
	    public ResponseEntity<UsuarioCliente> listarPorId(@PathVariable Integer id) {
	        UsuarioCliente c = servicio.buscarId(id);
	        if(c != null) {
	            return new ResponseEntity<UsuarioCliente>(c, HttpStatus.OK);
	        }
	        return new ResponseEntity<UsuarioCliente>(HttpStatus.NOT_FOUND);
	    }

	    @RequestMapping(path = "/usuario/editar", method = RequestMethod.PUT)
	    public ResponseEntity<Void> editar(@RequestBody UsuarioClienteEditar usuario){
	        UsuarioCliente c = servicio.buscarId(usuario.getIdUsuario());
	        if(c != null) {
	            servicio.actualizar(usuario);
	            return new ResponseEntity<Void>(HttpStatus.OK);
	        }
	        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	    }

	    @RequestMapping(path = "/usuario/eliminar/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
	        UsuarioCliente c = servicio.buscarId(id);
	        if(c != null) {
	            servicio.eliminar(id);
	            return new ResponseEntity<Void>(HttpStatus.OK);
	        }
	        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	    }
	    
	    @RequestMapping(path = "/crearToken", method = RequestMethod.POST)
		public ResponseEntity<?> crearToken(@RequestBody Login dto){
			
			UserDetails detail = service.loadUserByUsername(dto.getUsuario());
			
			return ResponseEntity.ok(new LoginResponse(util.generateToken(detail.getUsername())));
		}
}
