package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.UserDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.data.api.UserDao;
import org.enargit.karaf.web.rest.api.UserRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = UserRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
, JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class UserRestServiceImpl implements UserRestService {

    volatile UserDao dao;


    @Reference(service = UserDao.class, bind = "setDao")
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public UserDao getDao() {
        return dao;
    }


    @Override
    public void bind(UserDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(UserRestService.PATH_PREFIX + "" )
    @Override
    public List<UserDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(UserRestService.PATH_PREFIX + "/{id}" )
    @Override
    public UserDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(UserRestService.PATH_PREFIX + "/{id}" )
    @Override
    public UserDTO update(@PathParam("id") String id, UserDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(UserRestService.PATH_PREFIX )
    @Override
    public UserDTO create(UserDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path(UserRestService.PATH_PREFIX + "/{id}" )
    @Override
    public UserDTO deleteById(@PathParam("id") String id) {
        UserDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(UserRestService.PATH_PREFIX + "")
    @Override
    public Page<UserDTO> getPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return dao.findAllDto(PageRequest.of(page, size));
    }
}
