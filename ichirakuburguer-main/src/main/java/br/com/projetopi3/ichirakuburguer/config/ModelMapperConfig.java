package br.com.projetopi3.ichirakuburguer.config;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConfig {

    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
