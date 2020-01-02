package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.CampaignDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.CampaignDao;

import java.util.List;

public interface CampaignRestService {

    public static String PATH_PREFIX = "/campaign";

    void bind(CampaignDao dao);

    CampaignDao getDao();

    Long convert(String id);

    List<CampaignDTO> getAll();

    Page<CampaignDTO> getPage(int page, int size);

    CampaignDTO getById(String id);

    CampaignDTO update(String id, CampaignDTO entity);

    CampaignDTO create(CampaignDTO entity);

    CampaignDTO deleteById(String id);
}
