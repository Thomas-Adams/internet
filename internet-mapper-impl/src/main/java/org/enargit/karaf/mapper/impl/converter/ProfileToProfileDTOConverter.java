package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.ProfileDTO;
import org.enargit.karaf.core.entities.Profile;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class ProfileToProfileDTOConverter extends AbstractConverter<Profile, ProfileDTO> {

    private int level;

    public ProfileToProfileDTOConverter(int level) {
        this.level = level;
    }

    public ProfileToProfileDTOConverter() {
        this.level = 0;
    }

    @Override
    protected ProfileDTO convert(Profile source) {
        ProfileDTO.ProfileDTOBuilder builder = ProfileDTO.builder()
                .birthday(source.getBirthday())
                .attributes(new ArrayList<>())
                .givenName(source.getGivenName())
                .surName(source.getSurName())

                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());
        if (this.level == 0) {
            builder.user(new UserToUserDTOConverter(this.level + 1).convert(source.getUser()));
        }
        return builder.build();

    }
}
