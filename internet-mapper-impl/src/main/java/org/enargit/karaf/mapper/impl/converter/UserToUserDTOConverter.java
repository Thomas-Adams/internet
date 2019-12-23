package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.UserDTO;
import org.enargit.karaf.core.entities.User;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class UserToUserDTOConverter extends AbstractConverter<User, UserDTO> {
    private int level;

    public UserToUserDTOConverter() {
        this.level = 0;
    }

    public UserToUserDTOConverter(int level) {
        this.level = level;
    }

    @Override
    protected UserDTO convert(User source) {
        UserDTO.UserDTOBuilder builder = UserDTO.builder()
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
            builder.profile(new ProfileToProfileDTOConverter(this.level+1).convert(source.getProfile()));
        }
        return builder.build();

    }
}
