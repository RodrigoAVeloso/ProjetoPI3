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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetopi3.ichirakuburguer.dto.ProdutoEstoqueDto;
import br.com.projetopi3.ichirakuburguer.dto.ProdutoVendaDto;
import br.com.projetopi3.ichirakuburguer.service.ProdutoEstoqueService;
import br.com.projetopi3.ichirakuburguer.service.ProdutoVendaService;

@Controller
@RequestMapping("/produtos")
public class ProdutoVendaController {

    @Autowired(required = true)
    ProdutoVendaService service;
    
    @Autowired(required = true)
    ProdutoEstoqueService servicePe;

    @GetMapping("/todos")
    public ModelAndView todosProdutos(ModelMap model) {
        List<ProdutoVendaDto> produtos = service.todosProdutos();
        ModelAndView mv = new ModelAndView("produto/venda/listaProdutos");
        System.out.println(produtos.toString());
        mv.addObject("produtos", produtos);
       

        return mv;
    }


    @GetMapping("/novo")
    public ModelAndView criaProduto(ProdutoVendaDto produto, ProdutoEstoqueDto produtoDto){
    	List<ProdutoEstoqueDto> produtosEstoque = servicePe.pegarTodos();
        ModelAndView mv = new ModelAndView("produto/venda/novoProduto");
        mv.addObject("produtosEstoque", produtosEstoque);
       return mv;
    }

    
    @GetMapping("/{codigo}")
    public ModelAndView show(@PathVariable Integer codigo, ProdutoVendaDto produtoVenda) {
    	if (service.encontrarPorCodigo(codigo) != null) {
			
    		ProdutoVendaDto produto = service.encontrarPorCodigo(codigo);
    		ModelAndView mv = new ModelAndView("produto/venda/showProduto.html");
    		mv.addObject("produto", produto);
    		
    		return mv;
    		
		}else {
			return new ModelAndView("redirect:/produtos/todos");
		}
    }

    @PostMapping("/novo")
    public ModelAndView novoProduto(@Valid ProdutoVendaDto produto, BindingResult br, ProdutoEstoqueDto produtoDto){
    	System.out.println(produto);
    	if (br.hasErrors()) {
			ModelAndView mv = new ModelAndView("produto/venda/novoProduto");
			
			return mv;
		}
    	
        service.salvarProduto(produto);
        System.out.println();
        return new ModelAndView("redirect:/produtos/todos");
    }

    @GetMapping("/excluir")
    public String excluiProduto(@RequestParam Integer codigo){
        service.deletarProduto(codigo);
        return "redirect:/produtos/todos";
    }
    
    @GetMapping("/editar/{codigo}")
    public ModelAndView editar(@PathVariable Integer codigo, ProdutoVendaDto produtoVenda, BindingResult br) {
    	
    	if (service.encontrarPorCodigo(codigo) != null) {
    		ProdutoVendaDto produtoDto = service.encontrarPorCodigo(codigo);
    		produtoVenda.fromProduto(produtoDto);
    		ModelAndView mv = new ModelAndView("produto/venda/editarProduto");
        	return mv;
		}
    	return new ModelAndView("redirect:/produtos/todos");
    	
    }
    @PostMapping("/editar/{codigo}")
    public ModelAndView update(@PathVariable Integer codigo, ProdutoVendaDto produtoVenda, BindingResult br) {
    	
    	if(br.hasErrors()) {
    		ProdutoVendaDto produtoDto = service.encontrarPorCodigo(codigo);
    		produtoVenda.fromProduto(produtoDto);
    		ModelAndView mv = new ModelAndView("produto/venda/editarProduto");
    		return mv;
    	}
    	 
    	 if (service.encontrarPorCodigo(codigo) != null) {
    		 ProdutoVendaDto produtoDto = service.encontrarPorCodigo(codigo);
    		 
    		 produtoDto.setDescricao(produtoVenda.getDescricao());
    		 produtoDto.setNome(produtoVenda.getNome());
    		 produtoDto.setPreco(produtoVenda.getPreco());
    		 
    		 
    		 System.out.println();
    		 System.out.println("Produto salvo" + produtoDto);
    		 System.out.println();
    		 service.salvarProduto(produtoDto);
    		 
    		 return new ModelAndView("redirect:/produtos/" + produtoVenda.getCodigo());
    	 }else {
    	return new ModelAndView("redirect:/produtos/todos");
    	 }
    }
}
