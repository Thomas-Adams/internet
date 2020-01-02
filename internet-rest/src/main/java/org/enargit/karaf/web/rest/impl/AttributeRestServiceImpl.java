package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.AttributeDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.data.api.AttributeDao;
import org.enargit.karaf.web.rest.api.AttributeRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = AttributeRestService.class, immediate = true, property = {JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
        , JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true"})
public class AttributeRestServiceImpl implements AttributeRestService {

    volatile AttributeDao dao;


    @Reference(service = AttributeDao.class, bind = "setDao")
    public void setDao(AttributeDao dao) {
        this.dao = dao;
    }

    public AttributeDao getDao() {
        return dao;
    }


    @Override
    public void bind(AttributeDao dao) {
        this.dao = dao;
    }


    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(AttributeRestService.PATH_PREFIX + "")
    @Override
    public List<AttributeDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(AttributeRestService.PATH_PREFIX + "/{id}")
    @Override
    public AttributeDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(AttributeRestService.PATH_PREFIX + "/{id}")
    @Override
    public AttributeDTO update(@PathParam("id") String id, AttributeDTO dto) {
        return dao.save(dto);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(AttributeRestService.PATH_PREFIX)
    @Override
    public AttributeDTO create(AttributeDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path(AttributeRestService.PATH_PREFIX + "/{id}")
    @Override
    public AttributeDTO deleteById(@PathParam("id") String id) {
        AttributeDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }

    @Produces({MediaType.APPLICATION_JSON})
    @Path(AttributeRestService.PATH_PREFIX)
    @Override
    public Page<AttributeDTO> getPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return dao.findAllDto(PageRequest.of(page, size));
    }
}
