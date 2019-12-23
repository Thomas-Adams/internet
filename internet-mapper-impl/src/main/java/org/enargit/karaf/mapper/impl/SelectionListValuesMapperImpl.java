package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.SelectionListValuesDTO;
import org.enargit.karaf.core.entities.SelectionListValues;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.SelectionListValuesMapper;
import org.enargit.karaf.mapper.impl.converter.SelectionListValuesDTOToSelectionListValuesConveter;
import org.enargit.karaf.mapper.impl.converter.SelectionListValuesToSelectionListValuesDTOConveter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = SelectionListValuesMapper.class, name = "SelectionListValuesMapper", immediate = true)
public class SelectionListValuesMapperImpl extends AbstractMapperImpl implements SelectionListValuesMapper {

    @Override
    public List<SelectionListValues> convertToEntityList(List<SelectionListValuesDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<SelectionListValuesDTO> convertToDTOList(List<SelectionListValues> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<SelectionListValues> convertToEntitySet(Set<SelectionListValuesDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<SelectionListValuesDTO> convertToDTOSet(Set<SelectionListValues> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public SelectionListValues convertToEntity(SelectionListValuesDTO dto) {
        ModelMapper modelMapper = initMapper();
        TypeMap<SelectionListValuesDTO, SelectionListValues> map = modelMapper.createTypeMap(SelectionListValuesDTO.class, SelectionListValues.class);
        map.addMappings(mapper -> {
            mapper.using(new SelectionListValuesDTOToSelectionListValuesConveter());
        });
        return modelMapper.map(dto, SelectionListValues.class);
    }

    @Override
    public SelectionListValuesDTO convertToDTO(SelectionListValues entity) {
        ModelMapper modelMapper = initMapper();
        TypeMap<SelectionListValues, SelectionListValuesDTO> map = modelMapper.createTypeMap(SelectionListValues.class, SelectionListValuesDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new SelectionListValuesToSelectionListValuesDTOConveter());
        });
        return modelMapper.map(entity, SelectionListValuesDTO.class);
    }

    @Override
    public Page<SelectionListValues> convertToEntityPage(Page<SelectionListValuesDTO> dtoPage) {
        List<SelectionListValues> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<SelectionListValues>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<SelectionListValuesDTO> convertToDTOPage(Page<SelectionListValues> entityPage) {
        List<SelectionListValuesDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<SelectionListValuesDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
