package org.enargit.karaf.data.api;


import org.enargit.karaf.core.dto.BlogDto;
import org.enargit.karaf.core.entities.Blog;
import org.enargit.karaf.core.entities.querydsl.QBlog;
import org.enargit.karaf.mapper.api.BlogMapper;

public interface BlogDao extends BasicDao<Blog, BlogDto, Long, QBlog, BlogMapper> {

    BlogMapper getMapper();

    void setMapper(BlogMapper mapper);
}
