package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.TagDTO;
import org.enargit.karaf.core.entities.Tag;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.TagMapper;
import org.enargit.karaf.mapper.impl.converter.TagDTOToTagConverter;
import org.enargit.karaf.mapper.impl.converter.TagToTagDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = TagMapper.class, name = "TagMapper", immediate = true)
public class TagMapperImpl extends AbstractMapperImpl implements TagMapper {

    @Override
    public List<Tag> convertToEntityList(List<TagDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<TagDTO> convertToDTOList(List<Tag> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<Tag> convertToEntitySet(Set<TagDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<TagDTO> convertToDTOSet(Set<Tag> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public Tag convertToEntity(TagDTO dto) {
        ModelMapper modelMapper = initMapper();
        TypeMap<TagDTO, Tag> map = modelMapper.createTypeMap(TagDTO.class, Tag.class);
        map.addMappings(mapper -> {
            mapper.using(new TagDTOToTagConverter());
        });
        return modelMapper.map(dto, Tag.class);
    }

    @Override
    public TagDTO convertToDTO(Tag entity) {
        ModelMapper modelMapper = initMapper();
        TypeMap<Tag, TagDTO> map = modelMapper.createTypeMap(Tag.class, TagDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new TagToTagDTOConverter());
        });
        return modelMapper.map(entity, TagDTO.class);
    }

    @Override
    public Page<Tag> convertToEntityPage(Page<TagDTO> dtoPage) {
        List<Tag> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<Tag>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<TagDTO> convertToDTOPage(Page<Tag> entityPage) {
        List<TagDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<TagDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
