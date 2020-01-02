package org.enargit.karaf.data.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.aries.jpa.template.JpaTemplate;
import org.apache.aries.jpa.template.TransactionType;
import org.enargit.karaf.core.dto.SelectionListValuesDTO;
import org.enargit.karaf.core.entities.SelectionListValues;
import org.enargit.karaf.core.entities.querydsl.QSelectionListValues;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.data.api.SelectionListValuesDao;
import org.enargit.karaf.mapper.api.SelectionListValuesMapper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Component(service = SelectionListValuesDao.class, immediate = true, name = "SelectionListValuesDao")
public class SelectionListValuesDaoImpl implements SelectionListValuesDao {

	private JpaTemplate jpaTemplate;

	private SelectionListValuesMapper mapper;

	protected Class<SelectionListValues> entityClass;

	protected Class<Long> idClass;

	protected QSelectionListValues entityPathBase;

	public JpaTemplate getJpaTemplate() {
		return jpaTemplate;
	}

	@Reference(service = JpaTemplate.class, target = "(osgi.unit.name=internetm_data)")
	public void setJpaTemplate(JpaTemplate jpaTemplate) {
		this.jpaTemplate = jpaTemplate;
	}

	@Override
	public SelectionListValuesMapper getMapper() {
		return this.mapper;
	}

	@Override
	@Reference(service = SelectionListValuesMapper.class, target = "(component.name=SelectionListValuesMapper)")
	public void setMapper(SelectionListValuesMapper mapper) {
		this.mapper = mapper;
	}

	public SelectionListValuesDaoImpl() {
		this.entityClass = SelectionListValues.class;
		this.entityPathBase = QSelectionListValues.selectionListValues;
		this.idClass = Long.class;
	}

	@Override
	public SelectionListValues find(Long id) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.find(entityClass, id));
	}

	@Override
	public List<SelectionListValues> findAll() {
		return getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase).fetch());
	}

	@Override
	public List<SelectionListValuesDTO> findAllDto() {
		return getMapper().convertToDTOList(findAll());
	}

	@Override
	public void persist(SelectionListValues entity) {
		getJpaTemplate().tx(TransactionType.Required, entityManager -> {
			entityManager.persist(entity);
			entityManager.flush();
		});
	}

	@Override
	public SelectionListValues merge(SelectionListValues entity) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(entity));
	}

	@Override
	public SelectionListValuesDTO merge(SelectionListValuesDTO dto) {
		return getMapper().convertToDTO(getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> entityManager.merge(getMapper().convertToEntity(dto))));
	}

	@Override
	public SelectionListValues save(SelectionListValues entity) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(entity));
	}

	@Override
	public SelectionListValuesDTO save(SelectionListValuesDTO dto) {
		return getMapper().convertToDTO(save(getMapper().convertToEntity(dto)));
	}

	@Override
	public SelectionListValues create(SelectionListValues entity) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(entity));
	}

	@Override
	public SelectionListValuesDTO create(SelectionListValuesDTO dto) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(dto));
	}

	@Override
	public void delete(Long id) {
		getJpaTemplate().tx(TransactionType.Required, entityManager -> {
			SelectionListValues entity = entityManager.find(entityClass, id);
			if (entity != null) {
				entityManager.remove(entity);
			}
		});
	}

	@Override
	public List<SelectionListValues> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> new JPAQueryFactory(entityManager)
				.selectFrom(entityPathBase).where(predicate).orderBy(orderSpecifiers).fetch());
	}

	@Override
	public List<SelectionListValuesDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers) {
		return getMapper().convertToDTOList(findAll(predicate, orderSpecifiers));
	}

	@Override
	public Page<SelectionListValues> findAll(Pageable pageable) {
		List<SelectionListValues> result = getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase)
						.offset((pageable.getPageNumber() - 1) * pageable.getPageSize()).limit(pageable.getPageSize())
						.fetch());
		return new PageImpl<SelectionListValues>(result);
	}

	@Override
	public Page<SelectionListValuesDTO> findAllDto(Pageable pageable) {
		return getMapper().convertToDTOPage(findAll(pageable));
	}

	@Override
	public Page<SelectionListValues> findAll(Pageable pageable, Predicate predicate) {
		List<SelectionListValues> result = getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase).where(predicate)
						.offset((pageable.getPageNumber() - 1) * pageable.getPageSize()).limit(pageable.getPageSize())
						.fetch());
		return new PageImpl<SelectionListValues>(result);
	}

	@Override
	public Page<SelectionListValuesDTO> findAllDto(Pageable pageable, Predicate predicate) {
		return getMapper().convertToDTOPage(findAll(pageable, predicate));
	}

	@Override
	public List<SelectionListValues> findAllByPredicate(Predicate predicate) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> new JPAQueryFactory(entityManager)
				.selectFrom(entityPathBase).where(predicate).fetch());
	}

	@Override
	public List<SelectionListValuesDTO> findAllDtoByPredicate(Predicate predicate) {
		return getMapper().convertToDTOList(findAllByPredicate(predicate));
	}

	@Override
	public void deleteInBatch(Iterable<SelectionListValues> entities) {
		entities.forEach(e -> getJpaTemplate().tx(entityManager -> {
			entityManager.remove(e);
		}));
	}

	@Override
	public List<SelectionListValues> saveAll(List<SelectionListValues> entities) {
		return entities.stream()
				.map(e -> getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(e)))
				.collect(Collectors.toList());
	}

	@Override
	public List<SelectionListValuesDTO> saveAllDto(List<SelectionListValuesDTO> dtos) {
		return getMapper().convertToDTOList(saveAll(getMapper().convertToEntityList(dtos)));
	}

	@Override
	public Set<SelectionListValues> saveAll(Set<SelectionListValues> entities) {
		return entities.stream()
				.map(e -> getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(e)))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<SelectionListValuesDTO> saveAllDto(Set<SelectionListValuesDTO> dtos) {
		return getMapper().convertToDTOSet(saveAll(getMapper().convertToEntitySet(dtos)));
	}

	@Override
	public long count() {
		return getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase).fetchCount());
	}

	@Override
	public long count(Predicate predicate) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> new JPAQueryFactory(entityManager)
				.selectFrom(entityPathBase).where(predicate).fetchCount());
	}

	@Override
	public boolean exists(Predicate predicate) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> new JPAQueryFactory(entityManager)
				.selectFrom(entityPathBase).where(predicate).fetchCount()) > 0;
	}

	@Override
	public boolean exists(Long id) {
		Path<SelectionListValues> entityPath = Expressions.path(entityClass, "entity");
		Path<Long> entityId = Expressions.path(idClass, entityPath, "id");
		Expression<Long> constant = Expressions.constant(id);
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> new JPAQueryFactory(entityManager)
				.selectFrom(entityPathBase).where(Expressions.predicate(Ops.EQ, entityId, constant)).fetchCount()) > 0;
	}

	@Override
	public Optional<SelectionListValues> findOne(Predicate predicate) {
		SelectionListValues result = getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase).where(predicate)
						.fetchOne());
		return Optional.of(result);
	}

	@Override
	public Optional<SelectionListValuesDTO> findOneDto(Predicate predicate) {
		Optional<SelectionListValues> entityResult = findOne(predicate);
		if (entityResult.isPresent()) {
			return Optional.of(getMapper().convertToDTO(entityResult.get()));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public SelectionListValuesDTO findDto(Long id) {
		return getMapper().convertToDTO(getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> entityManager.find(entityClass, id)));
	}
}
