package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.FormFieldDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.FormFieldDao;

import java.util.List;

public interface FormFieldRestService {

    public static String PATH_PREFIX = "/formField";

    void bind(FormFieldDao dao);

    FormFieldDao getDao();

    Long convert(String id);

    List<FormFieldDTO> getAll();

    Page<FormFieldDTO> getPage(int page, int size);

    FormFieldDTO getById(String id);

    FormFieldDTO update(String id, FormFieldDTO entity);

    FormFieldDTO create(FormFieldDTO entity);

    FormFieldDTO deleteById(String id);
}
