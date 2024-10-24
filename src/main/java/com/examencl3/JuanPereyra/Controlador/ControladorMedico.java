package com.examencl3.JuanPereyra.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examencl3.JuanPereyra.modelo.ClassMedico;
import com.examencl3.JuanPereyra.servicio.IMedicoServicio;

@Controller
@RequestMapping("/Vista")
public class ControladorMedico {

	@Autowired
	private IMedicoServicio imedicoservicio;

	@GetMapping("ListarMedico")
	public String ListarMedico(Model modelo) {
		List<ClassMedico> listado = imedicoservicio.ListadoMedico();
		modelo.addAttribute("listado", listado);
		return "/Vista/ListarMedico";
	}

	@GetMapping("/RegistrarMedico")
	public String RegistrarMedico(Model model) {
		ClassMedico clmedico = new ClassMedico();
		model.addAttribute("regmedico", clmedico);
		return "/Vista/RegistrarMedico";

	}

	@PostMapping("/GuardarMedico")
	public String GuardarMedico(@ModelAttribute ClassMedico clmedico, Model modelo) {
		imedicoservicio.RegistrarMedico(clmedico);
		System.out.println("datos registrado en bd");
		return "redirect:/Vista/ListarMedico";

	}

	@GetMapping("/eliminarmedico/{id}")
	public String eliminar(@PathVariable("id") Integer idmedico, Model modelo) {
		imedicoservicio.EliminarMedico(idmedico);
		List<ClassMedico> listado = imedicoservicio.ListadoMedico();
		modelo.addAttribute("listado", listado);
		return "redirect:/Vista/ListarMedico";

	}

}
