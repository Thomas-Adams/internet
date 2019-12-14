package org.enargit.karaf.data.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.data.dao.api.TagDao;
import org.enargit.karaf.data.dto.TagDto;
import org.enargit.karaf.data.entities.Tag;
import org.enargit.karaf.data.entities.querydsl.QTag;
import org.enargit.karaf.data.mapper.api.TagMapper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Slf4j
@Component(service = TagDao.class, immediate = true, name = "TagDao")
public class TagDaoImpl extends BasicDaoImpl<Tag, TagDto, Long, QTag, TagMapper> implements TagDao {

    private JpaTemplate jpaTemplate;

    private TagMapper mapper;

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
    public TagMapper getMapper() {
        return this.mapper;
    }

    @Override
    @Reference(service = TagMapper.class, target = "(component.name=TagMapper)")
    public void setMapper(TagMapper mapper) {
        this.mapper = mapper;
    }

    public TagDaoImpl() {
        this.entityClass = Tag.class;
        this.entityPathBase = QTag.tag;
        this.idClass = Long.class;
    }
}
