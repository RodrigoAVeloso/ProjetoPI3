package br.com.projetopi3.ichirakuburguer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetopi3.ichirakuburguer.dto.usuario.UsuarioDto;
import br.com.projetopi3.ichirakuburguer.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	@GetMapping("/todosfuncionarios")
	public ModelAndView todosUsuarios(){
		List<UsuarioDto> usuarios = service.pegarTodos();
		ModelAndView mv = new ModelAndView("usuario/todosusuarios");
		mv.addObject("usuarios", usuarios);
		return mv;
	}
	
	@GetMapping("/novofuncionario")
	public ModelAndView criarFuncionario() {
		ModelAndView mv = new ModelAndView("usuario/novousuario");
		return mv;
	}
	
	@PostMapping("/novofuncionario")
	public String novoUsuario(UsuarioDto usuario) {
		service.salvaFuncionario(usuario);
		return "redirect:/todosfuncionarios";
	}
	
	 @GetMapping("/excluirusuario")
	    public String excluiProduto(@RequestParam Integer id){
	        service.deletarUsuario(id);
	        return "redirect:/todosfuncionarios";
	    }
}
