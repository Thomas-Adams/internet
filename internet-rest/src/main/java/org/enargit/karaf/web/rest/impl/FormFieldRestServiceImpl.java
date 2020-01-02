package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.FormFieldDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.data.api.FormFieldDao;
import org.enargit.karaf.web.rest.api.FormFieldRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = FormFieldRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
, JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class FormFieldRestServiceImpl implements FormFieldRestService {

    volatile FormFieldDao dao;


    @Reference(service = FormFieldDao.class, bind = "setDao")
    public void setDao(FormFieldDao dao) {
        this.dao = dao;
    }

    public FormFieldDao getDao() {
        return dao;
    }


    @Override
    public void bind(FormFieldDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(FormFieldRestService.PATH_PREFIX + "/{" )
    @Override
    public List<FormFieldDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(FormFieldRestService.PATH_PREFIX + "/{id}" )
    @Override
    public FormFieldDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(FormFieldRestService.PATH_PREFIX + "/{id}" )
    @Override
    public FormFieldDTO update(@PathParam("id") String id, FormFieldDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(FormFieldRestService.PATH_PREFIX )
    @Override
    public FormFieldDTO create(FormFieldDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path(FormFieldRestService.PATH_PREFIX + "/{id}" )
    @Override
    public FormFieldDTO deleteById(@PathParam("id") String id) {
        FormFieldDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(FormFieldRestService.PATH_PREFIX + "")
    @Override
    public Page<FormFieldDTO> getPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return dao.findAllDto(PageRequest.of(page, size));
    }
}
