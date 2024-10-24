package com.examencl3.JuanPereyra.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examencl3.JuanPereyra.modelo.ClassMedico;
import com.examencl3.JuanPereyra.repositorio.IMedicoRepository;


@Service
public class ClassMedicoServicioImp implements IMedicoServicio {

	@Autowired
	private IMedicoRepository imedicorepository;

	@Override
	public void RegistrarMedico(ClassMedico clmedico) {

		imedicorepository.save(clmedico);
	}

	@Override
	public List<ClassMedico> ListadoMedico() {
		return (List<ClassMedico>) imedicorepository.findAll();
	}

	@Override
	public void EliminarMedico(Integer id) {
		imedicorepository.deleteById(id);

	}

}
