package br.com.projetopi3.ichirakuburguer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.projetopi3.ichirakuburguer.data.ProdutoEstoqueEntity;
import br.com.projetopi3.ichirakuburguer.dto.ProdutoEstoqueDto;
import br.com.projetopi3.ichirakuburguer.repository.ProdutoEstoqueRepository;

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

    public void deletarProduto(Integer codigo){
        repository.deleteById(codigo);
    }
    
    public ProdutoEstoqueDto encontrarPorCodigo(Integer codigo) {
		 Optional<ProdutoEstoqueEntity> optional = this.repository.findById(codigo);

	        if (optional.isPresent()) {
	        	ProdutoEstoqueEntity produto = optional.get();

	        	ProdutoEstoqueDto dto = new ProdutoEstoqueDto();
	    		BeanUtils.copyProperties(produto, dto);
	    		return dto;
	        }
	        else {
	            return null;
	        }
	}
}
