package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.WidgetPropertiesDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.data.api.WidgetPropertiesDao;
import org.enargit.karaf.web.rest.api.WidgetPropertiesRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = WidgetPropertiesRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
, JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class WidgetPropertiesRestServiceImpl implements WidgetPropertiesRestService {

    volatile WidgetPropertiesDao dao;


    @Reference(service = WidgetPropertiesDao.class, bind = "setDao")
    public void setDao(WidgetPropertiesDao dao) {
        this.dao = dao;
    }

    public WidgetPropertiesDao getDao() {
        return dao;
    }


    @Override
    public void bind(WidgetPropertiesDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(WidgetPropertiesRestService.PATH_PREFIX + "" )
    @Override
    public List<WidgetPropertiesDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(WidgetPropertiesRestService.PATH_PREFIX + "/{id}" )
    @Override
    public WidgetPropertiesDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(WidgetPropertiesRestService.PATH_PREFIX + "/{id}" )
    @Override
    public WidgetPropertiesDTO update(@PathParam("id") String id, WidgetPropertiesDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(WidgetPropertiesRestService.PATH_PREFIX )
    @Override
    public WidgetPropertiesDTO create(WidgetPropertiesDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path(WidgetPropertiesRestService.PATH_PREFIX + "/{id}" )
    @Override
    public WidgetPropertiesDTO deleteById(@PathParam("id") String id) {
        WidgetPropertiesDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(WidgetPropertiesRestService.PATH_PREFIX + "")
    @Override
    public Page<WidgetPropertiesDTO> getPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return dao.findAllDto(PageRequest.of(page, size));
    }
}
