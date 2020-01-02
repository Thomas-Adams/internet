package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.WidgetPropertiesDTO;
import org.enargit.karaf.core.entities.WidgetProperties;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.WidgetPropertiesMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface WidgetPropertiesDao {

    WidgetPropertiesMapper getMapper();

    void setMapper(WidgetPropertiesMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    WidgetProperties find(Long id);

    WidgetPropertiesDTO findDto(Long id);

    List<WidgetProperties> findAll();

    List<WidgetPropertiesDTO> findAllDto();

    void persist(WidgetProperties entity);

    WidgetProperties merge(WidgetProperties entity);

    WidgetPropertiesDTO merge(WidgetPropertiesDTO dto);

    WidgetProperties save(WidgetProperties entity);

    WidgetPropertiesDTO save(WidgetPropertiesDTO dto);

    WidgetPropertiesDTO create(WidgetPropertiesDTO dto);

    WidgetProperties create(WidgetProperties entity);

    void delete(Long id);

    List<WidgetProperties> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<WidgetPropertiesDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<WidgetProperties> findAll(Pageable pageable);

    Page<WidgetPropertiesDTO> findAllDto(Pageable pageable);

    Page<WidgetProperties> findAll(Pageable pageable, Predicate predicate);

    Page<WidgetPropertiesDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<WidgetProperties> findAllByPredicate(Predicate predicate);

    List<WidgetPropertiesDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<WidgetProperties> entities);

    List<WidgetProperties> saveAll(List<WidgetProperties> entities);

    List<WidgetPropertiesDTO> saveAllDto(List<WidgetPropertiesDTO> dtos);

    Set<WidgetProperties> saveAll(Set<WidgetProperties> entities);

    Set<WidgetPropertiesDTO> saveAllDto(Set<WidgetPropertiesDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<WidgetProperties> findOne(Predicate predicate);

    Optional<WidgetPropertiesDTO> findOneDto(Predicate predicate);
}
