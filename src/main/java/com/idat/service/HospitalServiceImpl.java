package com.idat.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.dto.request.HospitalEditar;
import com.idat.dto.request.HospitalRegistrar;
import com.idat.model.Hospital;
import com.idat.repository.HospitalRepository;


@Service
public class HospitalServiceImpl implements HospitalService{

    @Autowired
    HospitalRepository repo;

    @Override
    public void registro(HospitalRegistrar hospital) {
        Hospital h = new Hospital();
        h.setNombre(hospital.getNombre());
        h.setDescripcion(hospital.getDescripcion());
        h.setDistrito(hospital.getDistrito());
       repo.save(h);
    }

	@Override
	public void actualizarHospital(HospitalEditar hospital) {
		// TODO Auto-generated method stub
		  Hospital h = new Hospital();
	        h.setNombre(hospital.getNombre());
	        h.setDescripcion(hospital.getDescripcion());
	        h.setDistrito(hospital.getDistrito());
	        h.setIdHospital(hospital.getIdHospital());
	        repo.saveAndFlush(h);
	}

	@Override
	public List<Hospital> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Hospital buscarId(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}


}