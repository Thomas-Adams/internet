package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.ProfileAttributesDTO;
import org.enargit.karaf.core.entities.ProfileAttributes;
import org.modelmapper.AbstractConverter;

public class ProfileAttributesToProfileAttributesDTOConverter extends AbstractConverter<ProfileAttributes, ProfileAttributesDTO> {

    private int level;

    public ProfileAttributesToProfileAttributesDTOConverter(int level) {
        this.level = level;
    }

    public ProfileAttributesToProfileAttributesDTOConverter() {
        this.level = 0;
    }

    @Override
    protected ProfileAttributesDTO convert(ProfileAttributes source) {
        ProfileAttributesDTO.ProfileAttributesDTOBuilder builder = ProfileAttributesDTO.builder()
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
            builder.attribute(new AttributeToAttributeDTOConverter(this.level + 1).convert(source.getAttribute()));
        }
        return builder.build();
    }
}
