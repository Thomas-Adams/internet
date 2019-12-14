package org.enargit.karaf.data.mapper.api;

import org.enargit.karaf.data.dto.BasicDto;
import org.enargit.karaf.data.entities.BasicEntity;
import org.enargit.karaf.data.pagination.Page;
import org.enargit.karaf.data.pagination.PageImpl;
import org.enargit.karaf.data.pagination.PageRequest;

import java.util.List;
import java.util.Set;

public interface BaseMapper<E extends BasicEntity<ID>, DTO extends BasicDto<ID>, ID> {

    List<E> convertToEntityList(List<DTO> dtoList);

    List<DTO> convertToDTOList(List<E> entityList);

    Set<E> convertToEntitySet(Set<DTO> dtoSet);

    Set<DTO> convertToDTOSet(Set<E> entitySet);

    E convertToEntity(DTO dto);

    DTO convertToDTO(E entity);

    default Page<E> convertToEntityPage(Page<DTO> dtoPage ) {
        List<E> entityList = convertToEntityList(dtoPage.getContent());
        return new PageImpl<E>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }
    default Page<DTO> convertToDTOPage(Page<E> entityPage ) {
        List<DTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<DTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}
