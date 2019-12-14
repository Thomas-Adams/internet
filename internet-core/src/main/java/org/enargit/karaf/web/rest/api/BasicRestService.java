package org.enargit.karaf.web.rest.api;

import com.querydsl.core.types.dsl.EntityPathBase;
import org.enargit.karaf.data.api.BasicDao;
import org.enargit.karaf.data.dto.BasicDto;
import org.enargit.karaf.data.entities.BasicEntity;

public interface BasicRestService<E extends BasicEntity<ID>, D extends BasicDto<ID>, R extends BasicDao<E, D, ID, Q>, Q extends EntityPathBase<E>, ID> {

    void bind(R dao);

    R getDao();

    ID convert(String id);

}
