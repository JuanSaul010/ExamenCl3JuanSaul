package com.examencl3.JuanPereyra.servicio;

import java.util.List;

import com.examencl3.JuanPereyra.modelo.ClassMedico;

public interface IMedicoServicio {
	public void RegistrarMedico(ClassMedico clmedico);
	public List<ClassMedico> ListadoMedico();
	public void EliminarMedico(Integer id);
}
