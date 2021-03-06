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
        ModelAndView mv = new ModelAndView("produto/estoque/listaEstoque");
        System.out.println(produtos.toString());
        mv.addObject("produtos", produtos);

        return mv;
    }


    @GetMapping("/estoque/novo")
    public ModelAndView criaProduto(ProdutoEstoqueDto produto){
        ModelAndView mv = new ModelAndView("produto/estoque/novoEstoque");
       return mv;
    }
    
    @GetMapping("/estoque/{codigo}")
	public ModelAndView show(@PathVariable Integer codigo, ProdutoEstoqueDto produtoEstoque) {
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
    public ModelAndView novoEstoque(@Valid ProdutoEstoqueDto produto, BindingResult br){
    	System.out.println(produto);
        if(br.hasErrors()) {
        	ModelAndView mv = new ModelAndView("produto/estoque/novoEstoque");
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
    
    @GetMapping("/estoque/editar/{codigo}")
    public ModelAndView edit(@PathVariable Integer codigo, ProdutoEstoqueDto produto) {
    	
		if (service.encontrarPorCodigo(codigo) != null) {
			ProdutoEstoqueDto produtoDto = service.encontrarPorCodigo(codigo);
			produto.fromEstoque(produtoDto);
			ModelAndView mv = new ModelAndView("/produto/estoque/estoqueEdit");
			return mv;
		} else {
			return new ModelAndView("redirect:/produtos/todos");
		}

    }
    @PostMapping("/estoque/editar/{codigo}")
    public ModelAndView update(@PathVariable Integer codigo, ProdutoEstoqueDto produto, BindingResult br) {
    	
    	if(br.hasErrors()){
    		ProdutoEstoqueDto produtoDto = service.encontrarPorCodigo(codigo);
    		produto.fromEstoque(produtoDto);
    		ModelAndView mv = new ModelAndView("/produto/estoque/estoqueEdit");
    		return mv;
    	}else {
    		if(service.encontrarPorCodigo(codigo) != null) {
    			ProdutoEstoqueDto produtoDto = service.encontrarPorCodigo(codigo);
    			
    			produtoDto.setPreco(produto.getPreco());
    			produtoDto.setProdutoNome(produto.getProdutoNome());
    			produtoDto.setQtd(produto.getQtd());
    			
    			service.salvaProduto(produtoDto);
    			
    			return new ModelAndView("redirect:/estoque/" + codigo);
    		}else {
    		return new ModelAndView("redirect:/produtos/todos");
    		}
    	}
    	
    }
}
