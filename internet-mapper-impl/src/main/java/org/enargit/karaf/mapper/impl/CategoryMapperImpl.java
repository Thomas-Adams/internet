package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.CategoryDTO;
import org.enargit.karaf.core.entities.Category;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.CategoryMapper;
import org.enargit.karaf.mapper.impl.converter.CategoryDTOToCategoryConverter;
import org.enargit.karaf.mapper.impl.converter.CategoryToCategoryDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = CategoryMapper.class, name = "CategoryMapper", immediate = true)
public class CategoryMapperImpl extends AbstractMapperImpl implements CategoryMapper {

    @Override
    public List<Category> convertToEntityList(List<CategoryDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<CategoryDTO> convertToDTOList(List<Category> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<Category> convertToEntitySet(Set<CategoryDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<CategoryDTO> convertToDTOSet(Set<Category> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public Category convertToEntity(CategoryDTO dto) {
        ModelMapper modelMapper = initMapper();
        TypeMap<CategoryDTO, Category> map = modelMapper.createTypeMap(CategoryDTO.class, Category.class);
        map.addMappings(mapper -> {
            mapper.using(new CategoryDTOToCategoryConverter());
        });
        return modelMapper.map(dto, Category.class);
    }

    @Override
    public CategoryDTO convertToDTO(Category entity) {
        ModelMapper modelMapper = initMapper();
        TypeMap<Category, CategoryDTO> map = modelMapper.createTypeMap(Category.class, CategoryDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new CategoryToCategoryDTOConverter());
        });
        return modelMapper.map(entity, CategoryDTO.class);
    }

    @Override
    public Page<Category> convertToEntityPage(Page<CategoryDTO> dtoPage) {
        List<Category> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<Category>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<CategoryDTO> convertToDTOPage(Page<Category> entityPage) {
        List<CategoryDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<CategoryDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
