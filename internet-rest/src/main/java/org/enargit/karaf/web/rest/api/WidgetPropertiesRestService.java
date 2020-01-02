package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.WidgetPropertiesDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.WidgetPropertiesDao;

import java.util.List;

public interface WidgetPropertiesRestService {

    public static String PATH_PREFIX = "/widgetProperties";

    void bind(WidgetPropertiesDao dao);

    WidgetPropertiesDao getDao();

    Long convert(String id);

    List<WidgetPropertiesDTO> getAll();

    Page<WidgetPropertiesDTO> getPage(int page, int size);

    WidgetPropertiesDTO getById(String id);

    WidgetPropertiesDTO update(String id, WidgetPropertiesDTO entity);

    WidgetPropertiesDTO create(WidgetPropertiesDTO entity);

    WidgetPropertiesDTO deleteById(String id);
}
