package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.CampaignAttributesDTO;
import org.enargit.karaf.core.entities.CampaignAttributes;
import org.modelmapper.AbstractConverter;

public class CampaignAttributesDTOToCampaignAttributesConverter extends AbstractConverter<CampaignAttributesDTO,CampaignAttributes> {

    private int level;

    public CampaignAttributesDTOToCampaignAttributesConverter(int level) {
        this.level = level;
    }

    public CampaignAttributesDTOToCampaignAttributesConverter() {
        this.level = 0;
    }

    @Override
    protected CampaignAttributes convert(CampaignAttributesDTO source) {
        CampaignAttributes.CampaignAttributesBuilder builder = CampaignAttributes.builder()
                .booleanValue(source.getBooleanValue())
                .dateValue(source.getDateValue())
                .floatValue(source.getFloatValue())
                .longValue(source.getLongValue())
                .id(source.getId())
                .stringValue(source.getStringValue())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());

        if (this.level == 0) {
            builder
                    .attribute(new AttributeDTOToAttributeConverter().convert(source.getAttribute()))
                    .campaign(new CampaignDTOToCampaignConverter().convert(source.getCampaign()));
        }

        return builder.build();
    }
}
