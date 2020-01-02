package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.MapBlogTagsDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.data.api.MapBlogTagsDao;
import org.enargit.karaf.web.rest.api.MapBlogTagsRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = MapBlogTagsRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
, JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class MapBlogTagsRestServiceImpl implements MapBlogTagsRestService {

    volatile MapBlogTagsDao dao;


    @Reference(service = MapBlogTagsDao.class, bind = "setDao")
    public void setDao(MapBlogTagsDao dao) {
        this.dao = dao;
    }

    public MapBlogTagsDao getDao() {
        return dao;
    }


    @Override
    public void bind(MapBlogTagsDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }



    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(MapBlogTagsRestService.PATH_PREFIX + "" )
    @Override
    public List<MapBlogTagsDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(MapBlogTagsRestService.PATH_PREFIX + "/{id}" )
    @Override
    public MapBlogTagsDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(MapBlogTagsRestService.PATH_PREFIX + "/{id}" )
    @Override
    public MapBlogTagsDTO update(@PathParam("id") String id, MapBlogTagsDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(MapBlogTagsRestService.PATH_PREFIX )
    @Override
    public MapBlogTagsDTO create(MapBlogTagsDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path(MapBlogTagsRestService.PATH_PREFIX + "/{id}" )
    @Override
    public MapBlogTagsDTO deleteById(@PathParam("id") String id) {
        MapBlogTagsDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(MapBlogTagsRestService.PATH_PREFIX + "")
    @Override
    public Page<MapBlogTagsDTO> getPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return dao.findAllDto(PageRequest.of(page, size));
    }
}
