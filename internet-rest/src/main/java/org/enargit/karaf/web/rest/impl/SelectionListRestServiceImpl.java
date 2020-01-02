package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.SelectionListDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.data.api.SelectionListDao;
import org.enargit.karaf.web.rest.api.SelectionListRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = SelectionListRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
, JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class SelectionListRestServiceImpl implements SelectionListRestService {

    volatile SelectionListDao dao;


    @Reference(service = SelectionListDao.class, bind = "setDao")
    public void setDao(SelectionListDao dao) {
        this.dao = dao;
    }

    public SelectionListDao getDao() {
        return dao;
    }


    @Override
    public void bind(SelectionListDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }



    @Override
    public List<SelectionListDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(SelectionListRestService.PATH_PREFIX + "/{id}" )
    @Override
    public SelectionListDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(SelectionListRestService.PATH_PREFIX + "/{id}" )
    @Override
    public SelectionListDTO update(@PathParam("id") String id, SelectionListDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(SelectionListRestService.PATH_PREFIX )
    @Override
    public SelectionListDTO create(SelectionListDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path(SelectionListRestService.PATH_PREFIX + "/{id}" )
    @Override
    public SelectionListDTO deleteById(@PathParam("id") String id) {
        SelectionListDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(SelectionListRestService.PATH_PREFIX + "")
    @Override
    public Page<SelectionListDTO> getPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return dao.findAllDto(PageRequest.of(page, size));
    }
}
