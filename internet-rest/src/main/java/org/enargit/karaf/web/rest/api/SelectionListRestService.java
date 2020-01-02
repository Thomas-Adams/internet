package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.SelectionListDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.SelectionListDao;

import java.util.List;

public interface SelectionListRestService {

    public static String PATH_PREFIX = "/selectionList";

    void bind(SelectionListDao dao);

    SelectionListDao getDao();

    Long convert(String id);

    List<SelectionListDTO> getAll();

    Page<SelectionListDTO> getPage(int page, int size);

    SelectionListDTO getById(String id);

    SelectionListDTO update(String id, SelectionListDTO entity);

    SelectionListDTO create(SelectionListDTO entity);

    SelectionListDTO deleteById(String id);
}
