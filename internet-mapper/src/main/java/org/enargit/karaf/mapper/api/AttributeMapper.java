package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.AttributeDTO;
import org.enargit.karaf.core.entities.Attribute;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface AttributeMapper extends BaseMapper  {

        List<Attribute> convertToEntityList(List<AttributeDTO> dtoList);

        List<AttributeDTO> convertToDTOList(List<Attribute> entityList);

        Set<Attribute> convertToEntitySet(Set<AttributeDTO> dtoSet);
        
        Set<AttributeDTO> convertToDTOSet(Set<Attribute> entitySet);

        Attribute convertToEntity(AttributeDTO dto);

        AttributeDTO convertToDTO(Attribute entity);

        Page<Attribute> convertToEntityPage(Page<AttributeDTO> dtoPage);

        Page<AttributeDTO> convertToDTOPage(Page<Attribute> entityPage);

}
