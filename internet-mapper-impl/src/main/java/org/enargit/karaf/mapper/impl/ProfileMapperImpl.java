package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.ProfileDTO;
import org.enargit.karaf.core.entities.Profile;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.ProfileMapper;
import org.enargit.karaf.mapper.impl.converter.ProfileDTOToProfileConverter;
import org.enargit.karaf.mapper.impl.converter.ProfileToProfileDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = ProfileMapper.class, name = "ProfileMapper", immediate = true)
public class ProfileMapperImpl implements ProfileMapper {

    @Override
    public List<Profile> convertToEntityList(List<ProfileDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<ProfileDTO> convertToDTOList(List<Profile> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<Profile> convertToEntitySet(Set<ProfileDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<ProfileDTO> convertToDTOSet(Set<Profile> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public Profile convertToEntity(ProfileDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setDeepCopyEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<ProfileDTO, Profile> map = modelMapper.createTypeMap(ProfileDTO.class, Profile.class);
        map.addMappings(mapper -> {
            mapper.using(new ProfileDTOToProfileConverter());
        });
        return modelMapper.map(dto, Profile.class);
    }

    @Override
    public ProfileDTO convertToDTO(Profile entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setDeepCopyEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<Profile, ProfileDTO> map = modelMapper.createTypeMap(Profile.class, ProfileDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new ProfileToProfileDTOConverter());
        });
        return modelMapper.map(entity, ProfileDTO.class);
    }

    @Override
    public Page<Profile> convertToEntityPage(Page<ProfileDTO> dtoPage) {
        List<Profile> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<Profile>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<ProfileDTO> convertToDTOPage(Page<Profile> entityPage) {
        List<ProfileDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<ProfileDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
