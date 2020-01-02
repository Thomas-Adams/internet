package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.UserRoleDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.data.api.UserRoleDao;
import org.enargit.karaf.web.rest.api.UserRoleRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = UserRoleRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
, JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class UserRoleRestServiceImpl implements UserRoleRestService {

    volatile UserRoleDao dao;


    @Reference(service = UserRoleDao.class, bind = "setDao")
    public void setDao(UserRoleDao dao) {
        this.dao = dao;
    }

    public UserRoleDao getDao() {
        return dao;
    }


    @Override
    public void bind(UserRoleDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(UserRoleRestService.PATH_PREFIX + "" )
    @Override
    public List<UserRoleDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(UserRoleRestService.PATH_PREFIX + "/{id}" )
    @Override
    public UserRoleDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(UserRoleRestService.PATH_PREFIX + "/{id}" )
    @Override
    public UserRoleDTO update(@PathParam("id") String id, UserRoleDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(UserRoleRestService.PATH_PREFIX )
    @Override
    public UserRoleDTO create(UserRoleDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path(UserRoleRestService.PATH_PREFIX + "/{id}" )
    @Override
    public UserRoleDTO deleteById(@PathParam("id") String id) {
        UserRoleDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(UserRoleRestService.PATH_PREFIX + "")
    @Override
    public Page<UserRoleDTO> getPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return dao.findAllDto(PageRequest.of(page, size));
    }
}
