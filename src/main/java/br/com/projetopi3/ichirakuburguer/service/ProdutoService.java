package br.com.projetopi3.ichirakuburguer.service;

import br.com.projetopi3.ichirakuburguer.data.produto.ProdutoEntity;
import br.com.projetopi3.ichirakuburguer.repository.ProdutoRepository;
import br.com.projetopi3.ichirakuburguer.dto.produto.ProdutoDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired(required = true)
    private ProdutoRepository produtoRepository;



    @Transactional
    public boolean salvaProduto(ProdutoDto produto){
        ProdutoEntity entity = new ProdutoEntity();
        BeanUtils.copyProperties(produto, entity);
        System.out.println(entity);
        produtoRepository.save(entity);
        return true;
    }

    public List<ProdutoDto> pegarTodos(){
        List<ProdutoEntity> produtos = produtoRepository.findAll();
        List<ProdutoDto> produtoDtoList = new ArrayList<ProdutoDto>();
        for(ProdutoEntity produto : produtos){
            ProdutoDto dto = new ProdutoDto();
            BeanUtils.copyProperties(produto, dto);
            produtoDtoList.add(dto);
        }
        System.out.println("service: "+produtoDtoList.toString());
        return produtoDtoList;
    }

    public void deletarProdiuto(Integer codigo){
        produtoRepository.deleteById(codigo);
    }
}
