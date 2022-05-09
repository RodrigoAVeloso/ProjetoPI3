package br.com.projetopi3.ichirakuburguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetopi3.ichirakuburguer.data.produtoVenda.ProdutoVendaEntity;

public interface ProdutoVendaRepository extends JpaRepository<ProdutoVendaEntity, Integer> {

}
