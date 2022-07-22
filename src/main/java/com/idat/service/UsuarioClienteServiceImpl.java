package com.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.dto.request.UsuarioClienteEditar;
import com.idat.dto.request.UsuarioClienteRegistrar;
import com.idat.model.Cliente;
import com.idat.model.UsuarioCliente;
import com.idat.repository.ClienteRepository;
import com.idat.repository.UsuarioClienteRepository;

@Service
public class UsuarioClienteServiceImpl implements UsuarioClienteService{

	@Autowired
    UsuarioClienteRepository repo;

    @Autowired
    ClienteRepository repoCli;
	
	@Override
	public void registro(UsuarioClienteRegistrar usrCliente) {
		// TODO Auto-generated method stub
		
		 	UsuarioCliente u = new UsuarioCliente();
	        u.setUsuario(usrCliente.getUsuario());
	        u.setPassword(usrCliente.getPassword());
	        u.setRol(usrCliente.getRol());

	        Cliente cliente = repoCli.findById(usrCliente.getIdCliente()).get();
	        u.setCliente(cliente);
	        repo.save(u);
	}

	@Override
	public void actualizar(UsuarioClienteEditar usrCliente) {
		// TODO Auto-generated method stub
		
		 UsuarioCliente u = new UsuarioCliente();
	        u.setUsuario(usrCliente.getUsuario());
	        u.setPassword(usrCliente.getPassword());
	        u.setRol(usrCliente.getRol());
	        repo.saveAndFlush(u);
	}

	@Override
	public List<UsuarioCliente> listar() {
		// TODO Auto-generated method stub
		  return repo.findAll();
	}

	@Override
	public UsuarioCliente buscarId(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		  repo.deleteById(id);
	}

	
	
}
