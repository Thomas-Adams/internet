package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.ProfileAttributesDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.data.api.ProfileAttributesDao;
import org.enargit.karaf.web.rest.api.ProfileAttributesRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = ProfileAttributesRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
, JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class ProfileAttributesRestServiceImpl implements ProfileAttributesRestService {

    volatile ProfileAttributesDao dao;


    @Reference(service = ProfileAttributesDao.class, bind = "setDao")
    public void setDao(ProfileAttributesDao dao) {
        this.dao = dao;
    }

    public ProfileAttributesDao getDao() {
        return dao;
    }


    @Override
    public void bind(ProfileAttributesDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(ProfileAttributesRestService.PATH_PREFIX + "" )
    @Override
    public List<ProfileAttributesDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(ProfileAttributesRestService.PATH_PREFIX + "/{id}" )
    @Override
    public ProfileAttributesDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(ProfileAttributesRestService.PATH_PREFIX + "/{id}" )
    @Override
    public ProfileAttributesDTO update(@PathParam("id") String id, ProfileAttributesDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(ProfileAttributesRestService.PATH_PREFIX )
    @Override
    public ProfileAttributesDTO create(ProfileAttributesDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path(ProfileAttributesRestService.PATH_PREFIX + "/{id}" )
    @Override
    public ProfileAttributesDTO deleteById(@PathParam("id") String id) {
        ProfileAttributesDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(ProfileAttributesRestService.PATH_PREFIX + "")
    @Override
    public Page<ProfileAttributesDTO> getPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return dao.findAllDto(PageRequest.of(page, size));
    }
}
