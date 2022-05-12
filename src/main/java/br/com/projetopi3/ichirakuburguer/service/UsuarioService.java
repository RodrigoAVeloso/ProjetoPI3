package br.com.projetopi3.ichirakuburguer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.projetopi3.ichirakuburguer.data.UsuarioEntity;
import br.com.projetopi3.ichirakuburguer.dto.UsuarioDto;
import br.com.projetopi3.ichirakuburguer.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired(required = true)
	private UsuarioRepository repository;
	
	
	@Transactional
    public boolean salvaFuncionario(UsuarioDto usuario){
        UsuarioEntity entity = new UsuarioEntity();
        BeanUtils.copyProperties(usuario, entity);
        System.out.println(entity);
        repository.save(entity);
        return true;
    }
	
	public List<UsuarioDto> pegarTodos(){
        List<UsuarioEntity> usuarios = repository.findAll();
        List<UsuarioDto> usuarioDtoList = new ArrayList<UsuarioDto>();
        for(UsuarioEntity usuario : usuarios){
            UsuarioDto dto = new UsuarioDto();
            BeanUtils.copyProperties(usuario, dto);
            usuarioDtoList.add(dto);
        }
        System.out.println("service: "+usuarioDtoList.toString());
        return usuarioDtoList;
    }
	
	public void deletarUsuario(Integer id) {
		repository.deleteById(id);
	}
	
}
