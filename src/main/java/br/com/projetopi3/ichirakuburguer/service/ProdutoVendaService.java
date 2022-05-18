package br.com.projetopi3.ichirakuburguer.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetopi3.ichirakuburguer.data.ProdutoVendaEntity;
import br.com.projetopi3.ichirakuburguer.dto.ProdutoVendaDto;
import br.com.projetopi3.ichirakuburguer.repository.ProdutoVendaRepository;

@Service
public class ProdutoVendaService {
	
	@Autowired
	ProdutoVendaRepository repository;
	
	@Transactional
	public boolean salvarProduto(ProdutoVendaDto produtoDto) {
		ProdutoVendaEntity produto = new ProdutoVendaEntity();
		BeanUtils.copyProperties(produtoDto, produto);
		repository.save(produto);
		return true;
	}
	
	public List<ProdutoVendaDto> todosProdutos(){
		List<ProdutoVendaEntity> produtos = repository.findAll();
		List<ProdutoVendaDto> listaProdutosDto = new ArrayList<ProdutoVendaDto>();
		for(ProdutoVendaEntity produto : produtos) {
			ProdutoVendaDto dto = new ProdutoVendaDto();
			BeanUtils.copyProperties(produto, dto);
			listaProdutosDto.add(dto);
		}
		return listaProdutosDto;
	}
	
	@Transactional
	public void deletarProduto(Integer codigo) {
		repository.deleteById(codigo);
	}
}
