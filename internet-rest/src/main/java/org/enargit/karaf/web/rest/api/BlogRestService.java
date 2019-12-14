package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.BlogDto;
import org.enargit.karaf.core.entities.Blog;
import org.enargit.karaf.core.entities.querydsl.QBlog;
import org.enargit.karaf.data.api.BlogDao;
import org.enargit.karaf.mapper.api.BlogMapper;

import java.util.List;

public interface BlogRestService extends BasicRestService<Blog, BlogDto, BlogMapper, BlogDao, QBlog, Long> {

    public static String PATH_PREFIX = "/blogs";



    List<BlogDto> getAll();


    BlogDto getById(String id);



    BlogDto update(String id, BlogDto entity);


    BlogDto create(BlogDto entity);


    BlogDto deleteById(String id);
}
