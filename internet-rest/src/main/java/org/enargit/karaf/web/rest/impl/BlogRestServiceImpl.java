package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.BlogDTO;
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


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(BlogRestService.PATH_PREFIX + "" )
    @Override
    public List<BlogDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(BlogRestService.PATH_PREFIX + "/{id}" )
    @Override
    public BlogDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(BlogRestService.PATH_PREFIX + "/{id}" )
    @Override
    public BlogDTO update(@PathParam("id") String id, BlogDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(BlogRestService.PATH_PREFIX )
    @Override
    public BlogDTO create(BlogDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path(BlogRestService.PATH_PREFIX + "/{id}" )
    @Override
    public BlogDTO deleteById(@PathParam("id") String id) {
        BlogDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }
}
