package org.enargit.karaf.data.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.aries.jpa.template.JpaTemplate;
import org.apache.aries.jpa.template.TransactionType;
import org.enargit.karaf.core.dto.MapBlogTagsDTO;
import org.enargit.karaf.core.entities.MapBlogTags;
import org.enargit.karaf.core.entities.querydsl.QMapBlogTags;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.data.api.MapBlogTagsDao;
import org.enargit.karaf.mapper.api.MapBlogTagsMapper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Component(service = MapBlogTagsDao.class, immediate = true, name = "MapBlogTagsDao")
public class MapBlogTagsDaoImpl implements MapBlogTagsDao {

	private JpaTemplate jpaTemplate;

	private MapBlogTagsMapper mapper;

	protected Class<MapBlogTags> entityClass;

	protected Class<Long> idClass;

	protected QMapBlogTags entityPathBase;

	public JpaTemplate getJpaTemplate() {
		return jpaTemplate;
	}

	@Reference(service = JpaTemplate.class, target = "(osgi.unit.name=internetm_data)")
	public void setJpaTemplate(JpaTemplate jpaTemplate) {
		this.jpaTemplate = jpaTemplate;
	}

	@Override
	public MapBlogTagsMapper getMapper() {
		return this.mapper;
	}

	@Override
	@Reference(service = MapBlogTagsMapper.class, target = "(component.name=MapBlogTagsMapper)")
	public void setMapper(MapBlogTagsMapper mapper) {
		this.mapper = mapper;
	}

	public MapBlogTagsDaoImpl() {
		this.entityClass = MapBlogTags.class;
		this.entityPathBase = QMapBlogTags.mapBlogTags;
		this.idClass = Long.class;
	}

	@Override
	public MapBlogTags find(Long id) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.find(entityClass, id));
	}

	@Override
	public List<MapBlogTags> findAll() {
		return getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase).fetch());
	}

	@Override
	public List<MapBlogTagsDTO> findAllDto() {
		return getMapper().convertToDTOList(findAll());
	}

	@Override
	public void persist(MapBlogTags entity) {
		getJpaTemplate().tx(TransactionType.Required, entityManager -> {
			entityManager.persist(entity);
			entityManager.flush();
		});
	}

	@Override
	public MapBlogTags merge(MapBlogTags entity) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(entity));
	}

	@Override
	public MapBlogTagsDTO merge(MapBlogTagsDTO dto) {
		return getMapper().convertToDTO(getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> entityManager.merge(getMapper().convertToEntity(dto))));
	}

	@Override
	public MapBlogTags save(MapBlogTags entity) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(entity));
	}

	@Override
	public MapBlogTagsDTO save(MapBlogTagsDTO dto) {
		return getMapper().convertToDTO(save(getMapper().convertToEntity(dto)));
	}

	@Override
	public MapBlogTags create(MapBlogTags entity) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(entity));
	}

	@Override
	public MapBlogTagsDTO create(MapBlogTagsDTO dto) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(dto));
	}

	@Override
	public void delete(Long id) {
		getJpaTemplate().tx(TransactionType.Required, entityManager -> {
			MapBlogTags entity = entityManager.find(entityClass, id);
			if (entity != null) {
				entityManager.remove(entity);
			}
		});
	}

	@Override
	public List<MapBlogTags> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> new JPAQueryFactory(entityManager)
				.selectFrom(entityPathBase).where(predicate).orderBy(orderSpecifiers).fetch());
	}

	@Override
	public List<MapBlogTagsDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers) {
		return getMapper().convertToDTOList(findAll(predicate, orderSpecifiers));
	}

	@Override
	public Page<MapBlogTags> findAll(Pageable pageable) {
		List<MapBlogTags> result = getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase)
						.offset((pageable.getPageNumber() - 1) * pageable.getPageSize()).limit(pageable.getPageSize())
						.fetch());
		return new PageImpl<MapBlogTags>(result);
	}

	@Override
	public Page<MapBlogTagsDTO> findAllDto(Pageable pageable) {
		return getMapper().convertToDTOPage(findAll(pageable));
	}

	@Override
	public Page<MapBlogTags> findAll(Pageable pageable, Predicate predicate) {
		List<MapBlogTags> result = getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase).where(predicate)
						.offset((pageable.getPageNumber() - 1) * pageable.getPageSize()).limit(pageable.getPageSize())
						.fetch());
		return new PageImpl<MapBlogTags>(result);
	}

	@Override
	public Page<MapBlogTagsDTO> findAllDto(Pageable pageable, Predicate predicate) {
		return getMapper().convertToDTOPage(findAll(pageable, predicate));
	}

	@Override
	public List<MapBlogTags> findAllByPredicate(Predicate predicate) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> new JPAQueryFactory(entityManager)
				.selectFrom(entityPathBase).where(predicate).fetch());
	}

	@Override
	public List<MapBlogTagsDTO> findAllDtoByPredicate(Predicate predicate) {
		return getMapper().convertToDTOList(findAllByPredicate(predicate));
	}

	@Override
	public void deleteInBatch(Iterable<MapBlogTags> entities) {
		entities.forEach(e -> getJpaTemplate().tx(entityManager -> {
			entityManager.remove(e);
		}));
	}

	@Override
	public List<MapBlogTags> saveAll(List<MapBlogTags> entities) {
		return entities.stream()
				.map(e -> getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(e)))
				.collect(Collectors.toList());
	}

	@Override
	public List<MapBlogTagsDTO> saveAllDto(List<MapBlogTagsDTO> dtos) {
		return getMapper().convertToDTOList(saveAll(getMapper().convertToEntityList(dtos)));
	}

	@Override
	public Set<MapBlogTags> saveAll(Set<MapBlogTags> entities) {
		return entities.stream()
				.map(e -> getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(e)))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<MapBlogTagsDTO> saveAllDto(Set<MapBlogTagsDTO> dtos) {
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
		Path<MapBlogTags> entityPath = Expressions.path(entityClass, "entity");
		Path<Long> entityId = Expressions.path(idClass, entityPath, "id");
		Expression<Long> constant = Expressions.constant(id);
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> new JPAQueryFactory(entityManager)
				.selectFrom(entityPathBase).where(Expressions.predicate(Ops.EQ, entityId, constant)).fetchCount()) > 0;
	}

	@Override
	public Optional<MapBlogTags> findOne(Predicate predicate) {
		MapBlogTags result = getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase).where(predicate)
						.fetchOne());
		return Optional.of(result);
	}

	@Override
	public Optional<MapBlogTagsDTO> findOneDto(Predicate predicate) {
		Optional<MapBlogTags> entityResult = findOne(predicate);
		if (entityResult.isPresent()) {
			return Optional.of(getMapper().convertToDTO(entityResult.get()));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public MapBlogTagsDTO findDto(Long id) {
		return getMapper().convertToDTO(getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> entityManager.find(entityClass, id)));
	}
}
