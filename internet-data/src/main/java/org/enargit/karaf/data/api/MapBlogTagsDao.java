package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.MapBlogTagsDTO;
import org.enargit.karaf.core.entities.MapBlogTags;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.MapBlogTagsMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MapBlogTagsDao {

    MapBlogTagsMapper getMapper();

    void setMapper(MapBlogTagsMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    MapBlogTags find(Long id);

    MapBlogTagsDTO findDto(Long id);

    List<MapBlogTags> findAll();

    List<MapBlogTagsDTO> findAllDto();

    void persist(MapBlogTags entity);

    MapBlogTags merge(MapBlogTags entity);

    MapBlogTagsDTO merge(MapBlogTagsDTO dto);

    MapBlogTags save(MapBlogTags entity);

    MapBlogTagsDTO save(MapBlogTagsDTO dto);

    MapBlogTagsDTO create(MapBlogTagsDTO dto);

    MapBlogTags create(MapBlogTags entity);

    void delete(Long id);

    List<MapBlogTags> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<MapBlogTagsDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<MapBlogTags> findAll(Pageable pageable);

    Page<MapBlogTagsDTO> findAllDto(Pageable pageable);

    Page<MapBlogTags> findAll(Pageable pageable, Predicate predicate);

    Page<MapBlogTagsDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<MapBlogTags> findAllByPredicate(Predicate predicate);

    List<MapBlogTagsDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<MapBlogTags> entities);

    List<MapBlogTags> saveAll(List<MapBlogTags> entities);

    List<MapBlogTagsDTO> saveAllDto(List<MapBlogTagsDTO> dtos);

    Set<MapBlogTags> saveAll(Set<MapBlogTags> entities);

    Set<MapBlogTagsDTO> saveAllDto(Set<MapBlogTagsDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<MapBlogTags> findOne(Predicate predicate);

    Optional<MapBlogTagsDTO> findOneDto(Predicate predicate);
}
