package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.FormFieldDTO;
import org.enargit.karaf.core.entities.FormField;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.FormFieldMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FormFieldDao {

    FormFieldMapper getMapper();

    void setMapper(FormFieldMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    FormField find(Long id);

    FormFieldDTO findDto(Long id);

    List<FormField> findAll();

    List<FormFieldDTO> findAllDto();

    void persist(FormField entity);

    FormField merge(FormField entity);

    FormFieldDTO merge(FormFieldDTO dto);

    FormField save(FormField entity);

    FormFieldDTO save(FormFieldDTO dto);

    FormFieldDTO create(FormFieldDTO dto);

    FormField create(FormField entity);

    void delete(Long id);

    List<FormField> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<FormFieldDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<FormField> findAll(Pageable pageable);

    Page<FormFieldDTO> findAllDto(Pageable pageable);

    Page<FormField> findAll(Pageable pageable, Predicate predicate);

    Page<FormFieldDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<FormField> findAllByPredicate(Predicate predicate);

    List<FormFieldDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<FormField> entities);

    List<FormField> saveAll(List<FormField> entities);

    List<FormFieldDTO> saveAllDto(List<FormFieldDTO> dtos);

    Set<FormField> saveAll(Set<FormField> entities);

    Set<FormFieldDTO> saveAllDto(Set<FormFieldDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<FormField> findOne(Predicate predicate);

    Optional<FormFieldDTO> findOneDto(Predicate predicate);
}
