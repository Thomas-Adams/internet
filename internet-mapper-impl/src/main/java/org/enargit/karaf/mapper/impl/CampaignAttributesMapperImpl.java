package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.CampaignAttributesDTO;
import org.enargit.karaf.core.entities.CampaignAttributes;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.CampaignAttributesMapper;
import org.enargit.karaf.mapper.impl.converter.CampaignAttributesDTOToCampaignAttributesConverter;
import org.enargit.karaf.mapper.impl.converter.CampaignAttributesToCampaignAttributesDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = CampaignAttributesMapper.class, name = "CampaignAttributesMapper", immediate = true)
public class CampaignAttributesMapperImpl extends AbstractMapperImpl implements CampaignAttributesMapper {

    @Override
    public List<CampaignAttributes> convertToEntityList(List<CampaignAttributesDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<CampaignAttributesDTO> convertToDTOList(List<CampaignAttributes> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<CampaignAttributes> convertToEntitySet(Set<CampaignAttributesDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<CampaignAttributesDTO> convertToDTOSet(Set<CampaignAttributes> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public CampaignAttributes convertToEntity(CampaignAttributesDTO dto) {
        ModelMapper modelMapper = initMapper();
        TypeMap<CampaignAttributesDTO, CampaignAttributes> map = modelMapper.createTypeMap(CampaignAttributesDTO.class, CampaignAttributes.class);
        map.addMappings(mapper -> {
            mapper.using(new CampaignAttributesDTOToCampaignAttributesConverter());
        });
        return modelMapper.map(dto, CampaignAttributes.class);
    }

    @Override
    public CampaignAttributesDTO convertToDTO(CampaignAttributes entity) {
        ModelMapper modelMapper = initMapper();
        TypeMap<CampaignAttributes, CampaignAttributesDTO> map = modelMapper.createTypeMap(CampaignAttributes.class, CampaignAttributesDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new CampaignAttributesToCampaignAttributesDTOConverter());
        });
        return modelMapper.map(entity, CampaignAttributesDTO.class);
    }

    @Override
    public Page<CampaignAttributes> convertToEntityPage(Page<CampaignAttributesDTO> dtoPage) {
        List<CampaignAttributes> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<CampaignAttributes>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<CampaignAttributesDTO> convertToDTOPage(Page<CampaignAttributes> entityPage) {
        List<CampaignAttributesDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<CampaignAttributesDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
