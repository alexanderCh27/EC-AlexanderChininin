package com.idat.service;

import java.util.List;

import com.idat.dto.request.ClienteEditar;
import com.idat.dto.request.ClienteRegistrar;
import com.idat.dto.response.ClienteList;
import com.idat.model.Cliente;

public interface ClienteService {

	public void registo(ClienteRegistrar cliente);
	public void actualizarCliente(ClienteEditar cliente);
	public List<Cliente> listar();
	public ClienteList  buscarId(Integer id);
	public void eliminar(Integer id);
	
}
