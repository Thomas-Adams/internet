package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.ProfileDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.data.api.ProfileDao;
import org.enargit.karaf.web.rest.api.ProfileRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = ProfileRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
, JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class ProfileRestServiceImpl implements ProfileRestService {

    volatile ProfileDao dao;


    @Reference(service = ProfileDao.class, bind = "setDao")
    public void setDao(ProfileDao dao) {
        this.dao = dao;
    }

    public ProfileDao getDao() {
        return dao;
    }


    @Override
    public void bind(ProfileDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(ProfileRestService.PATH_PREFIX + "" )
    @Override
    public List<ProfileDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(ProfileRestService.PATH_PREFIX + "/{id}" )
    @Override
    public ProfileDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(ProfileRestService.PATH_PREFIX + "/{id}" )
    @Override
    public ProfileDTO update(@PathParam("id") String id, ProfileDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(ProfileRestService.PATH_PREFIX )
    @Override
    public ProfileDTO create(ProfileDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path(ProfileRestService.PATH_PREFIX + "/{id}" )
    @Override
    public ProfileDTO deleteById(@PathParam("id") String id) {
        ProfileDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(ProfileRestService.PATH_PREFIX + "")
    @Override
    public Page<ProfileDTO> getPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return dao.findAllDto(PageRequest.of(page, size));
    }
}
