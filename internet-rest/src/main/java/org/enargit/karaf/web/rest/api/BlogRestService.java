package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.data.dao.api.BlogDao;
import org.enargit.karaf.data.dto.BlogDto;
import org.enargit.karaf.data.entities.Blog;
import org.enargit.karaf.data.entities.querydsl.QBlog;

import java.util.List;

public interface BlogRestService extends BasicRestService<Blog, BlogDto, BlogDao, QBlog, Long> {

    public static String PATH_PREFIX = "/blogs";



    List<BlogDto> getAll();


    BlogDto getById(String id);



    BlogDto update(String id, BlogDto entity);


    BlogDto create(BlogDto entity);


    BlogDto deleteById(String id);
}
