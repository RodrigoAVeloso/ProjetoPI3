package br.com.projetopi3.ichirakuburguer.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetopi3.ichirakuburguer.dto.ProdutoEstoqueDto;
import br.com.projetopi3.ichirakuburguer.service.ProdutoEstoqueService;

@Controller
public class ProdutoEstoqueController {

    @Autowired(required = true)
    ProdutoEstoqueService service;

    @GetMapping("/produtos/todos")
    public ModelAndView todosProdutos(ModelMap model) {
        List<ProdutoEstoqueDto> produtos = service.pegarTodos();
        ModelAndView mv = new ModelAndView("produto/listaprodutos");
        System.out.println(produtos.toString());
        mv.addObject("produtos", produtos);

        return mv;
    }


    @GetMapping("/produtos/novo")
    public ModelAndView criaProduto(){
        ModelAndView mv = new ModelAndView("produto/novoproduto");
       return mv;
    }


    @PostMapping("/produtos/novo")
    public String novoProduto(ProdutoEstoqueDto produto){
        
        service.salvaProduto(produto);
        System.out.println();
        return "redirect:/produtos/todos";
    }

    @GetMapping("/excluirproduto")
    public String excluiProduto(@RequestParam Integer codigo){
        service.deletarProduto(codigo);
        return "redirect:/produtos/todos";
    }
}
