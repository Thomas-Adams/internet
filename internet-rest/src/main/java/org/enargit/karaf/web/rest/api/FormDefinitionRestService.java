package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.FormDefinitionDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.FormDefinitionDao;

import java.util.List;

public interface FormDefinitionRestService {

    public static String PATH_PREFIX = "/formDefinition";

    void bind(FormDefinitionDao dao);

    FormDefinitionDao getDao();

    Long convert(String id);

    List<FormDefinitionDTO> getAll();

    Page<FormDefinitionDTO> getPage(int page, int size);

    FormDefinitionDTO getById(String id);

    FormDefinitionDTO update(String id, FormDefinitionDTO entity);

    FormDefinitionDTO create(FormDefinitionDTO entity);

    FormDefinitionDTO deleteById(String id);
}
