package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.FormFieldMappingDTO;
import org.enargit.karaf.core.entities.FormFieldMapping;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.FormFieldMappingMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FormFieldMappingDao {

    FormFieldMappingMapper getMapper();

    void setMapper(FormFieldMappingMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    FormFieldMapping find(Long id);

    FormFieldMappingDTO findDto(Long id);

    List<FormFieldMapping> findAll();

    List<FormFieldMappingDTO> findAllDto();

    void persist(FormFieldMapping entity);

    FormFieldMapping merge(FormFieldMapping entity);

    FormFieldMappingDTO merge(FormFieldMappingDTO dto);

    FormFieldMapping save(FormFieldMapping entity);

    FormFieldMappingDTO save(FormFieldMappingDTO dto);

    FormFieldMappingDTO create(FormFieldMappingDTO dto);

    FormFieldMapping create(FormFieldMapping entity);

    void delete(Long id);

    List<FormFieldMapping> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<FormFieldMappingDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<FormFieldMapping> findAll(Pageable pageable);

    Page<FormFieldMappingDTO> findAllDto(Pageable pageable);

    Page<FormFieldMapping> findAll(Pageable pageable, Predicate predicate);

    Page<FormFieldMappingDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<FormFieldMapping> findAllByPredicate(Predicate predicate);

    List<FormFieldMappingDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<FormFieldMapping> entities);

    List<FormFieldMapping> saveAll(List<FormFieldMapping> entities);

    List<FormFieldMappingDTO> saveAllDto(List<FormFieldMappingDTO> dtos);

    Set<FormFieldMapping> saveAll(Set<FormFieldMapping> entities);

    Set<FormFieldMappingDTO> saveAllDto(Set<FormFieldMappingDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<FormFieldMapping> findOne(Predicate predicate);

    Optional<FormFieldMappingDTO> findOneDto(Predicate predicate);
}
