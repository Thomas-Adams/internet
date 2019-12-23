package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.ProfileAttributesDTO;
import org.enargit.karaf.core.entities.ProfileAttributes;
import org.modelmapper.AbstractConverter;

public class ProfileAttributesDTOToProfileAttributesConverter extends AbstractConverter<ProfileAttributesDTO,ProfileAttributes> {

    private int level;

    public ProfileAttributesDTOToProfileAttributesConverter(int level) {
        this.level = level;
    }

    public ProfileAttributesDTOToProfileAttributesConverter() {
        this.level = 0;
    }

    @Override
    protected ProfileAttributes convert(ProfileAttributesDTO source) {
        ProfileAttributes.ProfileAttributesBuilder builder = ProfileAttributes.builder()
                .booleanValue(source.getBooleanValue())
                .dateValue(source.getDateValue())
                .floatValue(source.getFloatValue())
                .longValue(source.getLongValue())
                .stringValue(source.getStringValue())
                .profile(null)
                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());
        if (this.level == 0) {
            builder.attribute(new AttributeDTOToAttributeConverter(this.level + 1).convert(source.getAttribute()));
        }
        return builder.build();
    }
}
