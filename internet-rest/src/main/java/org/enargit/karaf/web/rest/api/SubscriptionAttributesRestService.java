package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.SubscriptionAttributesDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.SubscriptionAttributesDao;

import java.util.List;

public interface SubscriptionAttributesRestService {

    public static String PATH_PREFIX = "/subscriptionAttributes";

    void bind(SubscriptionAttributesDao dao);

    SubscriptionAttributesDao getDao();

    Long convert(String id);

    List<SubscriptionAttributesDTO> getAll();

    Page<SubscriptionAttributesDTO> getPage(int page, int size);

    SubscriptionAttributesDTO getById(String id);

    SubscriptionAttributesDTO update(String id, SubscriptionAttributesDTO entity);

    SubscriptionAttributesDTO create(SubscriptionAttributesDTO entity);

    SubscriptionAttributesDTO deleteById(String id);
}
