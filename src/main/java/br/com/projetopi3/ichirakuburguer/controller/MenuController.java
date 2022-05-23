package br.com.projetopi3.ichirakuburguer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {
	
	@GetMapping("menu")
	public ModelAndView menu() {
		ModelAndView mv = new ModelAndView("index.html");
		return mv;
	}
	
	@GetMapping("produtos")
	public ModelAndView menuProduto() {
		ModelAndView mv = new ModelAndView("produto/produtomenu.html");
		return mv;
	}
	
	
}
