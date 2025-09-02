package com.seuprojeto.chatbot.mapper;

import com.seuprojeto.chatbot.dto.HorarioDTO;
import com.seuprojeto.chatbot.entity.HorarioDisponivelEntity;
import org.springframework.beans.BeanUtils;

public class HorarioMapper {

    //Converte entidade em DTO
    public static HorarioDTO toDTO(HorarioDisponivelEntity entity){
        if(entity == null) return null;
        HorarioDTO dto = new HorarioDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    //Converte DTO em entidade
    public static HorarioDisponivelEntity toEntity(HorarioDTO dto){
        if(dto == null) return null;
        HorarioDisponivelEntity entity = new HorarioDisponivelEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
