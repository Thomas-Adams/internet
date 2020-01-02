package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.SelectionListValuesDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.SelectionListValuesDao;

import java.util.List;

public interface SelectionListValuesRestService {

    public static String PATH_PREFIX = "/selectionListValues";

    void bind(SelectionListValuesDao dao);

    SelectionListValuesDao getDao();

    Long convert(String id);

    List<SelectionListValuesDTO> getAll();

    Page<SelectionListValuesDTO> getPage(int page, int size);

    SelectionListValuesDTO getById(String id);

    SelectionListValuesDTO update(String id, SelectionListValuesDTO entity);

    SelectionListValuesDTO create(SelectionListValuesDTO entity);

    SelectionListValuesDTO deleteById(String id);
}
