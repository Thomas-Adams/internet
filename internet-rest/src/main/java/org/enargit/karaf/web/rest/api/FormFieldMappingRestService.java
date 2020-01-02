package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.FormFieldMappingDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.FormFieldMappingDao;

import java.util.List;

public interface FormFieldMappingRestService {

    public static String PATH_PREFIX = "/formFieldMapping";

    void bind(FormFieldMappingDao dao);

    FormFieldMappingDao getDao();

    Long convert(String id);

    List<FormFieldMappingDTO> getAll();

    Page<FormFieldMappingDTO> getPage(int page, int size);

    FormFieldMappingDTO getById(String id);

    FormFieldMappingDTO update(String id, FormFieldMappingDTO entity);

    FormFieldMappingDTO create(FormFieldMappingDTO entity);

    FormFieldMappingDTO deleteById(String id);
}
