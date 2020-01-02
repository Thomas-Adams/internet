package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.UserRoleDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.UserRoleDao;

import java.util.List;

public interface UserRoleRestService {

    public static String PATH_PREFIX = "/userRole";

    void bind(UserRoleDao dao);

    UserRoleDao getDao();

    Long convert(String id);

    List<UserRoleDTO> getAll();

    Page<UserRoleDTO> getPage(int page, int size);

    UserRoleDTO getById(String id);

    UserRoleDTO update(String id, UserRoleDTO entity);

    UserRoleDTO create(UserRoleDTO entity);

    UserRoleDTO deleteById(String id);
}
