package org.enargit.karaf.web.rest.impl;

import com.querydsl.core.types.dsl.EntityPathBase;

import org.enargit.karaf.core.dto.BasicDto;
import org.enargit.karaf.core.entities.BasicEntity;
import org.enargit.karaf.data.api.BasicDao;
import org.enargit.karaf.mapper.api.BaseMapper;
import org.enargit.karaf.web.rest.api.BasicRestService;


public abstract class BasicRestServiceImpl<E extends BasicEntity<ID>, D extends BasicDto<ID>, M extends BaseMapper<E,D,ID>, R extends BasicDao<E, D, ID, Q, M>,
        Q extends EntityPathBase<E>, ID> implements BasicRestService<E, D, M, R, Q, ID> {


}
