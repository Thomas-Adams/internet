package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.CampaignAttributesDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.CampaignAttributesDao;

import java.util.List;

public interface CampaignAttributesRestService {

    public static String PATH_PREFIX = "/campaignAttributes";

    void bind(CampaignAttributesDao dao);

    CampaignAttributesDao getDao();

    Long convert(String id);

    List<CampaignAttributesDTO> getAll();

    Page<CampaignAttributesDTO> getPage(int page, int size);

    CampaignAttributesDTO getById(String id);

    CampaignAttributesDTO update(String id, CampaignAttributesDTO entity);

    CampaignAttributesDTO create(CampaignAttributesDTO entity);

    CampaignAttributesDTO deleteById(String id);
}
