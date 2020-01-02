package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.CategoryDTO;
import org.enargit.karaf.core.entities.Category;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.CategoryMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CategoryDao {

    CategoryMapper getMapper();

    void setMapper(CategoryMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    Category find(Long id);

    CategoryDTO findDto(Long id);

    List<Category> findAll();

    List<CategoryDTO> findAllDto();

    void persist(Category entity);

    Category merge(Category entity);

    CategoryDTO merge(CategoryDTO dto);

    Category save(Category entity);

    CategoryDTO save(CategoryDTO dto);

    CategoryDTO create(CategoryDTO dto);

    Category create(Category entity);

    void delete(Long id);

    List<Category> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<CategoryDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<Category> findAll(Pageable pageable);

    Page<CategoryDTO> findAllDto(Pageable pageable);

    Page<Category> findAll(Pageable pageable, Predicate predicate);

    Page<CategoryDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<Category> findAllByPredicate(Predicate predicate);

    List<CategoryDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<Category> entities);

    List<Category> saveAll(List<Category> entities);

    List<CategoryDTO> saveAllDto(List<CategoryDTO> dtos);

    Set<Category> saveAll(Set<Category> entities);

    Set<CategoryDTO> saveAllDto(Set<CategoryDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<Category> findOne(Predicate predicate);

    Optional<CategoryDTO> findOneDto(Predicate predicate);
}
