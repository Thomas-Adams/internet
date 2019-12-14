package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.BlogDto;
import org.enargit.karaf.data.api.BlogDao;
import org.enargit.karaf.web.rest.api.BlogRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = BlogRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
        , JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class BlogRestServiceImpl implements BlogRestService {

    volatile BlogDao dao;


    @Reference(service = BlogDao.class, bind = "setDao")
    public void setDao(BlogDao dao) {
        this.dao = dao;
    }

    public BlogDao getDao() {
        return dao;
    }


    @Override
    public void bind(BlogDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }



    @Override
    public List<BlogDto> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(BlogRestService.PATH_PREFIX + "/{id}" )
    @Override
    public BlogDto getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(BlogRestService.PATH_PREFIX + "/{id}" )
    @Override
    public BlogDto update(@PathParam("id") String id, BlogDto dto) {
        return dao.save( dto);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(BlogRestService.PATH_PREFIX )
    @Override
    public BlogDto create(BlogDto dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path(BlogRestService.PATH_PREFIX + "/{id}" )
    @Override
    public BlogDto deleteById(@PathParam("id") String id) {
        BlogDto dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }
}
