package org.enargit.karaf.data.impl;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.aries.jpa.template.JpaTemplate;
import org.apache.aries.jpa.template.TransactionType;
import org.enargit.karaf.core.dto.BlogDTO;
import org.enargit.karaf.core.entities.Blog;
import org.enargit.karaf.core.entities.querydsl.QBlog;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.data.api.BlogDao;
import org.enargit.karaf.mapper.api.BlogMapper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component(service = BlogDao.class, immediate = true, name = "BlogDao")
public class BlogDaoImpl implements BlogDao {

	private JpaTemplate jpaTemplate;

	private BlogMapper mapper;

	protected Class<Blog> entityClass;

	protected Class<Long> idClass;

	protected QBlog entityPathBase;

	public JpaTemplate getJpaTemplate() {
		return jpaTemplate;
	}

	@Reference(service = JpaTemplate.class, target = "(osgi.unit.name=internetm_data)")
	public void setJpaTemplate(JpaTemplate jpaTemplate) {
		this.jpaTemplate = jpaTemplate;
	}

	@Override
	public BlogMapper getMapper() {
		return this.mapper;
	}

	@Override
	@Reference(service = BlogMapper.class, target = "(component.name=BlogMapper)")
	public void setMapper(BlogMapper mapper) {
		this.mapper = mapper;
	}

	public BlogDaoImpl() {
		this.entityClass = Blog.class;
		this.entityPathBase = QBlog.blog;
		this.idClass = Long.class;
	}

	@Override
	public Blog find(Long id) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.find(entityClass, id));
	}

	@Override
	public List<Blog> findAll() {
		return getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase).fetch());
	}

	@Override
	public List<BlogDTO> findAllDto() {
		return getMapper().convertToDTOList(findAll());
	}

	@Override
	public void persist(Blog entity) {
		getJpaTemplate().tx(TransactionType.Required, entityManager -> {
			entityManager.persist(entity);
			entityManager.flush();
		});
	}

	@Override
	public Blog merge(Blog entity) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(entity));
	}

	@Override
	public BlogDTO merge(BlogDTO dto) {
		return getMapper().convertToDTO(getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> entityManager.merge(getMapper().convertToEntity(dto))));
	}

	@Override
	public Blog save(Blog entity) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(entity));
	}

	@Override
	public BlogDTO save(BlogDTO dto) {
		return getMapper().convertToDTO(save(getMapper().convertToEntity(dto)));
	}

	@Override
	public Blog create(Blog entity) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(entity));
	}

	@Override
	public BlogDTO create(BlogDTO dto) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(dto));
	}

	@Override
	public void delete(Long id) {
		getJpaTemplate().tx(TransactionType.Required, entityManager -> {
			Blog entity = entityManager.find(entityClass, id);
			if (entity != null) {
				entityManager.remove(entity);
			}
		});
	}

	@Override
	public List<Blog> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> new JPAQueryFactory(entityManager)
				.selectFrom(entityPathBase).where(predicate).orderBy(orderSpecifiers).fetch());
	}

	@Override
	public List<BlogDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers) {
		return getMapper().convertToDTOList(findAll(predicate, orderSpecifiers));
	}

	@Override
	public Page<Blog> findAll(Pageable pageable) {
		List<Blog> result = getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase)
						.offset((pageable.getPageNumber() - 1) * pageable.getPageSize()).limit(pageable.getPageSize())
						.fetch());
		return new PageImpl<Blog>(result);
	}

	@Override
	public Page<BlogDTO> findAllDto(Pageable pageable) {
		return getMapper().convertToDTOPage(findAll(pageable));
	}

	@Override
	public Page<Blog> findAll(Pageable pageable, Predicate predicate) {
		List<Blog> result = getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase).where(predicate)
						.offset((pageable.getPageNumber() - 1) * pageable.getPageSize()).limit(pageable.getPageSize())
						.fetch());
		return new PageImpl<Blog>(result);
	}

	@Override
	public Page<BlogDTO> findAllDto(Pageable pageable, Predicate predicate) {
		return getMapper().convertToDTOPage(findAll(pageable, predicate));
	}

	@Override
	public List<Blog> findAllByPredicate(Predicate predicate) {
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> new JPAQueryFactory(entityManager)
				.selectFrom(entityPathBase).where(predicate).fetch());
	}

	@Override
	public List<BlogDTO> findAllDtoByPredicate(Predicate predicate) {
		return getMapper().convertToDTOList(findAllByPredicate(predicate));
	}

	@Override
	public void deleteInBatch(Iterable<Blog> entities) {
		entities.forEach(e -> getJpaTemplate().tx(entityManager -> {
			entityManager.remove(e);
		}));
	}

	@Override
	public List<Blog> saveAll(List<Blog> entities) {
		return entities.stream()
				.map(e -> getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(e)))
				.collect(Collectors.toList());
	}

	@Override
	public List<BlogDTO> saveAllDto(List<BlogDTO> dtos) {
		return getMapper().convertToDTOList(saveAll(getMapper().convertToEntityList(dtos)));
	}

	@Override
	public Set<Blog> saveAll(Set<Blog> entities) {
		return entities.stream()
				.map(e -> getJpaTemplate().txExpr(TransactionType.Required, entityManager -> entityManager.merge(e)))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<BlogDTO> saveAllDto(Set<BlogDTO> dtos) {
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
		Path<Blog> entityPath = Expressions.path(entityClass, "entity");
		Path<Long> entityId = Expressions.path(idClass, entityPath, "id");
		Expression<Long> constant = Expressions.constant(id);
		return getJpaTemplate().txExpr(TransactionType.Required, entityManager -> new JPAQueryFactory(entityManager)
				.selectFrom(entityPathBase).where(Expressions.predicate(Ops.EQ, entityId, constant)).fetchCount()) > 0;
	}

	@Override
	public Optional<Blog> findOne(Predicate predicate) {
		Blog result = getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> new JPAQueryFactory(entityManager).selectFrom(entityPathBase).where(predicate)
						.fetchOne());
		return Optional.of(result);
	}

	@Override
	public Optional<BlogDTO> findOneDto(Predicate predicate) {
		Optional<Blog> entityResult = findOne(predicate);
		if (entityResult.isPresent()) {
			return Optional.of(getMapper().convertToDTO(entityResult.get()));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public BlogDTO findDto(Long id) {
		return getMapper().convertToDTO(getJpaTemplate().txExpr(TransactionType.Required,
				entityManager -> entityManager.find(entityClass, id)));
	}
}
