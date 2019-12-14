package org.enargit.karaf.data.dao.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.EntityPathBase;
import org.enargit.karaf.data.dto.BasicDto;
import org.enargit.karaf.data.entities.BasicEntity;
import org.enargit.karaf.data.mapper.api.BaseMapper;
import org.enargit.karaf.data.pagination.Page;
import org.enargit.karaf.data.pagination.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BasicDao<E extends BasicEntity<ID>, D extends BasicDto<ID>, ID, Q extends EntityPathBase<E>, M extends BaseMapper<E, D, ID>> {

    M getMapper();

    void setMapper(M mapper);


    E find(ID id);

    D findDto(ID id);

    List<E> findAll();

    List<D> findAllDto();

    void persist(E entity);

    E merge(E entity);

    D merge(D dto);

    E save(E entity);

    D save(D dto);

    D create(D dto);

    E create(E entity);

    void delete(ID id);

    List<E> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<D> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<E> findAll(Pageable pageable);

    Page<D> findAllDto(Pageable pageable);

    Page<E> findAll(Pageable pageable, Predicate predicate);

    Page<D> findAllDto(Pageable pageable, Predicate predicate);

    List<E> findAllByPredicate(Predicate predicate);

    List<D> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<E> entities);

    List<E> saveAll(List<E> entities);

    List<D> saveAllDto(List<D> dtos);

    Set<E> saveAll(Set<E> entities);

    Set<D> saveAllDto(Set<D> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(ID id);

    Optional<E> findOne(Predicate predicate);

    Optional<D> findOneDto(Predicate predicate);
}
