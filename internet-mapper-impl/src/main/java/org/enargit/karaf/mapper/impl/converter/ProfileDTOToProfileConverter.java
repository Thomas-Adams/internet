package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.ProfileDTO;
import org.enargit.karaf.core.entities.Profile;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class ProfileDTOToProfileConverter extends AbstractConverter<ProfileDTO, Profile > {

    private int level;

    public ProfileDTOToProfileConverter(int level) {
        this.level = level;
    }

    public ProfileDTOToProfileConverter() {
        this.level = 0;
    }

    @Override
    protected Profile convert(ProfileDTO source) {
        Profile.ProfileBuilder builder = Profile.builder()
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
            builder.user(new UserDTOToUserConverter(this.level + 1).convert(source.getUser()));
        }
        return builder.build();

    }
}
