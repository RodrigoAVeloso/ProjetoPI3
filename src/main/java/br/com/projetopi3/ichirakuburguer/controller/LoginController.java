package br.com.projetopi3.ichirakuburguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetopi3.ichirakuburguer.dto.LoginDto;
import br.com.projetopi3.ichirakuburguer.dto.UsuarioDto;
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
	
	/*
	 * @PostMapping("/login") public String procurarLogin(@Valid LoginDto login,
	 * BindingResult br) { if (br.hasErrors()) { return "login"; } else {
	 * List<LoginDto> logins = service.pegarTodos();
	 * System.out.println(logins.toString()); for(LoginDto dto : logins) {
	 * if(login.getUsuario().equals(dto.getUsuario()) &&
	 * login.getSenha().equals(dto.getSenha())){ return "redirect:/v1/menu"; } }
	 * return "login";
	 * 
	 * } }
	 */
	
	@Transactional
	public boolean salvarLogin(UsuarioDto usuario) {
		LoginDto login = new LoginDto();
		login.setUsuario(usuario.getUsuario());
		login.setSenha(usuario.getSenha());
		login.setAdmin(usuario.isAdministrador());
		service.salvarLogin(login);
		return true;
	}

}
