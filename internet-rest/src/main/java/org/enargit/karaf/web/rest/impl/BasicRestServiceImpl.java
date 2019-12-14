package org.enargit.karaf.web.rest.impl;

import com.querydsl.core.types.dsl.EntityPathBase;
import org.enargit.karaf.data.dao.api.BasicDao;
import org.enargit.karaf.data.dto.BasicDto;
import org.enargit.karaf.data.entities.BasicEntity;
import org.enargit.karaf.web.rest.api.BasicRestService;


public abstract class BasicRestServiceImpl<E extends BasicEntity<ID>, D extends BasicDto<ID>, R extends BasicDao<E, D, ID, Q>,
        Q extends EntityPathBase<E>, ID> implements BasicRestService<E, D, R, Q, ID> {


}
