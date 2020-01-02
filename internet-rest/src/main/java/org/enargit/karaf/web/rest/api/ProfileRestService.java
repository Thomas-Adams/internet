package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.ProfileDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.ProfileDao;

import java.util.List;

public interface ProfileRestService {

    public static String PATH_PREFIX = "/profile";

    void bind(ProfileDao dao);

    ProfileDao getDao();

    Long convert(String id);

    List<ProfileDTO> getAll();

    Page<ProfileDTO> getPage(int page, int size);

    ProfileDTO getById(String id);

    ProfileDTO update(String id, ProfileDTO entity);

    ProfileDTO create(ProfileDTO entity);

    ProfileDTO deleteById(String id);
}
