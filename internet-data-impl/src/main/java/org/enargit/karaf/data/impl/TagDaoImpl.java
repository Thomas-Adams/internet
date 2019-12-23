package org.enargit.karaf.data.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.aries.jpa.template.JpaTemplate;
import org.apache.aries.jpa.template.TransactionType;
import org.enargit.karaf.core.dto.TagDTO;
import org.enargit.karaf.core.entities.Tag;
import org.enargit.karaf.core.entities.querydsl.QTag;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.data.api.TagDao;
import org.enargit.karaf.mapper.api.TagMapper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Component(service = TagDao.class, immediate = true, name = "TagDao")
public class TagDaoImpl implements TagDao {

	private JpaTemplate jpaTemplate;

	private TagMapper mapper;

	protected Class<Tag> entityClass;

	protected Class<Long> idClass;

	protected QTag entityPathBase;

	public JpaTemplate getJpaTemplate() {
		return jpaTemplate;
	}

	@Reference(service = JpaTemplate.class, target = "(osgi.unit.name=internetm_data)")
	public void setJpaTemplate(JpaTemplate jpaTemplate) {
		this.jpaTemplate = jpaTemplate;
	}

	@Override
	public TagMapper getMapper() {
		return this.mapper;
	}

	@Override
	@Reference(service = TagMapper.class, target = "(component.name=TagMapper)")
	public void setMapper(TagMapper mapper) {
		this.mapper = mapper;
	}

	public TagDaoImpl() {
		this.entityClass = Tag.class;
		this.entityPathBase = QTag.tag;
		this.idClass = Long.class;
	}

	@Override
	public Tag find(Long id) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.find(entityClass, id));
	}

	@Override
	public List<Tag> findAll() {
		return getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase).fetch());
	}

	@Override
	public List<TagDTO> findAllDto() {
		return getMapper().convertToDTOList(findAll());
	}

	@Override
	public void persist(Tag entity) {
		getJpaTemplate().tx(TransactionType.Required, entityManager -> {
			entityManager.persist(entity);
			entityManager.flush();
		});
	}

	@Override
	public Tag merge(Tag entity) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(entity));
	}

	@Override
	public TagDTO merge(TagDTO dto) {
		return getMapper().convertToDTO(getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> entityManager.merge(getMapper().convertToEntity(dto))));
	}

	@Override
	public Tag save(Tag entity) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(entity));
	}

	@Override
	public TagDTO save(TagDTO dto) {
		return getMapper().convertToDTO(save(getMapper().convertToEntity(dto)));
	}

	@Override
	public Tag create(Tag entity) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(entity));
	}

	@Override
	public TagDTO create(TagDTO dto) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(dto));
	}

	@Override
	public void delete(Long id) {
		getJpaTemplate().tx(TransactionType.Required, entityManager -> {
			Tag entity = entityManager.find(entityClass, id);
			if (entity != null) {
				entityManager.remove(entity);
			}
		});
	}

	@Override
	public List<Tag> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> new JPAQueryFactory(entityManager)
				.selectFrom(entityPathBase).where(predicate).orderBy(orderSpecifiers).fetch());
	}

	@Override
	public List<TagDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers) {
		return getMapper().convertToDTOList(findAll(predicate, orderSpecifiers));
	}

	@Override
	public Page<Tag> findAll(Pageable pageable) {
		List<Tag> result = getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase)
						.offset((pageable.getPageNumber() - 1) * pageable.getPageSize()).limit(pageable.getPageSize())
						.fetch());
		return new PageImpl<Tag>(result);
	}

	@Override
	public Page<TagDTO> findAllDto(Pageable pageable) {
		return getMapper().convertToDTOPage(findAll(pageable));
	}

	@Override
	public Page<Tag> findAll(Pageable pageable, Predicate predicate) {
		List<Tag> result = getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase).where(predicate)
						.offset((pageable.getPageNumber() - 1) * pageable.getPageSize()).limit(pageable.getPageSize())
						.fetch());
		return new PageImpl<Tag>(result);
	}

	@Override
	public Page<TagDTO> findAllDto(Pageable pageable, Predicate predicate) {
		return getMapper().convertToDTOPage(findAll(pageable, predicate));
	}

	@Override
	public List<Tag> findAllByPredicate(Predicate predicate) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> new JPAQueryFactory(entityManager)
				.selectFrom(entityPathBase).where(predicate).fetch());
	}

	@Override
	public List<TagDTO> findAllDtoByPredicate(Predicate predicate) {
		return getMapper().convertToDTOList(findAllByPredicate(predicate));
	}

	@Override
	public void deleteInBatch(Iterable<Tag> entities) {
		entities.forEach(e -> getJpaTemplate().tx(entityManager -> {
			entityManager.remove(e);
		}));
	}

	@Override
	public List<Tag> saveAll(List<Tag> entities) {
		return entities.stream()
				.map(e -> getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(e)))
				.collect(Collectors.toList());
	}

	@Override
	public List<TagDTO> saveAllDto(List<TagDTO> dtos) {
		return getMapper().convertToDTOList(saveAll(getMapper().convertToEntityList(dtos)));
	}

	@Override
	public Set<Tag> saveAll(Set<Tag> entities) {
		return entities.stream()
				.map(e -> getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(e)))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<TagDTO> saveAllDto(Set<TagDTO> dtos) {
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
		Path<Tag> entityPath = Expressions.path(entityClass, "entity");
		Path<Long> entityId = Expressions.path(idClass, entityPath, "id");
		Expression<Long> constant = Expressions.constant(id);
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> new JPAQueryFactory(entityManager)
				.selectFrom(entityPathBase).where(Expressions.predicate(Ops.EQ, entityId, constant)).fetchCount()) > 0;
	}

	@Override
	public Optional<Tag> findOne(Predicate predicate) {
		Tag result = getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase).where(predicate)
						.fetchOne());
		return Optional.of(result);
	}

	@Override
	public Optional<TagDTO> findOneDto(Predicate predicate) {
		Optional<Tag> entityResult = findOne(predicate);
		if (entityResult.isPresent()) {
			return Optional.of(getMapper().convertToDTO(entityResult.get()));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public TagDTO findDto(Long id) {
		return getMapper().convertToDTO(getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> entityManager.find(entityClass, id)));
	}
}
