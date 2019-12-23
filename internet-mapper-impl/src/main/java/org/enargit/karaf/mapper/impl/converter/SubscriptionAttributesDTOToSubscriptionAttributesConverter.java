package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.SubscriptionAttributesDTO;
import org.enargit.karaf.core.entities.SubscriptionAttributes;
import org.modelmapper.AbstractConverter;

public class SubscriptionAttributesDTOToSubscriptionAttributesConverter extends AbstractConverter<SubscriptionAttributesDTO,SubscriptionAttributes> {

    private int level;

    public SubscriptionAttributesDTOToSubscriptionAttributesConverter(int level) {
        this.level = level;
    }

    public SubscriptionAttributesDTOToSubscriptionAttributesConverter() {
        this.level = 0;
    }

    @Override
    protected SubscriptionAttributes convert(SubscriptionAttributesDTO source) {
        SubscriptionAttributes.SubscriptionAttributesBuilder builder = SubscriptionAttributes.builder()
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
            builder.attribute(new AttributeDTOToAttributeConverter(this.level+1).convert(source.getAttribute()));
        }
        return builder.build();
    }
}
