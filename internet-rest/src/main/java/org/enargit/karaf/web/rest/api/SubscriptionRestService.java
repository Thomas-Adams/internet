package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.SubscriptionDTO;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.data.api.SubscriptionDao;

import java.util.List;

public interface SubscriptionRestService {

    public static String PATH_PREFIX = "/subscription";

    void bind(SubscriptionDao dao);

    SubscriptionDao getDao();

    Long convert(String id);

    List<SubscriptionDTO> getAll();

    Page<SubscriptionDTO> getPage(int page, int size);

    SubscriptionDTO getById(String id);

    SubscriptionDTO update(String id, SubscriptionDTO entity);

    SubscriptionDTO create(SubscriptionDTO entity);

    SubscriptionDTO deleteById(String id);
}
