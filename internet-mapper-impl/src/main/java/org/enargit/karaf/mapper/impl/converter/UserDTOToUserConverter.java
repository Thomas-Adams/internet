package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.UserDTO;
import org.enargit.karaf.core.entities.User;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class UserDTOToUserConverter extends AbstractConverter<UserDTO,User> {
    private int level;

    public UserDTOToUserConverter() {
        this.level = 0;
    }

    public UserDTOToUserConverter(int level) {
        this.level = level;
    }

    @Override
    protected User convert(UserDTO source) {
        User.UserBuilder builder = User.builder()
                .accessToken(source.getAccessToken())
                .email(source.getEmail())
                .enabled(source.isEnabled())
                .expired(source.isExpired())
                .lastChangeCredentials(source.getLastChangeCredentials())
                .locked(source.isLocked())
                .mobile(source.getMobile())
                .refreshToken(source.getRefreshToken())
                .username(source.getUsername())
                .userRoles(new ArrayList<>())
                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());
        if (this.level == 0) {
            builder.profile(new ProfileDTOToProfileConverter(this.level+1).convert(source.getProfile()));
        }
        return builder.build();

    }
}
