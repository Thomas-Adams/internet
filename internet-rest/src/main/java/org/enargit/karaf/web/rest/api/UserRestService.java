package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.UserDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.UserDao;

import java.util.List;

public interface UserRestService {

    public static String PATH_PREFIX = "/user";

    void bind(UserDao dao);

    UserDao getDao();

    Long convert(String id);

    List<UserDTO> getAll();

    Page<UserDTO> getPage(int page, int size);

    UserDTO getById(String id);

    UserDTO update(String id, UserDTO entity);

    UserDTO create(UserDTO entity);

    UserDTO deleteById(String id);
}
