package br.com.projetopi3.ichirakuburguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetopi3.ichirakuburguer.dto.LoginDto;
import br.com.projetopi3.ichirakuburguer.dto.FuncionarioDto;
import br.com.projetopi3.ichirakuburguer.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login.html");
		return mv;
	}
	
	@Transactional
	public boolean salvarLogin(FuncionarioDto usuario) {
		LoginDto login = new LoginDto();
		login.setUsuario(usuario.getUsuario());
		login.setSenha(usuario.getSenha());
		login.setAdmin(usuario.isAdministrador());
		service.salvarLogin(login);
		return true;
	}
	
	/*
	 * @Transactional public boolean editarLogin(UsuarioDto usuario) { LoginDto
	 * login = service.encontrarPorUsuario(usuario.getUsuario());
	 * login.setUsuario(usuario.getUsuario()); login.setSenha(usuario.getSenha());
	 * login.setAdmin(usuario.isAdministrador()); service.salvarLogin(login); return
	 * true; }
	 */

}
