package org.enargit.karaf.web.rest.impl;

import org.enargit.karaf.core.dto.CampaignDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.data.api.CampaignDao;
import org.enargit.karaf.web.rest.api.CampaignRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Component(service = CampaignRestService.class, immediate = true, property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)"
, JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" })
public class CampaignRestServiceImpl implements CampaignRestService {

    volatile CampaignDao dao;


    @Reference(service = CampaignDao.class, bind = "setDao")
    public void setDao(CampaignDao dao) {
        this.dao = dao;
    }

    public CampaignDao getDao() {
        return dao;
    }


    @Override
    public void bind(CampaignDao dao) {
        this.dao = dao;
    }



    @Override
    public Long convert(String id) {
        return Long.parseLong(id);
    }



    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(CampaignRestService.PATH_PREFIX + "" )
    @Override
    public List<CampaignDTO> getAll() {
        return dao.findAllDto();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(CampaignRestService.PATH_PREFIX + "/{id}" )
    @Override
    public CampaignDTO getById(@PathParam("id") String id) {
        return dao.findDto(convert(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(CampaignRestService.PATH_PREFIX + "/{id}" )
    @Override
    public CampaignDTO update(@PathParam("id") String id, CampaignDTO dto) {
        return dao.save( dto);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path(CampaignRestService.PATH_PREFIX )
    @Override
    public CampaignDTO create(CampaignDTO dto) {
        return dao.save(dto);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path(CampaignRestService.PATH_PREFIX + "/{id}" )
    @Override
    public CampaignDTO deleteById(@PathParam("id") String id) {
        CampaignDTO dto = dao.findDto(convert(id));
        dao.delete(convert(id));
        return dto;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(CampaignRestService.PATH_PREFIX + "")
    @Override
    public Page<CampaignDTO> getPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return dao.findAllDto(PageRequest.of(page, size));
    }
}
