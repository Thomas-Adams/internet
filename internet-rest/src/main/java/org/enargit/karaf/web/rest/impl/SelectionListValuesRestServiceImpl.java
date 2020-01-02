package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.SelectionListValuesDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.data.api.SelectionListValuesDao;
import org.enargit.karaf.web.rest.api.SelectionListValuesRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = SelectionListValuesRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
, JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class SelectionListValuesRestServiceImpl implements SelectionListValuesRestService {

    volatile SelectionListValuesDao dao;


    @Reference(service = SelectionListValuesDao.class, bind = "setDao")
    public void setDao(SelectionListValuesDao dao) {
        this.dao = dao;
    }

    public SelectionListValuesDao getDao() {
        return dao;
    }


    @Override
    public void bind(SelectionListValuesDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(SelectionListValuesRestService.PATH_PREFIX + "" )
    @Override
    public List<SelectionListValuesDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(SelectionListValuesRestService.PATH_PREFIX + "/{id}" )
    @Override
    public SelectionListValuesDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(SelectionListValuesRestService.PATH_PREFIX + "/{id}" )
    @Override
    public SelectionListValuesDTO update(@PathParam("id") String id, SelectionListValuesDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(SelectionListValuesRestService.PATH_PREFIX )
    @Override
    public SelectionListValuesDTO create(SelectionListValuesDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path(SelectionListValuesRestService.PATH_PREFIX + "/{id}" )
    @Override
    public SelectionListValuesDTO deleteById(@PathParam("id") String id) {
        SelectionListValuesDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(SelectionListValuesRestService.PATH_PREFIX + "")
    @Override
    public Page<SelectionListValuesDTO> getPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return dao.findAllDto(PageRequest.of(page, size));
    }
}
