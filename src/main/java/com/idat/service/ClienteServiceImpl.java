package com.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.dto.request.ClienteEditar;
import com.idat.dto.request.ClienteRegistrar;
import com.idat.dto.response.ClienteList;
import com.idat.model.Cliente;
import com.idat.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	ClienteRepository repo;
	
	@Override
	public void registo(ClienteRegistrar cliente) {
		// TODO Auto-generated method stub
		Cliente cliente2 = new Cliente();
		
		cliente2.setCelular(cliente.getCelular());
		cliente2.setNombre(cliente.getNombre());
		repo.save(cliente2);
	}

	@Override
	public void actualizarCliente(ClienteEditar cliente) {
		// TODO Auto-generated method stub
		Cliente cliente2 = new Cliente();
		
		cliente2.setCelular(cliente.getCelular());
		cliente2.setIdCliente(cliente.getIdCliente());
		cliente2.setNombre(cliente.getNombre());
		repo.saveAndFlush(cliente2);
	}

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		
		return repo.findAll();
	}

	@Override
	public ClienteList buscarId(Integer id) {
		// TODO Auto-generated method stub
		Cliente cli = repo.findById(id).get();
		ClienteList cliente = new ClienteList();
		cliente.setCelular(cli.getCelular());
		cliente.setIdCliente(cli.getIdCliente());
		cliente.setNombre(cli.getNombre());
		
		return cliente;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

}
