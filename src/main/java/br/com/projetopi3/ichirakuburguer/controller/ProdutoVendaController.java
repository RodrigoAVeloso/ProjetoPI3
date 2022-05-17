package br.com.projetopi3.ichirakuburguer.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/produtos/todos/venda")
    public ModelAndView todosProdutos(ModelMap model) {
        List<ProdutoVendaDto> produtos = service.todosProdutos();
        ModelAndView mv = new ModelAndView("produto/listaprodutosvenda");
        System.out.println(produtos.toString());
        mv.addObject("produtos", produtos);
       

        return mv;
    }


    @GetMapping("/produtos/novo/venda")
    public ModelAndView criaProduto(ProdutoVendaDto produto, ProdutoEstoqueDto produtoDto){
    	List<ProdutoEstoqueDto> produtosEstoque = servicePe.pegarTodos();
        ModelAndView mv = new ModelAndView("produto/novoprodutovenda");
        mv.addObject("produtosEstoque", produtosEstoque);
       return mv;
    }


    @PostMapping("/produtos/novo/venda")
    public ModelAndView novoProduto(@Valid ProdutoVendaDto produto, BindingResult br, ProdutoEstoqueDto produtoDto){
    	System.out.println(produto);
    	if (br.hasErrors()) {
			ModelAndView mv = new ModelAndView("produto/novoprodutovenda");
			
			return mv;
		}
    	
        service.salvarProduto(produto);
        System.out.println();
        return new ModelAndView("redirect:/todosprodutos");
    }

    @GetMapping("/excluirprodutovenda")
    public String excluiProduto(@RequestParam Integer codigo){
        service.deletarProduto(codigo);
        return "redirect:/todosprodutos";
    }
}
