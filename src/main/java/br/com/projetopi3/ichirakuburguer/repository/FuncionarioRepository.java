package br.com.projetopi3.ichirakuburguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetopi3.ichirakuburguer.data.FuncionarioEntity;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer>{

}
