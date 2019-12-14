package org.enargit.karaf.data.dao.api;

import org.enargit.karaf.data.dto.BlogDto;
import org.enargit.karaf.data.entities.Blog;
import org.enargit.karaf.data.entities.querydsl.QBlog;
import org.enargit.karaf.data.mapper.api.BlogMapper;

public interface BlogDao extends BasicDao<Blog, BlogDto, Long, QBlog, BlogMapper> {

    BlogMapper getMapper();

    void setMapper(BlogMapper mapper);
}
