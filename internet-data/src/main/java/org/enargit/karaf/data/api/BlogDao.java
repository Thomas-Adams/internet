package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.BlogDTO;
import org.enargit.karaf.core.entities.Blog;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.BlogMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BlogDao {

    BlogMapper getMapper();

    void setMapper(BlogMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    Blog find(Long id);

    BlogDTO findDto(Long id);

    List<Blog> findAll();

    List<BlogDTO> findAllDto();

    void persist(Blog entity);

    Blog merge(Blog entity);

    BlogDTO merge(BlogDTO dto);

    Blog save(Blog entity);

    BlogDTO save(BlogDTO dto);

    BlogDTO create(BlogDTO dto);

    Blog create(Blog entity);

    void delete(Long id);

    List<Blog> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<BlogDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<Blog> findAll(Pageable pageable);

    Page<BlogDTO> findAllDto(Pageable pageable);

    Page<Blog> findAll(Pageable pageable, Predicate predicate);

    Page<BlogDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<Blog> findAllByPredicate(Predicate predicate);

    List<BlogDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<Blog> entities);

    List<Blog> saveAll(List<Blog> entities);

    List<BlogDTO> saveAllDto(List<BlogDTO> dtos);

    Set<Blog> saveAll(Set<Blog> entities);

    Set<BlogDTO> saveAllDto(Set<BlogDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<Blog> findOne(Predicate predicate);

    Optional<BlogDTO> findOneDto(Predicate predicate);
}
