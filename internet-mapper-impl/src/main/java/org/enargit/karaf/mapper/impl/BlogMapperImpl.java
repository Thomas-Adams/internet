package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.BlogDTO;
import org.enargit.karaf.core.entities.Blog;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.BlogMapper;
import org.enargit.karaf.mapper.impl.converter.BlogDTOToBlogConverter;
import org.enargit.karaf.mapper.impl.converter.BlogToBlogDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = BlogMapper.class, name = "BlogMapper", immediate = true)
public class BlogMapperImpl extends AbstractMapperImpl implements BlogMapper {

    @Override
    public List<Blog> convertToEntityList(List<BlogDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<BlogDTO> convertToDTOList(List<Blog> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<Blog> convertToEntitySet(Set<BlogDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<BlogDTO> convertToDTOSet(Set<Blog> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public Blog convertToEntity(BlogDTO dto) {
        ModelMapper modelMapper=initMapper();
        TypeMap<BlogDTO, Blog> map = modelMapper.createTypeMap(BlogDTO.class, Blog.class);
        map.addMappings(mapper -> {
            mapper.using(new BlogDTOToBlogConverter());
        });
        return modelMapper.map(dto, Blog.class);
    }

    @Override
    public BlogDTO convertToDTO(Blog entity) {
        ModelMapper modelMapper=initMapper();
        TypeMap<Blog, BlogDTO> map = modelMapper.createTypeMap(Blog.class, BlogDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new BlogToBlogDTOConverter());
        });
        return modelMapper.map(entity, BlogDTO.class);
    }

    @Override
    public Page<Blog> convertToEntityPage(Page<BlogDTO> dtoPage) {
        List<Blog> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<Blog>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<BlogDTO> convertToDTOPage(Page<Blog> entityPage) {
        List<BlogDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<BlogDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
