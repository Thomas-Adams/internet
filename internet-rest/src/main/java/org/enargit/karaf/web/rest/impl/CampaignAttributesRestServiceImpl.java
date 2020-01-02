package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.CampaignAttributesDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.data.api.CampaignAttributesDao;
import org.enargit.karaf.web.rest.api.CampaignAttributesRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = CampaignAttributesRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
, JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class CampaignAttributesRestServiceImpl implements CampaignAttributesRestService {

    volatile CampaignAttributesDao dao;


    @Reference(service = CampaignAttributesDao.class, bind = "setDao")
    public void setDao(CampaignAttributesDao dao) {
        this.dao = dao;
    }

    public CampaignAttributesDao getDao() {
        return dao;
    }


    @Override
    public void bind(CampaignAttributesDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }



    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(CampaignAttributesRestService.PATH_PREFIX + "" )
    @Override
    public List<CampaignAttributesDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(CampaignAttributesRestService.PATH_PREFIX + "/{id}" )
    @Override
    public CampaignAttributesDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(CampaignAttributesRestService.PATH_PREFIX + "/{id}" )
    @Override
    public CampaignAttributesDTO update(@PathParam("id") String id, CampaignAttributesDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(CampaignAttributesRestService.PATH_PREFIX )
    @Override
    public CampaignAttributesDTO create(CampaignAttributesDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path(CampaignAttributesRestService.PATH_PREFIX + "/{id}" )
    @Override
    public CampaignAttributesDTO deleteById(@PathParam("id") String id) {
        CampaignAttributesDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(CampaignAttributesRestService.PATH_PREFIX + "")
    @Override
    public Page<CampaignAttributesDTO> getPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return dao.findAllDto(PageRequest.of(page, size));
    }
}
