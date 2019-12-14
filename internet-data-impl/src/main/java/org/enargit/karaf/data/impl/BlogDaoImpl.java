package org.enargit.karaf.data.impl;


import lombok.extern.slf4j.Slf4j;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.BlogDto;
import org.enargit.karaf.core.entities.Blog;
import org.enargit.karaf.core.entities.querydsl.QBlog;
import org.enargit.karaf.data.api.BlogDao;
import org.enargit.karaf.mapper.api.BlogMapper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Slf4j
@Component(service = BlogDao.class, immediate = true, name = "BlogDao")
public class BlogDaoImpl extends BasicDaoImpl<Blog, BlogDto, Long, QBlog, BlogMapper> implements BlogDao {


    private JpaTemplate jpaTemplate;

    private BlogMapper mapper;

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
    public BlogMapper getMapper() {
        return this.mapper;
    }

    @Override
    @Reference(service = BlogMapper.class, target = "(component.name=BlogMapper)")
    public void setMapper(BlogMapper mapper) {
        this.mapper = mapper;
    }

    public BlogDaoImpl() {
        this.entityClass = Blog.class;
        this.entityPathBase = QBlog.blog;
        this.idClass = Long.class;
    }
}
