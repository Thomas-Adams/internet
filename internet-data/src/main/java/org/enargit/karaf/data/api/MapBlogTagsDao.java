package org.enargit.karaf.data.api;


import org.enargit.karaf.core.dto.MapBlogTagsDto;
import org.enargit.karaf.core.entities.MapBlogTags;
import org.enargit.karaf.core.entities.querydsl.QMapBlogTags;
import org.enargit.karaf.mapper.api.MapBlogTagsMapper;

public interface MapBlogTagsDao extends BasicDao<MapBlogTags, MapBlogTagsDto, Long, QMapBlogTags, MapBlogTagsMapper> {

    MapBlogTagsMapper getMapper();

    void setMapper(MapBlogTagsMapper mapper);
}
