package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.CategoryDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.CategoryDao;

import java.util.List;

public interface CategoryRestService {

    public static String PATH_PREFIX = "/category";

    void bind(CategoryDao dao);

    CategoryDao getDao();

    Long convert(String id);

    List<CategoryDTO> getAll();

    Page<CategoryDTO> getPage(int page, int size);

    CategoryDTO getById(String id);

    CategoryDTO update(String id, CategoryDTO entity);

    CategoryDTO create(CategoryDTO entity);

    CategoryDTO deleteById(String id);
}
