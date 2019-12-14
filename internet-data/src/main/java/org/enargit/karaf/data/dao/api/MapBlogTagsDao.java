package org.enargit.karaf.data.dao.api;

import org.enargit.karaf.data.dto.MapBlogTagsDto;
import org.enargit.karaf.data.entities.MapBlogTags;
import org.enargit.karaf.data.entities.querydsl.QMapBlogTags;
import org.enargit.karaf.data.mapper.api.MapBlogTagsMapper;

public interface MapBlogTagsDao extends BasicDao<MapBlogTags, MapBlogTagsDto, Long, QMapBlogTags, MapBlogTagsMapper> {

    MapBlogTagsMapper getMapper();

    void setMapper(MapBlogTagsMapper mapper);
}
