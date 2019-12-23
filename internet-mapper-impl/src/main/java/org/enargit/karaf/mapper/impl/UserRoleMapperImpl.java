package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.UserRoleDTO;
import org.enargit.karaf.core.entities.UserRole;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.UserRoleMapper;
import org.enargit.karaf.mapper.impl.converter.UserRoleDTOToUserRoleConverter;
import org.enargit.karaf.mapper.impl.converter.UserRoleToUserRoleDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = UserRoleMapper.class, name = "UserRoleMapper", immediate = true)
public class UserRoleMapperImpl implements UserRoleMapper {

    @Override
    public List<UserRole> convertToEntityList(List<UserRoleDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<UserRoleDTO> convertToDTOList(List<UserRole> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<UserRole> convertToEntitySet(Set<UserRoleDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<UserRoleDTO> convertToDTOSet(Set<UserRole> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public UserRole convertToEntity(UserRoleDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setDeepCopyEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<UserRoleDTO, UserRole> map = modelMapper.createTypeMap(UserRoleDTO.class, UserRole.class);
        map.addMappings(mapper -> {
            mapper.using(new UserRoleDTOToUserRoleConverter());
        });
        return modelMapper.map(dto, UserRole.class);
    }

    @Override
    public UserRoleDTO convertToDTO(UserRole entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setDeepCopyEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<UserRole, UserRoleDTO> map = modelMapper.createTypeMap(UserRole.class, UserRoleDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new UserRoleToUserRoleDTOConverter());
        });
        return modelMapper.map(entity, UserRoleDTO.class);
    }

    @Override
    public Page<UserRole> convertToEntityPage(Page<UserRoleDTO> dtoPage) {
        List<UserRole> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<UserRole>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<UserRoleDTO> convertToDTOPage(Page<UserRole> entityPage) {
        List<UserRoleDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<UserRoleDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
