package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.MapBlogTagsDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.MapBlogTagsDao;

import java.util.List;

public interface MapBlogTagsRestService {

    public static String PATH_PREFIX = "/mapBlogTags";

    void bind(MapBlogTagsDao dao);

    MapBlogTagsDao getDao();

    Long convert(String id);

    List<MapBlogTagsDTO> getAll();

    Page<MapBlogTagsDTO> getPage(int page, int size);

    MapBlogTagsDTO getById(String id);

    MapBlogTagsDTO update(String id, MapBlogTagsDTO entity);

    MapBlogTagsDTO create(MapBlogTagsDTO entity);

    MapBlogTagsDTO deleteById(String id);
}
