package br.com.projetopi3.ichirakuburguer.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetopi3.ichirakuburguer.dto.ProdutoEstoqueDto;
import br.com.projetopi3.ichirakuburguer.service.ProdutoEstoqueService;

@Controller
public class ProdutoEstoqueController {

    @Autowired(required = true)
    ProdutoEstoqueService service;

    @GetMapping("/estoque/todos")
    public ModelAndView todosProdutos(ModelMap model) {
        List<ProdutoEstoqueDto> produtos = service.pegarTodos();
        ModelAndView mv = new ModelAndView("produto/estoque/listaestoque");
        System.out.println(produtos.toString());
        mv.addObject("produtos", produtos);

        return mv;
    }


    @GetMapping("/estoque/novo")
    public ModelAndView criaProduto(ProdutoEstoqueDto produto){
        ModelAndView mv = new ModelAndView("produto/estoque/novoproduto");
       return mv;
    }
    
    @GetMapping("/estoque/{codigo}")
	public ModelAndView show(@PathVariable Integer codigo) {
		if (service.encontrarPorCodigo(codigo) != null) {
			
			ProdutoEstoqueDto produto = service.encontrarPorCodigo(codigo);
			System.out.println();
			System.out.println(produto);
			System.out.println();
			ModelAndView mv = new ModelAndView("produto/estoque/showEstoque.html");
			mv.addObject("produto", produto);

			return mv;
		}else {
			return new ModelAndView("redirect:/estoque/todos");
		}
    }

    @PostMapping("/estoque/novo")
    public ModelAndView novoProduto(@Valid ProdutoEstoqueDto produto, BindingResult br){
    	System.out.println(produto);
        if(br.hasErrors()) {
        	ModelAndView mv = new ModelAndView("produto/estoque/novoproduto");
        	return mv;
        }
        service.salvaProduto(produto);
        System.out.println();
        return new ModelAndView("redirect:/estoque/todos");
    }

    @GetMapping("/estoque/excluir")
    public String excluiProduto(@RequestParam Integer codigo){
        service.deletarProduto(codigo);
        return "redirect:/estoque/todos";
    }
}
