package org.enargit.karaf.data.dao.impl;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.aries.jpa.template.JpaTemplate;
import org.apache.aries.jpa.template.TransactionType;
import org.enargit.karaf.data.dao.api.BasicDao;
import org.enargit.karaf.data.dto.BasicDto;
import org.enargit.karaf.data.entities.BasicEntity;
import org.enargit.karaf.data.mapper.api.BaseMapper;
import org.enargit.karaf.data.pagination.Page;
import org.enargit.karaf.data.pagination.PageImpl;
import org.enargit.karaf.data.pagination.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Data
public abstract class BasicDaoImpl<E extends BasicEntity<ID>, D extends BasicDto<ID>, ID, Q extends EntityPathBase<E>, M extends BaseMapper<E, D, ID>> implements BasicDao<E, D, ID,
        Q, M> {


    public abstract M getMapper();

    public abstract void setMapper(M mapper);

    public abstract JpaTemplate getJpaTemplate();

    public abstract void setJpaTemplate(JpaTemplate jpaTemplate);

    protected Class<E> entityClass;

    protected Class<ID> idClass;

    protected Q entityPathBase;



    @Override
    public E find(ID id) {
        return getJpaTemplate().txExpr(TransactionType.Required,
                entityManager -> entityManager.find(entityClass, id));
    }

    @Override
    public List<E> findAll() {
        return getJpaTemplate().txExpr(TransactionType.Required,
                entityManager ->
                     new JPAQueryFactory(entityManager).selectFrom(entityPathBase).fetch());
    }

    @Override
    public List<D> findAllDto() {
        return getMapper().convertToDTOList(findAll());
    }

    @Override
    public void persist(E entity) {
        getJpaTemplate().tx(TransactionType.Required, entityManager -> {
            entityManager.persist(entity);
            entityManager.flush();
        });
    }

    @Override
    public E merge(E entity) {
        return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(entity));
    }

    @Override
    public D merge(D dto) {
        return getMapper().convertToDTO(getJpaTemplate().txExpr(TransactionType.Required,
                entityManager -> entityManager.merge(getMapper().convertToEntity(dto))));
    }

    @Override
    public E save(E entity) {
        return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(entity));
    }

    @Override
    public D save(D dto) {
        return getMapper().convertToDTO(save(getMapper().convertToEntity(dto)));
    }

    @Override
    public E create(E entity) {
        return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(entity));
    }

    @Override
    public D create(D dto) {
        return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(dto));
    }

    @Override
    public void delete(ID id) {
        getJpaTemplate().tx(TransactionType.Required, entityManager -> {
            E entity = entityManager.find(entityClass, id);
            if (entity != null) {
                entityManager.remove(entity);
            }
        });
    }

    @Override
    public List<E> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers) {
        return getJpaTemplate().txExpr(TransactionType.Required,
                entityManager ->new  JPAQueryFactory(entityManager).selectFrom(entityPathBase).where(predicate).orderBy(orderSpecifiers).fetch());
    }

    @Override
    public List<D> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers) {
        return getMapper().convertToDTOList(findAll(predicate, orderSpecifiers));
    }

    @Override
    public Page<E> findAll(Pageable pageable) {
        List<E> result = getJpaTemplate().txExpr(TransactionType.Required,
                entityManager -> new  JPAQueryFactory(entityManager).selectFrom(entityPathBase).offset((pageable.getPageNumber() - 1) * pageable.getPageSize()).limit(pageable.getPageSize()).fetch());
        return new PageImpl<E>(result);
    }

    @Override
    public Page<D> findAllDto(Pageable pageable) {
        return getMapper().convertToDTOPage(findAll(pageable));
    }

    @Override
    public Page<E> findAll(Pageable pageable, Predicate predicate) {
        List<E> result = getJpaTemplate().txExpr(TransactionType.Required,
                entityManager -> new  JPAQueryFactory(entityManager).selectFrom(entityPathBase).where(predicate)
                        .offset((pageable.getPageNumber() - 1) * pageable.getPageSize()).limit(pageable.getPageSize()).fetch());
        return new PageImpl<E>(result);
    }

    @Override
    public Page<D> findAllDto(Pageable pageable, Predicate predicate) {
        return getMapper().convertToDTOPage(findAll(pageable, predicate));
    }

    @Override
    public List<E> findAllByPredicate(Predicate predicate) {
        return getJpaTemplate().txExpr(TransactionType.Required,
                entityManager -> new  JPAQueryFactory(entityManager).selectFrom(entityPathBase).where(predicate).fetch());
    }

    @Override
    public List<D> findAllDtoByPredicate(Predicate predicate) {
        return getMapper().convertToDTOList(findAllByPredicate(predicate));
    }

    @Override
    public void deleteInBatch(Iterable<E> entities) {
        entities.forEach(e -> getJpaTemplate().tx( entityManager -> {
            entityManager.remove(e);
        }));
    }


    @Override
    public List<E> saveAll(List<E> entities) {
        return entities.stream().map(e -> getJpaTemplate().txExpr( TransactionType.Required, entityManager -> entityManager.merge(e))).collect(Collectors.toList());
    }

    @Override
    public List<D> saveAllDto(List<D> dtos) {
        return getMapper().convertToDTOList(saveAll(getMapper().convertToEntityList(dtos)));
    }

    @Override
    public Set<E> saveAll(Set<E> entities) {
        return entities.stream().map(e -> getJpaTemplate().txExpr( TransactionType.Required, entityManager -> entityManager.merge(e))).collect(Collectors.toSet());
    }

    @Override
    public Set<D> saveAllDto(Set<D> dtos) {
        return getMapper().convertToDTOSet(saveAll(getMapper().convertToEntitySet(dtos)));
    }

    @Override
    public long count() {
        return getJpaTemplate().txExpr( TransactionType.Required,
                entityManager ->  new  JPAQueryFactory(entityManager).selectFrom(entityPathBase).fetchCount());
    }

    @Override
    public long count(Predicate predicate) {
        return getJpaTemplate().txExpr( TransactionType.Required,
                entityManager ->  new  JPAQueryFactory(entityManager).selectFrom(entityPathBase).where(predicate).fetchCount());
    }

    @Override
    public boolean exists(Predicate predicate) {
        return getJpaTemplate().txExpr( TransactionType.Required,
                entityManager ->  new  JPAQueryFactory(entityManager).selectFrom(entityPathBase).where(predicate).fetchCount())>0;
    }

    @Override
    public boolean exists(ID id) {
        Path<E> entityPath = Expressions.path(entityClass, "entity");
        Path<ID> entityId = Expressions.path(idClass, entityPath, "id");
        Expression<ID> constant = Expressions.constant(id);
        return getJpaTemplate().txExpr( TransactionType.Required,
                entityManager ->  new  JPAQueryFactory(entityManager).selectFrom(entityPathBase).where(Expressions.predicate(Ops.EQ, entityId, constant)).fetchCount())>0;
    }


    @Override
    public Optional<E> findOne(Predicate predicate) {
        E result = getJpaTemplate().txExpr( TransactionType.Required,
                entityManager ->  new  JPAQueryFactory(entityManager).selectFrom(entityPathBase).where(predicate).fetchOne());
        return Optional.of(result);
    }

    @Override
    public Optional<D> findOneDto(Predicate predicate) {
        Optional<E> entityResult = findOne(predicate);
        if (entityResult.isPresent()) {
            return Optional.of(getMapper().convertToDTO(entityResult.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public D findDto(ID id) {
        return getMapper().convertToDTO(getJpaTemplate().txExpr(TransactionType.Required,
                entityManager -> entityManager.find(entityClass, id)));
    }


}
