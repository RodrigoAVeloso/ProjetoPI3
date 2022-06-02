package br.com.projetopi3.ichirakuburguer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	LoginService serviceLogin;
	
	@Autowired
	LoginController loginController;
	
	@GetMapping("/funcionarios/todos")
	public ModelAndView todosFuncionarios(){
		List<UsuarioDto> usuarios = service.pegarTodos();
		ModelAndView mv = new ModelAndView("funcionario/todosFuncionarios");
		mv.addObject("usuarios", usuarios);
		return mv;
	}
	
	@GetMapping("/funcionarios/novo")
	public ModelAndView criarFuncionario(UsuarioDto usuario) {
		ModelAndView mv = new ModelAndView("funcionario/novoFuncionario");
		return mv;
	}
	
	@GetMapping("/funcionarios/{id}")
	public ModelAndView show(@PathVariable Integer id, UsuarioDto funcionario) {
		if (service.encontrarPorId(id) != null) {
			
			funcionario = service.encontrarPorId(id);
			ModelAndView mv = new ModelAndView("funcionario/showFuncionario");
			mv.addObject("funcionario", funcionario);

			return mv;
		}else {
			return new ModelAndView("redirect:/funcionarios/todos");
		}	
	}
	
	@PostMapping("/funcionarios/novo")
	public ModelAndView novoUsuario(@Valid UsuarioDto usuario, BindingResult br) {
		
		if(br.hasErrors()) {
			System.out.println();
			System.out.println(usuario);
			System.out.println();
			ModelAndView mv = new ModelAndView("funcionario/novoFuncionario");
			return mv;
		}
		
		service.salvaFuncionario(usuario);
		loginController.salvarLogin(usuario);
		return new ModelAndView("redirect:/funcionarios/todos");
	}
	
	 @GetMapping("/excluirusuario")
	    public String excluiProduto(@RequestParam Integer id){
		 	UsuarioDto usuario = service.encontrarPorId(id);
		 	serviceLogin.deletarLogin(usuario.getUsuario());
	        service.deletarUsuario(id);
	        return "redirect:/funcionarios/todos";
	    }
	 
	 @GetMapping("/funcionarios/editar/{id}")
	 public ModelAndView editar(@PathVariable Integer id, UsuarioDto usuario) {

			if (service.encontrarPorId(id) != null) {
				UsuarioDto funcionario = service.encontrarPorId(id);
				usuario.fromFuncionario(funcionario);
				ModelAndView mv = new ModelAndView("funcionario/editarFuncionario");
				return mv;
			} else {
				return new ModelAndView("redirect:/funcionarios/todos");
			}

		}
	 
	 @PostMapping("/funcionarios/editar/{id}")
	 public ModelAndView update(@PathVariable Integer id, @Valid UsuarioDto usuario, BindingResult br) {
		 
		 if(br.hasErrors()) {
				UsuarioDto funcionario = service.encontrarPorId(id);
				usuario.fromFuncionario(funcionario);
				ModelAndView mv = new ModelAndView("funcionario/editarFuncionario");
				return mv;
			}else {
			
				if (service.encontrarPorId(id) != null) {
					
					UsuarioDto funcionario = service.encontrarPorId(id);
					LoginDto login = serviceLogin.encontrarPorUsuario(usuario.getUsuario());
					login.setUsuario(usuario.getUsuario());
					login.setSenha(usuario.getSenha());
					serviceLogin.salvarLogin(login);
					
					
					funcionario.setAdministrador(usuario.isAdministrador());
					funcionario.setEmail(usuario.getEmail());
					funcionario.setNome(usuario.getNome());
					funcionario.setSenha(usuario.getSenha());
					funcionario.setUsuario(usuario.getUsuario());
					
					service.salvaFuncionario(funcionario);

					return new ModelAndView("redirect:/funcionarios/" + funcionario.getId());
				}else {
					return new ModelAndView("redirect:/funcionarios/todos");
				}	
			}
		 
	 }

}
