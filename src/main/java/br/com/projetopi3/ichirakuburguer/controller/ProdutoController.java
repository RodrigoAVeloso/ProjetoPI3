package br.com.projetopi3.ichirakuburguer.controller;


import br.com.projetopi3.ichirakuburguer.dto.produto.ProdutoDto;
import br.com.projetopi3.ichirakuburguer.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping("/todosprodutos")
    public ModelAndView todosProdutos(ModelMap model) {
        List<ProdutoDto> produtos = service.pegarTodos();
        ModelAndView mv = new ModelAndView("produto/listaprodutos");
        System.out.println(produtos.toString());
        mv.addObject("produtos", produtos);

        return mv;
    }


    @GetMapping("/novoproduto")
    public ModelAndView criaProduto(){
        ModelAndView mv = new ModelAndView("produto/novoproduto");
       return mv;
    }


    @PostMapping("/novoproduto")
    public String novoProduto(ProdutoDto produto){
        System.out.println();
        System.out.println(produto);
        service.salvaProduto(produto);
        System.out.println();
        return "redirect:/todosprodutos";
    }
}
