package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.SubscriptionDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.data.api.SubscriptionDao;
import org.enargit.karaf.web.rest.api.SubscriptionRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = SubscriptionRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
, JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class SubscriptionRestServiceImpl implements SubscriptionRestService {

    volatile SubscriptionDao dao;


    @Reference(service = SubscriptionDao.class, bind = "setDao")
    public void setDao(SubscriptionDao dao) {
        this.dao = dao;
    }

    public SubscriptionDao getDao() {
        return dao;
    }


    @Override
    public void bind(SubscriptionDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }



    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(SubscriptionRestService.PATH_PREFIX + "" )
    @Override
    public List<SubscriptionDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(SubscriptionRestService.PATH_PREFIX + "/{id}" )
    @Override
    public SubscriptionDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(SubscriptionRestService.PATH_PREFIX + "/{id}" )
    @Override
    public SubscriptionDTO update(@PathParam("id") String id, SubscriptionDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(SubscriptionRestService.PATH_PREFIX )
    @Override
    public SubscriptionDTO create(SubscriptionDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path(SubscriptionRestService.PATH_PREFIX + "/{id}" )
    @Override
    public SubscriptionDTO deleteById(@PathParam("id") String id) {
        SubscriptionDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(SubscriptionRestService.PATH_PREFIX + "")
    @Override
    public Page<SubscriptionDTO> getPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return dao.findAllDto(PageRequest.of(page, size));
    }
}
