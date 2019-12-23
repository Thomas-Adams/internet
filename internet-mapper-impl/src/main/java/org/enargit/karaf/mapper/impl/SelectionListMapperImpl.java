package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.SelectionListDTO;
import org.enargit.karaf.core.entities.SelectionList;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.SelectionListMapper;
import org.enargit.karaf.mapper.impl.converter.SelectionListDTOToSelectionListConverter;
import org.enargit.karaf.mapper.impl.converter.SelectionListToSelectionListDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = SelectionListMapper.class, name = "SelectionListMapper", immediate = true)
public class SelectionListMapperImpl implements SelectionListMapper {

    @Override
    public List<SelectionList> convertToEntityList(List<SelectionListDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<SelectionListDTO> convertToDTOList(List<SelectionList> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<SelectionList> convertToEntitySet(Set<SelectionListDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<SelectionListDTO> convertToDTOSet(Set<SelectionList> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public SelectionList convertToEntity(SelectionListDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setDeepCopyEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<SelectionListDTO, SelectionList> map = modelMapper.createTypeMap(SelectionListDTO.class, SelectionList.class);
        map.addMappings(mapper -> {
            mapper.using(new SelectionListDTOToSelectionListConverter());
        });
        return modelMapper.map(dto, SelectionList.class);
    }

    @Override
    public SelectionListDTO convertToDTO(SelectionList entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setDeepCopyEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<SelectionList, SelectionListDTO> map = modelMapper.createTypeMap(SelectionList.class, SelectionListDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new SelectionListToSelectionListDTOConverter());
        });
        return modelMapper.map(entity, SelectionListDTO.class);
    }

    @Override
    public Page<SelectionList> convertToEntityPage(Page<SelectionListDTO> dtoPage) {
        List<SelectionList> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<SelectionList>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<SelectionListDTO> convertToDTOPage(Page<SelectionList> entityPage) {
        List<SelectionListDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<SelectionListDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
