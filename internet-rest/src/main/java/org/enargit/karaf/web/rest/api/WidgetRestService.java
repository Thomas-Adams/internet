package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.WidgetDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.WidgetDao;

import java.util.List;

public interface WidgetRestService {

    public static String PATH_PREFIX = "/widget";

    void bind(WidgetDao dao);

    WidgetDao getDao();

    Long convert(String id);

    List<WidgetDTO> getAll();

    Page<WidgetDTO> getPage(int page, int size);

    WidgetDTO getById(String id);

    WidgetDTO update(String id, WidgetDTO entity);

    WidgetDTO create(WidgetDTO entity);

    WidgetDTO deleteById(String id);
}
