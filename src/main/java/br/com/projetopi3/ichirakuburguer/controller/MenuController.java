package br.com.projetopi3.ichirakuburguer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

	@GetMapping("/")
	public ModelAndView todosProdutos(ModelMap model) {
		ModelAndView mv = new ModelAndView("index.html");
		return mv;
	}

}
