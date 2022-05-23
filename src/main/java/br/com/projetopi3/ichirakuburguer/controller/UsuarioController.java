package br.com.projetopi3.ichirakuburguer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetopi3.ichirakuburguer.dto.UsuarioDto;
import br.com.projetopi3.ichirakuburguer.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	@Autowired
	LoginController loginController;
	
	@GetMapping("/funcionarios/todos")
	public ModelAndView todosUsuarios(){
		List<UsuarioDto> usuarios = service.pegarTodos();
		ModelAndView mv = new ModelAndView("usuario/todosusuarios");
		mv.addObject("usuarios", usuarios);
		return mv;
	}
	
	@GetMapping("/funcionarios/novo")
	public ModelAndView criarFuncionario(UsuarioDto usuario) {
		ModelAndView mv = new ModelAndView("usuario/novousuario");
		return mv;
	}
	
	@PostMapping("/funcionarios/novo")
	@PreAuthorize("hasRole('ADMIN')")
	public ModelAndView novoUsuario(@Valid UsuarioDto usuario, BindingResult br) {
		
		if(br.hasErrors()) {
			System.out.println();
			System.out.println(usuario);
			System.out.println();
			ModelAndView mv = new ModelAndView("usuario/novousuario");
			return mv;
		}
		
		service.salvaFuncionario(usuario);
		loginController.salvarLogin(usuario);
		return new ModelAndView("redirect:/funcionarios/todos");
	}
	
	 @GetMapping("/excluirusuario")
	 @PreAuthorize("hasRole('ADMIN')")
	    public String excluiProduto(@RequestParam Integer id){
	        service.deletarUsuario(id);
	        return "redirect:/funcionarios/todos";
	    }
}
