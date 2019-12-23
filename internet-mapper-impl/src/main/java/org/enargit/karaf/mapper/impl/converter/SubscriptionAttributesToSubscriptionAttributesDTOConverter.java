package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.SubscriptionAttributesDTO;
import org.enargit.karaf.core.entities.SubscriptionAttributes;
import org.modelmapper.AbstractConverter;

public class SubscriptionAttributesToSubscriptionAttributesDTOConverter extends AbstractConverter<SubscriptionAttributes, SubscriptionAttributesDTO> {

    private int level;

    public SubscriptionAttributesToSubscriptionAttributesDTOConverter(int level) {
        this.level = level;
    }

    public SubscriptionAttributesToSubscriptionAttributesDTOConverter() {
        this.level = 0;
    }

    @Override
    protected SubscriptionAttributesDTO convert(SubscriptionAttributes source) {
        SubscriptionAttributesDTO.SubscriptionAttributesDTOBuilder builder = SubscriptionAttributesDTO.builder()
                .booleanValue(source.getBooleanValue())
                .dateValue(source.getDateValue())
                .floatValue(source.getFloatValue())
                .longValue(source.getLongValue())
                .stringValue(source.getStringValue())
                .subscription(null)
                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());
        if (this.level == 0) {
            builder.attribute(new AttributeToAttributeDTOConverter(this.level+1).convert(source.getAttribute()));
        }
        return builder.build();
    }
}
