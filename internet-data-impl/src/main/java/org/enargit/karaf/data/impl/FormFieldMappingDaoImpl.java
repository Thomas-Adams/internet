package org.enargit.karaf.data.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.aries.jpa.template.JpaTemplate;
import org.apache.aries.jpa.template.TransactionType;
import org.enargit.karaf.core.dto.FormFieldMappingDTO;
import org.enargit.karaf.core.entities.FormFieldMapping;
import org.enargit.karaf.core.entities.querydsl.QFormFieldMapping;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.data.api.FormFieldMappingDao;
import org.enargit.karaf.mapper.api.FormFieldMappingMapper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Component(service = FormFieldMappingDao.class, immediate = true, name = "FormFieldMappingDao")
public class FormFieldMappingDaoImpl implements FormFieldMappingDao {

	private JpaTemplate jpaTemplate;

	private FormFieldMappingMapper mapper;

	protected Class<FormFieldMapping> entityClass;

	protected Class<Long> idClass;

	protected QFormFieldMapping entityPathBase;

	public JpaTemplate getJpaTemplate() {
		return jpaTemplate;
	}

	@Reference(service = JpaTemplate.class, target = "(osgi.unit.name=internetm_data)")
	public void setJpaTemplate(JpaTemplate jpaTemplate) {
		this.jpaTemplate = jpaTemplate;
	}

	@Override
	public FormFieldMappingMapper getMapper() {
		return this.mapper;
	}

	@Override
	@Reference(service = FormFieldMappingMapper.class, target = "(component.name=FormFieldMappingMapper)")
	public void setMapper(FormFieldMappingMapper mapper) {
		this.mapper = mapper;
	}

	public FormFieldMappingDaoImpl() {
		this.entityClass = FormFieldMapping.class;
		this.entityPathBase = QFormFieldMapping.formFieldMapping;
		this.idClass = Long.class;
	}

	@Override
	public FormFieldMapping find(Long id) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.find(entityClass, id));
	}

	@Override
	public List<FormFieldMapping> findAll() {
		return getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase).fetch());
	}

	@Override
	public List<FormFieldMappingDTO> findAllDto() {
		return getMapper().convertToDTOList(findAll());
	}

	@Override
	public void persist(FormFieldMapping entity) {
		getJpaTemplate().tx(TransactionType.Required, entityManager -> {
			entityManager.persist(entity);
			entityManager.flush();
		});
	}

	@Override
	public FormFieldMapping merge(FormFieldMapping entity) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(entity));
	}

	@Override
	public FormFieldMappingDTO merge(FormFieldMappingDTO dto) {
		return getMapper().convertToDTO(getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> entityManager.merge(getMapper().convertToEntity(dto))));
	}

	@Override
	public FormFieldMapping save(FormFieldMapping entity) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(entity));
	}

	@Override
	public FormFieldMappingDTO save(FormFieldMappingDTO dto) {
		return getMapper().convertToDTO(save(getMapper().convertToEntity(dto)));
	}

	@Override
	public FormFieldMapping create(FormFieldMapping entity) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(entity));
	}

	@Override
	public FormFieldMappingDTO create(FormFieldMappingDTO dto) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(dto));
	}

	@Override
	public void delete(Long id) {
		getJpaTemplate().tx(TransactionType.Required, entityManager -> {
			FormFieldMapping entity = entityManager.find(entityClass, id);
			if (entity != null) {
				entityManager.remove(entity);
			}
		});
	}

	@Override
	public List<FormFieldMapping> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> new JPAQueryFactory(entityManager)
				.selectFrom(entityPathBase).where(predicate).orderBy(orderSpecifiers).fetch());
	}

	@Override
	public List<FormFieldMappingDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers) {
		return getMapper().convertToDTOList(findAll(predicate, orderSpecifiers));
	}

	@Override
	public Page<FormFieldMapping> findAll(Pageable pageable) {
		List<FormFieldMapping> result = getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase)
						.offset((pageable.getPageNumber() - 1) * pageable.getPageSize()).limit(pageable.getPageSize())
						.fetch());
		return new PageImpl<FormFieldMapping>(result);
	}

	@Override
	public Page<FormFieldMappingDTO> findAllDto(Pageable pageable) {
		return getMapper().convertToDTOPage(findAll(pageable));
	}

	@Override
	public Page<FormFieldMapping> findAll(Pageable pageable, Predicate predicate) {
		List<FormFieldMapping> result = getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase).where(predicate)
						.offset((pageable.getPageNumber() - 1) * pageable.getPageSize()).limit(pageable.getPageSize())
						.fetch());
		return new PageImpl<FormFieldMapping>(result);
	}

	@Override
	public Page<FormFieldMappingDTO> findAllDto(Pageable pageable, Predicate predicate) {
		return getMapper().convertToDTOPage(findAll(pageable, predicate));
	}

	@Override
	public List<FormFieldMapping> findAllByPredicate(Predicate predicate) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> new JPAQueryFactory(entityManager)
				.selectFrom(entityPathBase).where(predicate).fetch());
	}

	@Override
	public List<FormFieldMappingDTO> findAllDtoByPredicate(Predicate predicate) {
		return getMapper().convertToDTOList(findAllByPredicate(predicate));
	}

	@Override
	public void deleteInBatch(Iterable<FormFieldMapping> entities) {
		entities.forEach(e -> getJpaTemplate().tx(entityManager -> {
			entityManager.remove(e);
		}));
	}

	@Override
	public List<FormFieldMapping> saveAll(List<FormFieldMapping> entities) {
		return entities.stream()
				.map(e -> getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(e)))
				.collect(Collectors.toList());
	}

	@Override
	public List<FormFieldMappingDTO> saveAllDto(List<FormFieldMappingDTO> dtos) {
		return getMapper().convertToDTOList(saveAll(getMapper().convertToEntityList(dtos)));
	}

	@Override
	public Set<FormFieldMapping> saveAll(Set<FormFieldMapping> entities) {
		return entities.stream()
				.map(e -> getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(e)))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<FormFieldMappingDTO> saveAllDto(Set<FormFieldMappingDTO> dtos) {
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
		Path<FormFieldMapping> entityPath = Expressions.path(entityClass, "entity");
		Path<Long> entityId = Expressions.path(idClass, entityPath, "id");
		Expression<Long> constant = Expressions.constant(id);
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> new JPAQueryFactory(entityManager)
				.selectFrom(entityPathBase).where(Expressions.predicate(Ops.EQ, entityId, constant)).fetchCount()) > 0;
	}

	@Override
	public Optional<FormFieldMapping> findOne(Predicate predicate) {
		FormFieldMapping result = getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase).where(predicate)
						.fetchOne());
		return Optional.of(result);
	}

	@Override
	public Optional<FormFieldMappingDTO> findOneDto(Predicate predicate) {
		Optional<FormFieldMapping> entityResult = findOne(predicate);
		if (entityResult.isPresent()) {
			return Optional.of(getMapper().convertToDTO(entityResult.get()));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public FormFieldMappingDTO findDto(Long id) {
		return getMapper().convertToDTO(getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> entityManager.find(entityClass, id)));
	}
}
