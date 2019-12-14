package org.enargit.karaf.data.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.data.dao.api.MapBlogTagsDao;
import org.enargit.karaf.data.dto.MapBlogTagsDto;
import org.enargit.karaf.data.entities.MapBlogTags;
import org.enargit.karaf.data.entities.querydsl.QMapBlogTags;
import org.enargit.karaf.data.mapper.api.MapBlogTagsMapper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Slf4j
@Component(service = MapBlogTagsDao.class, immediate = true,name = "MapBlogTagsDao")
public class MapBlogTagsDaoImpl extends BasicDaoImpl<MapBlogTags, MapBlogTagsDto, Long, QMapBlogTags, MapBlogTagsMapper>  implements MapBlogTagsDao {


    private JpaTemplate jpaTemplate;

    private MapBlogTagsMapper mapper;

    @Override
    public JpaTemplate getJpaTemplate() {
        return jpaTemplate;
    }

    @Override
    @Reference(service = JpaTemplate.class, target = "(osgi.unit.name=internetm_data)")
    public void setJpaTemplate(JpaTemplate jpaTemplate) {
        this.jpaTemplate = jpaTemplate;
    }

    @Override
    public MapBlogTagsMapper getMapper() {
        return this.mapper;
    }

    @Override
    @Reference(service = MapBlogTagsMapper.class,target = "(component.name=MapBlogTagsMapper)")
    public void setMapper(MapBlogTagsMapper mapper) {
        this.mapper = mapper;
    }

    public MapBlogTagsDaoImpl() {
        this.entityClass = MapBlogTags.class;
        this.entityPathBase = QMapBlogTags.mapBlogTags;
        this.idClass = Long.class;
    }
}
