package br.com.projetopi3.ichirakuburguer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.projetopi3.ichirakuburguer.data.FuncionarioEntity;
import br.com.projetopi3.ichirakuburguer.dto.FuncionarioDto;
import br.com.projetopi3.ichirakuburguer.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired(required = true)
	private FuncionarioRepository repository;
	
	
	@Transactional
    public boolean salvaFuncionario(FuncionarioDto usuario){
        FuncionarioEntity entity = new FuncionarioEntity();
        BeanUtils.copyProperties(usuario, entity);
        System.out.println(entity);
        repository.save(entity);
        return true;
    }
	
	public List<FuncionarioDto> pegarTodos(){
        List<FuncionarioEntity> usuarios = repository.findAll();
        List<FuncionarioDto> usuarioDtoList = new ArrayList<FuncionarioDto>();
        for(FuncionarioEntity usuario : usuarios){
            FuncionarioDto dto = new FuncionarioDto();
            BeanUtils.copyProperties(usuario, dto);
            usuarioDtoList.add(dto);
        }
        System.out.println("service: "+usuarioDtoList.toString());
        return usuarioDtoList;
    }
	
	@Transactional
	public void deletarUsuario(Integer id) {
		repository.deleteById(id);
	}
	
	public FuncionarioDto encontrarPorId(Integer id) {
		 Optional<FuncionarioEntity> optional = this.repository.findById(id);

	        if (optional.isPresent()) {
	        	FuncionarioEntity usuario = optional.get();

	        	FuncionarioDto dto = new FuncionarioDto();
	    		BeanUtils.copyProperties(usuario, dto);
	    		return dto;
	        }
	        else {
	            return null;
	        }
	}
	
}
