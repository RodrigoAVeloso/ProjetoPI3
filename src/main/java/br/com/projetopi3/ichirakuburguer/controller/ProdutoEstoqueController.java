package br.com.projetopi3.ichirakuburguer.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetopi3.ichirakuburguer.dto.produto.ProdutoEstoqueDto;
import br.com.projetopi3.ichirakuburguer.service.ProdutoEstoqueService;

@Controller
@RequestMapping(value = "/produtos")
public class ProdutoEstoqueController {

    @Autowired
    ProdutoEstoqueService service;

    @GetMapping("/todosprodutos")
    public ModelAndView todosProdutos(ModelMap model) {
        List<ProdutoEstoqueDto> produtos = service.pegarTodos();
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
    public String novoProduto(ProdutoEstoqueDto produto){
        System.out.println();
        System.out.println(produto);
        service.salvaProduto(produto);
        System.out.println();
        return "redirect:/todosprodutos";
    }

    @GetMapping("/excluirproduto")
    public String excluiProduto(@RequestParam Integer codigo){
        service.deletarProdiuto(codigo);
        return "redirect:/todosprodutos";
    }
}