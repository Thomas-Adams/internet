package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.CampaignAttributesDTO;
import org.enargit.karaf.core.entities.CampaignAttributes;
import org.modelmapper.AbstractConverter;

public class CampaignAttributesToCampaignAttributesDTOConverter extends AbstractConverter<CampaignAttributes, CampaignAttributesDTO> {

    private int level;

    public CampaignAttributesToCampaignAttributesDTOConverter(int level) {
        this.level = level;
    }

    public CampaignAttributesToCampaignAttributesDTOConverter() {
        this.level = 0;
    }

    @Override
    protected CampaignAttributesDTO convert(CampaignAttributes source) {
        CampaignAttributesDTO.CampaignAttributesDTOBuilder builder = CampaignAttributesDTO.builder()

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
                    .attribute(new AttributeToAttributeDTOConverter().convert(source.getAttribute()))
                    .campaign(new CampaignToCampaignDTOConverter().convert(source.getCampaign()));
        }

        return builder.build();
    }
}
