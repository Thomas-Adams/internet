package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.CampaignDTO;
import org.enargit.karaf.core.entities.Campaign;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class CampaignDTOToCampaignConverter extends AbstractConverter<CampaignDTO,Campaign> {

    private int level;

    public CampaignDTOToCampaignConverter(int level) {
        this.level = level;
    }

    public CampaignDTOToCampaignConverter() {
        this.level =0;
    }

    @Override
    protected Campaign convert(CampaignDTO source) {
        return Campaign.builder().attributes(new ArrayList<>())
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
