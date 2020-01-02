package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.RoleDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.RoleDao;

import java.util.List;

public interface RoleRestService {

    public static String PATH_PREFIX = "/role";

    void bind(RoleDao dao);

    RoleDao getDao();

    Long convert(String id);

    List<RoleDTO> getAll();

    Page<RoleDTO> getPage(int page, int size);

    RoleDTO getById(String id);

    RoleDTO update(String id, RoleDTO entity);

    RoleDTO create(RoleDTO entity);

    RoleDTO deleteById(String id);
}
