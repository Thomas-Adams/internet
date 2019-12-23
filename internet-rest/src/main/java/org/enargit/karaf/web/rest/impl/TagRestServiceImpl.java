package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.TagDTO;
import org.enargit.karaf.data.api.TagDao;
import org.enargit.karaf.web.rest.api.TagRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = TagRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
, JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class TagRestServiceImpl implements TagRestService {

    volatile TagDao dao;


    @Reference(service = TagDao.class, bind = "setDao")
    public void setDao(TagDao dao) {
        this.dao = dao;
    }

    public TagDao getDao() {
        return dao;
    }


    @Override
    public void bind(TagDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(TagRestService.PATH_PREFIX + "" )
    @Override
    public List<TagDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(TagRestService.PATH_PREFIX + "/{id}" )
    @Override
    public TagDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(TagRestService.PATH_PREFIX + "/{id}" )
    @Override
    public TagDTO update(@PathParam("id") String id, TagDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(TagRestService.PATH_PREFIX )
    @Override
    public TagDTO create(TagDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path(TagRestService.PATH_PREFIX + "/{id}" )
    @Override
    public TagDTO deleteById(@PathParam("id") String id) {
        TagDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }
}
