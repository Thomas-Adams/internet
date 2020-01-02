package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.ValidationRuleDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.data.api.ValidationRuleDao;
import org.enargit.karaf.web.rest.api.ValidationRuleRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = ValidationRuleRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
, JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class ValidationRuleRestServiceImpl implements ValidationRuleRestService {

    volatile ValidationRuleDao dao;


    @Reference(service = ValidationRuleDao.class, bind = "setDao")
    public void setDao(ValidationRuleDao dao) {
        this.dao = dao;
    }

    public ValidationRuleDao getDao() {
        return dao;
    }


    @Override
    public void bind(ValidationRuleDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(ValidationRuleRestService.PATH_PREFIX + "" )
    @Override
    public List<ValidationRuleDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(ValidationRuleRestService.PATH_PREFIX + "/{id}" )
    @Override
    public ValidationRuleDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(ValidationRuleRestService.PATH_PREFIX + "/{id}" )
    @Override
    public ValidationRuleDTO update(@PathParam("id") String id, ValidationRuleDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(ValidationRuleRestService.PATH_PREFIX )
    @Override
    public ValidationRuleDTO create(ValidationRuleDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path(ValidationRuleRestService.PATH_PREFIX + "/{id}" )
    @Override
    public ValidationRuleDTO deleteById(@PathParam("id") String id) {
        ValidationRuleDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(ValidationRuleRestService.PATH_PREFIX + "")
    @Override
    public Page<ValidationRuleDTO> getPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return dao.findAllDto(PageRequest.of(page, size));
    }
}
