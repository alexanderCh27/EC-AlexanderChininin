package com.idat.service;

import java.util.List;


import com.idat.dto.request.UsuarioClienteEditar;
import com.idat.dto.request.UsuarioClienteRegistrar;
import com.idat.model.UsuarioCliente;

public interface UsuarioClienteService {

	public void registro(UsuarioClienteRegistrar usrCliente);
	public void actualizar(UsuarioClienteEditar usrCliente);
	public List<UsuarioCliente> listar();
	public UsuarioCliente buscarId(Integer id);
	public void eliminar(Integer id);
}
