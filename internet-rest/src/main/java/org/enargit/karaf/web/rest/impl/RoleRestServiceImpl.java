package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.RoleDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.data.api.RoleDao;
import org.enargit.karaf.web.rest.api.RoleRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = RoleRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
, JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class RoleRestServiceImpl implements RoleRestService {

    volatile RoleDao dao;


    @Reference(service = RoleDao.class, bind = "setDao")
    public void setDao(RoleDao dao) {
        this.dao = dao;
    }

    public RoleDao getDao() {
        return dao;
    }


    @Override
    public void bind(RoleDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(RoleRestService.PATH_PREFIX + "" )
    @Override
    public List<RoleDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(RoleRestService.PATH_PREFIX + "/{id}" )
    @Override
    public RoleDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(RoleRestService.PATH_PREFIX + "/{id}" )
    @Override
    public RoleDTO update(@PathParam("id") String id, RoleDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(RoleRestService.PATH_PREFIX )
    @Override
    public RoleDTO create(RoleDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path(RoleRestService.PATH_PREFIX + "/{id}" )
    @Override
    public RoleDTO deleteById(@PathParam("id") String id) {
        RoleDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(RoleRestService.PATH_PREFIX + "")
    @Override
    public Page<RoleDTO> getPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return dao.findAllDto(PageRequest.of(page, size));
    }
}
