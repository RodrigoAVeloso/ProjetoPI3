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
import br.com.projetopi3.ichirakuburguer.dto.ProdutoVendaDto;
import br.com.projetopi3.ichirakuburguer.service.ProdutoEstoqueService;
import br.com.projetopi3.ichirakuburguer.service.ProdutoVendaService;

@Controller
public class ProdutoVendaController {

    @Autowired(required = true)
    ProdutoVendaService service;
    
    @Autowired(required = true)
    ProdutoEstoqueService servicePe;

    @GetMapping("/produtos/todos")
    public ModelAndView todosProdutos(ModelMap model) {
        List<ProdutoVendaDto> produtos = service.todosProdutos();
        ModelAndView mv = new ModelAndView("produto/venda/listaprodutos");
        System.out.println(produtos.toString());
        mv.addObject("produtos", produtos);
       

        return mv;
    }


    @GetMapping("/produtos/novo")
    public ModelAndView criaProduto(ProdutoVendaDto produto, ProdutoEstoqueDto produtoDto){
    	List<ProdutoEstoqueDto> produtosEstoque = servicePe.pegarTodos();
        ModelAndView mv = new ModelAndView("produto/venda/novoprodutovenda");
        mv.addObject("produtosEstoque", produtosEstoque);
       return mv;
    }

    
    @GetMapping("/produtos/{codigo}")
    public ModelAndView show(@PathVariable Integer codigo) {
    	if (service.encontrarPorCodigo(codigo) != null) {
			
    		ProdutoVendaDto produto = service.encontrarPorCodigo(codigo);
    		ModelAndView mv = new ModelAndView("produto/venda/showProduto.html");
    		mv.addObject("produto", produto);
    		
    		return mv;
    		
		}else {
			return new ModelAndView("redirect:/produtos/todos");
		}
    }

    @PostMapping("/produtos/novo")
    public ModelAndView novoProduto(@Valid ProdutoVendaDto produto, BindingResult br, ProdutoEstoqueDto produtoDto){
    	System.out.println(produto);
    	if (br.hasErrors()) {
			ModelAndView mv = new ModelAndView("produto/venda/novoprodutovenda");
			
			return mv;
		}
    	
        service.salvarProduto(produto);
        System.out.println();
        return new ModelAndView("redirect:/produtos/todos");
    }

    @GetMapping("/produtos/excluir")
    public String excluiProduto(@RequestParam Integer codigo){
        service.deletarProduto(codigo);
        return "redirect:/produtos/todos";
    }
}
