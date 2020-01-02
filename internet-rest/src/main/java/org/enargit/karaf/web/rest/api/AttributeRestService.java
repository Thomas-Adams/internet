package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.AttributeDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.AttributeDao;

import java.util.List;

public interface AttributeRestService {

    public static String PATH_PREFIX = "/attribute";

    void bind(AttributeDao dao);

    AttributeDao getDao();

    Long convert(String id);

    List<AttributeDTO> getAll();

    Page<AttributeDTO> getPage(int page, int size);

    AttributeDTO getById(String id);

    AttributeDTO update(String id, AttributeDTO entity);

    AttributeDTO create(AttributeDTO entity);

    AttributeDTO deleteById(String id);
}
