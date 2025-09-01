package com.seuprojeto.chatbot.mapper;

import com.seuprojeto.chatbot.dto.ClienteDTO;
import com.seuprojeto.chatbot.entity.ClienteEntity;
import org.springframework.beans.BeanUtils;

public class ClienteMapper {

    //Converte entidade em DTO
    public static ClienteDTO toDTO(ClienteEntity entity){
        if(entity == null) return null;
        ClienteDTO dto = new ClienteDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;

    }

    //Converte DTO em entidade
    public static ClienteEntity toEntity(ClienteDTO dto){
        if(dto == null) return null;
        ClienteEntity entity = new ClienteEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
