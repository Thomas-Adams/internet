package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.RoleDTO;
import org.enargit.karaf.core.entities.Role;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.RoleMapper;
import org.enargit.karaf.mapper.impl.converter.RoleDTOToRoleConverter;
import org.enargit.karaf.mapper.impl.converter.RoleToRoleDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = RoleMapper.class, name = "RoleMapper", immediate = true)
public class RoleMapperImpl implements RoleMapper {

    @Override
    public List<Role> convertToEntityList(List<RoleDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<RoleDTO> convertToDTOList(List<Role> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<Role> convertToEntitySet(Set<RoleDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<RoleDTO> convertToDTOSet(Set<Role> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public Role convertToEntity(RoleDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setDeepCopyEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<RoleDTO, Role> map = modelMapper.createTypeMap(RoleDTO.class, Role.class);
        map.addMappings(mapper -> {
            mapper.using(new RoleDTOToRoleConverter());
        });
        return modelMapper.map(dto, Role.class);
    }

    @Override
    public RoleDTO convertToDTO(Role entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setDeepCopyEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<Role, RoleDTO> map = modelMapper.createTypeMap(Role.class, RoleDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new RoleToRoleDTOConverter());
        });
        return modelMapper.map(entity, RoleDTO.class);
    }

    @Override
    public Page<Role> convertToEntityPage(Page<RoleDTO> dtoPage) {
        List<Role> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<Role>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<RoleDTO> convertToDTOPage(Page<Role> entityPage) {
        List<RoleDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<RoleDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
