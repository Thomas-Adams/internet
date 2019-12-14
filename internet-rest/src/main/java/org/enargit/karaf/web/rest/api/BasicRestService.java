package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.BasicDto;
import org.enargit.karaf.core.entities.BasicEntity;
import org.enargit.karaf.data.api.BasicDao;
import org.enargit.karaf.mapper.api.BaseMapper;

import com.querydsl.core.types.dsl.EntityPathBase;


public interface BasicRestService<E extends BasicEntity<ID>, D extends BasicDto<ID>, M extends BaseMapper<E,D,ID>, R extends BasicDao<E, D, ID, Q, M>, Q extends EntityPathBase<E>, ID> {

    void bind(R dao);

    R getDao();

    ID convert(String id);

}
