package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.CategoryDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.data.api.CategoryDao;
import org.enargit.karaf.web.rest.api.CategoryRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = CategoryRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
, JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class CategoryRestServiceImpl implements CategoryRestService {

    volatile CategoryDao dao;


    @Reference(service = CategoryDao.class, bind = "setDao")
    public void setDao(CategoryDao dao) {
        this.dao = dao;
    }

    public CategoryDao getDao() {
        return dao;
    }


    @Override
    public void bind(CategoryDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }



    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(CategoryRestService.PATH_PREFIX + "" )
    @Override
    public List<CategoryDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(CategoryRestService.PATH_PREFIX + "/{id}" )
    @Override
    public CategoryDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(CategoryRestService.PATH_PREFIX + "/{id}" )
    @Override
    public CategoryDTO update(@PathParam("id") String id, CategoryDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(CategoryRestService.PATH_PREFIX )
    @Override
    public CategoryDTO create(CategoryDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path(CategoryRestService.PATH_PREFIX + "/{id}" )
    @Override
    public CategoryDTO deleteById(@PathParam("id") String id) {
        CategoryDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(CategoryRestService.PATH_PREFIX + "")
    @Override
    public Page<CategoryDTO> getPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return dao.findAllDto(PageRequest.of(page, size));
    }
}
