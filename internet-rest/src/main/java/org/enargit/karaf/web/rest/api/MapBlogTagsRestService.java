package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.MapBlogTagsDto;
import org.enargit.karaf.core.entities.MapBlogTags;
import org.enargit.karaf.core.entities.querydsl.QMapBlogTags;
import org.enargit.karaf.data.api.MapBlogTagsDao;
import org.enargit.karaf.mapper.api.MapBlogTagsMapper;

import java.util.List;

public interface MapBlogTagsRestService extends BasicRestService<MapBlogTags, MapBlogTagsDto,MapBlogTagsMapper, MapBlogTagsDao, QMapBlogTags, Long> {

    static String PATH_PREFIX = "/map-blog-tags";

    List<MapBlogTagsDto> getAll();

    MapBlogTagsDto getById( String id);

    MapBlogTagsDto update( String id, MapBlogTagsDto entity);

    MapBlogTagsDto create(MapBlogTagsDto entity);

    MapBlogTagsDto deleteById(String id);
}
