package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.CampaignDTO;
import org.enargit.karaf.core.entities.Campaign;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class CampaignToCampaignDTOConverter extends AbstractConverter<Campaign, CampaignDTO> {

    private int level;

    public CampaignToCampaignDTOConverter(int level) {
        this.level = level;
    }

    public CampaignToCampaignDTOConverter() {
        this.level =0;
    }

    @Override
    protected CampaignDTO convert(Campaign source) {
        return CampaignDTO.builder().attributes(new ArrayList<>())
                .id(source.getId())
                .name(source.getName())
                .code(source.getCode())
                .description(source.getDescription())
                .hasMailings(source.isHasMailings())
                .needsLogin(source.isNeedsLogin())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion()).build();

    }
}
