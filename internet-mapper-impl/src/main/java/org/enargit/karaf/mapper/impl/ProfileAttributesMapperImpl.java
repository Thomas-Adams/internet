package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.ProfileAttributesDTO;
import org.enargit.karaf.core.entities.ProfileAttributes;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.ProfileAttributesMapper;
import org.enargit.karaf.mapper.impl.converter.ProfileAttributesDTOToProfileAttributesConverter;
import org.enargit.karaf.mapper.impl.converter.ProfileAttributesToProfileAttributesDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = ProfileAttributesMapper.class, name = "ProfileAttributesMapper", immediate = true)
public class ProfileAttributesMapperImpl extends AbstractMapperImpl implements ProfileAttributesMapper {

    @Override
    public List<ProfileAttributes> convertToEntityList(List<ProfileAttributesDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<ProfileAttributesDTO> convertToDTOList(List<ProfileAttributes> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<ProfileAttributes> convertToEntitySet(Set<ProfileAttributesDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<ProfileAttributesDTO> convertToDTOSet(Set<ProfileAttributes> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public ProfileAttributes convertToEntity(ProfileAttributesDTO dto) {
        ModelMapper modelMapper = initMapper();
        TypeMap<ProfileAttributesDTO, ProfileAttributes> map = modelMapper.createTypeMap(ProfileAttributesDTO.class, ProfileAttributes.class);
        map.addMappings(mapper -> {
            mapper.using(new ProfileAttributesDTOToProfileAttributesConverter());
        });
        return modelMapper.map(dto, ProfileAttributes.class);
    }

    @Override
    public ProfileAttributesDTO convertToDTO(ProfileAttributes entity) {
        ModelMapper modelMapper = initMapper();
        TypeMap<ProfileAttributes, ProfileAttributesDTO> map = modelMapper.createTypeMap(ProfileAttributes.class, ProfileAttributesDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new ProfileAttributesToProfileAttributesDTOConverter());
        });
        return modelMapper.map(entity, ProfileAttributesDTO.class);
    }

    @Override
    public Page<ProfileAttributes> convertToEntityPage(Page<ProfileAttributesDTO> dtoPage) {
        List<ProfileAttributes> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<ProfileAttributes>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<ProfileAttributesDTO> convertToDTOPage(Page<ProfileAttributes> entityPage) {
        List<ProfileAttributesDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<ProfileAttributesDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
