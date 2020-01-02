package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.ValidationRuleDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.ValidationRuleDao;

import java.util.List;

public interface ValidationRuleRestService {

    public static String PATH_PREFIX = "/validationRule";

    void bind(ValidationRuleDao dao);

    ValidationRuleDao getDao();

    Long convert(String id);

    List<ValidationRuleDTO> getAll();

    Page<ValidationRuleDTO> getPage(int page, int size);

    ValidationRuleDTO getById(String id);

    ValidationRuleDTO update(String id, ValidationRuleDTO entity);

    ValidationRuleDTO create(ValidationRuleDTO entity);

    ValidationRuleDTO deleteById(String id);
}
