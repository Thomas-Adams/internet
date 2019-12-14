package org.enargit.karaf.web.rest.impl;

import lombok.extern.slf4j.Slf4j;
import org.enargit.karaf.data.api.TagDao;
import org.enargit.karaf.data.dto.TagDto;
import org.enargit.karaf.web.rest.api.TagRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Slf4j
@Singleton
@Path("/tag-service")
@Component(immediate = true, service = TagRestService.class,
        property = {
                JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT +
                        "=(osgi.jaxrs.name=.default)",
                JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true"
        })
public class TagRestServiceImpl implements TagRestService {


    volatile TagDao dao;

    @Reference(service = TagDao.class,  bind = "setDao")
    public void setDao(TagDao dao) {
        this.dao = dao;
    }



    @Override
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
    @Path(TagRestService.PATH_PREFIX)
    @Override
    public List<TagDto> getAll() {
        boolean isOfDaoImpl = this.dao instanceof TagDao;
        boolean isNotNull = this.dao !=null;
        log.info("DAO is of class TagDaoImpl {}", isOfDaoImpl);
        log.info("DAO is of not null {}", isNotNull);
        return dao.findAllDto();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(TagRestService.PATH_PREFIX + "/{id}" )
    @Override
    public TagDto getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(TagRestService.PATH_PREFIX + "/{id}" )
    @Override
    public TagDto update(@PathParam("id") String id, TagDto dto) {
        return dao.save( dto);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(TagRestService.PATH_PREFIX )
    @Override
    public TagDto create(TagDto dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path(TagRestService.PATH_PREFIX + "/{id}" )
    @Override
    public TagDto deleteById(@PathParam("id") String id) {
        TagDto dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }
}
