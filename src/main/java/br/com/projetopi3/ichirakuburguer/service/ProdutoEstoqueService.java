package br.com.projetopi3.ichirakuburguer.service;

import br.com.projetopi3.ichirakuburguer.data.produto.ProdutoEstoqueEntity;
import br.com.projetopi3.ichirakuburguer.repository.ProdutoEstoqueRepository;
import br.com.projetopi3.ichirakuburguer.dto.produto.ProdutoEstoqueDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoEstoqueService {

    @Autowired(required = true)
    private ProdutoEstoqueRepository repository;



    @Transactional
    public boolean salvaProduto(ProdutoEstoqueDto produto){
        ProdutoEstoqueEntity entity = new ProdutoEstoqueEntity();
        BeanUtils.copyProperties(produto, entity);
        System.out.println(entity);
        repository.save(entity);
        return true;
    }

    public List<ProdutoEstoqueDto> pegarTodos(){
        List<ProdutoEstoqueEntity> produtos = repository.findAll();
        List<ProdutoEstoqueDto> produtoDtoList = new ArrayList<ProdutoEstoqueDto>();
        for(ProdutoEstoqueEntity produto : produtos){
            ProdutoEstoqueDto dto = new ProdutoEstoqueDto();
            BeanUtils.copyProperties(produto, dto);
            produtoDtoList.add(dto);
        }
        System.out.println("service: "+produtoDtoList.toString());
        return produtoDtoList;
    }

    public void deletarProdiuto(Integer codigo){
        repository.deleteById(codigo);
    }
}
