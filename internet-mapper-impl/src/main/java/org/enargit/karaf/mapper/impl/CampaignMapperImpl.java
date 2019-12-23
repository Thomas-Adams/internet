package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.CampaignDTO;
import org.enargit.karaf.core.entities.Campaign;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.CampaignMapper;
import org.enargit.karaf.mapper.impl.converter.CampaignDTOToCampaignConverter;
import org.enargit.karaf.mapper.impl.converter.CampaignToCampaignDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = CampaignMapper.class, name = "CampaignMapper", immediate = true)
public class CampaignMapperImpl extends AbstractMapperImpl implements CampaignMapper {

    @Override
    public List<Campaign> convertToEntityList(List<CampaignDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<CampaignDTO> convertToDTOList(List<Campaign> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<Campaign> convertToEntitySet(Set<CampaignDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<CampaignDTO> convertToDTOSet(Set<Campaign> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public Campaign convertToEntity(CampaignDTO dto) {
        ModelMapper modelMapper = initMapper();
        TypeMap<CampaignDTO, Campaign> map = modelMapper.createTypeMap(CampaignDTO.class, Campaign.class);
        map.addMappings(mapper -> {
            mapper.using(new CampaignDTOToCampaignConverter());
        });
        return modelMapper.map(dto, Campaign.class);
    }

    @Override
    public CampaignDTO convertToDTO(Campaign entity) {
        ModelMapper modelMapper = initMapper();
        TypeMap<Campaign, CampaignDTO> map = modelMapper.createTypeMap(Campaign.class, CampaignDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new CampaignToCampaignDTOConverter());
        });
        return modelMapper.map(entity, CampaignDTO.class);
    }

    @Override
    public Page<Campaign> convertToEntityPage(Page<CampaignDTO> dtoPage) {
        List<Campaign> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<Campaign>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<CampaignDTO> convertToDTOPage(Page<Campaign> entityPage) {
        List<CampaignDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<CampaignDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
