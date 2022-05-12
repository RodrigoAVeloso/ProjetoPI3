package br.com.projetopi3.ichirakuburguer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetopi3.ichirakuburguer.dto.LoginDto;
import br.com.projetopi3.ichirakuburguer.dto.UsuarioDto;
import br.com.projetopi3.ichirakuburguer.service.LoginService;
import br.com.projetopi3.ichirakuburguer.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	@Autowired
	LoginService serviceL;
	
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
		LoginDto login = new LoginDto();
		login.setUsuario(usuario.getUsuario());
		login.setSenha(usuario.getSenha());
		serviceL.salvarLogin(login);
		service.salvaFuncionario(usuario);
		return "redirect:/todosfuncionarios";
	}
	
	 @GetMapping("/excluirusuario")
	    public String excluiProduto(@RequestParam Integer id){
	        service.deletarUsuario(id);
	        return "redirect:/todosfuncionarios";
	    }
}
