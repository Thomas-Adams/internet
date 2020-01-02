package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.SubscriptionAttributesDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.data.api.SubscriptionAttributesDao;
import org.enargit.karaf.web.rest.api.SubscriptionAttributesRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = SubscriptionAttributesRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
, JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class SubscriptionAttributesRestServiceImpl implements SubscriptionAttributesRestService {

    volatile SubscriptionAttributesDao dao;


    @Reference(service = SubscriptionAttributesDao.class, bind = "setDao")
    public void setDao(SubscriptionAttributesDao dao) {
        this.dao = dao;
    }

    public SubscriptionAttributesDao getDao() {
        return dao;
    }


    @Override
    public void bind(SubscriptionAttributesDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(SubscriptionAttributesRestService.PATH_PREFIX + "" )
    @Override
    public List<SubscriptionAttributesDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(SubscriptionAttributesRestService.PATH_PREFIX + "/{id}" )
    @Override
    public SubscriptionAttributesDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(SubscriptionAttributesRestService.PATH_PREFIX + "/{id}" )
    @Override
    public SubscriptionAttributesDTO update(@PathParam("id") String id, SubscriptionAttributesDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(SubscriptionAttributesRestService.PATH_PREFIX )
    @Override
    public SubscriptionAttributesDTO create(SubscriptionAttributesDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path(SubscriptionAttributesRestService.PATH_PREFIX + "/{id}" )
    @Override
    public SubscriptionAttributesDTO deleteById(@PathParam("id") String id) {
        SubscriptionAttributesDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(SubscriptionAttributesRestService.PATH_PREFIX + "")
    @Override
    public Page<SubscriptionAttributesDTO> getPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return dao.findAllDto(PageRequest.of(page, size));
    }
}
