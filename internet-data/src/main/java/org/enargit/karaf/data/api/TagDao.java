package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.TagDTO;
import org.enargit.karaf.core.entities.Tag;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.TagMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TagDao {

    TagMapper getMapper();

    void setMapper(TagMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    Tag find(Long id);

    TagDTO findDto(Long id);

    List<Tag> findAll();

    List<TagDTO> findAllDto();

    void persist(Tag entity);

    Tag merge(Tag entity);

    TagDTO merge(TagDTO dto);

    Tag save(Tag entity);

    TagDTO save(TagDTO dto);

    TagDTO create(TagDTO dto);

    Tag create(Tag entity);

    void delete(Long id);

    List<Tag> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<TagDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<Tag> findAll(Pageable pageable);

    Page<TagDTO> findAllDto(Pageable pageable);

    Page<Tag> findAll(Pageable pageable, Predicate predicate);

    Page<TagDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<Tag> findAllByPredicate(Predicate predicate);

    List<TagDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<Tag> entities);

    List<Tag> saveAll(List<Tag> entities);

    List<TagDTO> saveAllDto(List<TagDTO> dtos);

    Set<Tag> saveAll(Set<Tag> entities);

    Set<TagDTO> saveAllDto(Set<TagDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<Tag> findOne(Predicate predicate);

    Optional<TagDTO> findOneDto(Predicate predicate);
}
