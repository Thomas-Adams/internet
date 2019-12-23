package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.SubscriptionDTO;
import org.enargit.karaf.core.entities.Subscription;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.SubscriptionMapper;
import org.enargit.karaf.mapper.impl.converter.SubscriptionDTOToSubscriptionConverter;
import org.enargit.karaf.mapper.impl.converter.SubscriptionToSubscriptionDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = SubscriptionMapper.class, name = "SubscriptionMapper", immediate = true)
public class SubscriptionMapperImpl extends AbstractMapperImpl implements SubscriptionMapper {

    @Override
    public List<Subscription> convertToEntityList(List<SubscriptionDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<SubscriptionDTO> convertToDTOList(List<Subscription> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<Subscription> convertToEntitySet(Set<SubscriptionDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<SubscriptionDTO> convertToDTOSet(Set<Subscription> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public Subscription convertToEntity(SubscriptionDTO dto) {
        ModelMapper modelMapper = initMapper();
        TypeMap<SubscriptionDTO, Subscription> map = modelMapper.createTypeMap(SubscriptionDTO.class, Subscription.class);
        map.addMappings(mapper -> {
            mapper.using(new SubscriptionDTOToSubscriptionConverter());
        });
        return modelMapper.map(dto, Subscription.class);
    }

    @Override
    public SubscriptionDTO convertToDTO(Subscription entity) {
        ModelMapper modelMapper = initMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setDeepCopyEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<Subscription, SubscriptionDTO> map = modelMapper.createTypeMap(Subscription.class, SubscriptionDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new SubscriptionToSubscriptionDTOConverter());
        });
        return modelMapper.map(entity, SubscriptionDTO.class);
    }

    @Override
    public Page<Subscription> convertToEntityPage(Page<SubscriptionDTO> dtoPage) {
        List<Subscription> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<Subscription>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<SubscriptionDTO> convertToDTOPage(Page<Subscription> entityPage) {
        List<SubscriptionDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<SubscriptionDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
