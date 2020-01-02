package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.ProfileAttributesDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.ProfileAttributesDao;

import java.util.List;

public interface ProfileAttributesRestService {

    public static String PATH_PREFIX = "/profileAttributes";

    void bind(ProfileAttributesDao dao);

    ProfileAttributesDao getDao();

    Long convert(String id);

    List<ProfileAttributesDTO> getAll();

    Page<ProfileAttributesDTO> getPage(int page, int size);

    ProfileAttributesDTO getById(String id);

    ProfileAttributesDTO update(String id, ProfileAttributesDTO entity);

    ProfileAttributesDTO create(ProfileAttributesDTO entity);

    ProfileAttributesDTO deleteById(String id);
}
