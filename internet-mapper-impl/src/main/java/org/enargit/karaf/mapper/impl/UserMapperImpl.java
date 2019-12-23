package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.UserDTO;
import org.enargit.karaf.core.entities.User;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.UserMapper;
import org.enargit.karaf.mapper.impl.converter.UserDTOToUserConverter;
import org.enargit.karaf.mapper.impl.converter.UserToUserDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = UserMapper.class, name = "UserMapper", immediate = true)
public class UserMapperImpl implements UserMapper {

    @Override
    public List<User> convertToEntityList(List<UserDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> convertToDTOList(List<User> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<User> convertToEntitySet(Set<UserDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<UserDTO> convertToDTOSet(Set<User> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public User convertToEntity(UserDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setDeepCopyEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<UserDTO, User> map = modelMapper.createTypeMap(UserDTO.class, User.class);
        map.addMappings(mapper -> {
            mapper.using(new UserDTOToUserConverter());
        });
        return modelMapper.map(dto, User.class);
    }

    @Override
    public UserDTO convertToDTO(User entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setDeepCopyEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<User, UserDTO> map = modelMapper.createTypeMap(User.class, UserDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new UserToUserDTOConverter());
        });
        return modelMapper.map(entity, UserDTO.class);
    }

    @Override
    public Page<User> convertToEntityPage(Page<UserDTO> dtoPage) {
        List<User> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<User>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<UserDTO> convertToDTOPage(Page<User> entityPage) {
        List<UserDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<UserDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
