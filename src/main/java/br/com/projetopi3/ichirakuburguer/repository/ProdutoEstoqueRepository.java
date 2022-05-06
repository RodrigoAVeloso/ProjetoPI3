package br.com.projetopi3.ichirakuburguer.repository;

import br.com.projetopi3.ichirakuburguer.data.produto.ProdutoEstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoEstoqueRepository extends JpaRepository<ProdutoEstoqueEntity, Integer> {

}
