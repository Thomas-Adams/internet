package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.BlogDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.BlogDao;

import java.util.List;

public interface BlogRestService {

    public static String PATH_PREFIX = "/blog";

    void bind(BlogDao dao);

    BlogDao getDao();

    Long convert(String id);

    List<BlogDTO> getAll();

    Page<BlogDTO> getPage(int page, int size);

    BlogDTO getById(String id);

    BlogDTO update(String id, BlogDTO entity);

    BlogDTO create(BlogDTO entity);

    BlogDTO deleteById(String id);
}
