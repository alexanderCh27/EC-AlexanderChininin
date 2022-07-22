package com.idat.service;

import java.util.List;


import com.idat.dto.request.HospitalEditar;
import com.idat.dto.request.HospitalRegistrar;

import com.idat.model.Hospital;

public interface HospitalService {
	public void registro(HospitalRegistrar hospital);
	public void actualizarHospital(HospitalEditar hospital);
	public List<Hospital> listar();
	public Hospital buscarId(Integer id);
	public void eliminar(Integer id);
	
}
