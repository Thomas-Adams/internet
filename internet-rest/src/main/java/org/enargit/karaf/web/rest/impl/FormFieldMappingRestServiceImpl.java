package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.FormFieldMappingDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.data.api.FormFieldMappingDao;
import org.enargit.karaf.web.rest.api.FormFieldMappingRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = FormFieldMappingRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
, JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class FormFieldMappingRestServiceImpl implements FormFieldMappingRestService {

    volatile FormFieldMappingDao dao;


    @Reference(service = FormFieldMappingDao.class, bind = "setDao")
    public void setDao(FormFieldMappingDao dao) {
        this.dao = dao;
    }

    public FormFieldMappingDao getDao() {
        return dao;
    }


    @Override
    public void bind(FormFieldMappingDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(FormFieldMappingRestService.PATH_PREFIX + "" )
    @Override
    public List<FormFieldMappingDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(FormFieldMappingRestService.PATH_PREFIX + "/{id}" )
    @Override
    public FormFieldMappingDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(FormFieldMappingRestService.PATH_PREFIX + "/{id}" )
    @Override
    public FormFieldMappingDTO update(@PathParam("id") String id, FormFieldMappingDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(FormFieldMappingRestService.PATH_PREFIX )
    @Override
    public FormFieldMappingDTO create(FormFieldMappingDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path(FormFieldMappingRestService.PATH_PREFIX + "/{id}" )
    @Override
    public FormFieldMappingDTO deleteById(@PathParam("id") String id) {
        FormFieldMappingDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(FormFieldMappingRestService.PATH_PREFIX + "")
    @Override
    public Page<FormFieldMappingDTO> getPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return dao.findAllDto(PageRequest.of(page, size));
    }
}
