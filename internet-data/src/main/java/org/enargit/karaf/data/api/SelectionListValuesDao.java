package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.SelectionListValuesDTO;
import org.enargit.karaf.core.entities.SelectionListValues;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.SelectionListValuesMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SelectionListValuesDao {

    SelectionListValuesMapper getMapper();

    void setMapper(SelectionListValuesMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    SelectionListValues find(Long id);

    SelectionListValuesDTO findDto(Long id);

    List<SelectionListValues> findAll();

    List<SelectionListValuesDTO> findAllDto();

    void persist(SelectionListValues entity);

    SelectionListValues merge(SelectionListValues entity);

    SelectionListValuesDTO merge(SelectionListValuesDTO dto);

    SelectionListValues save(SelectionListValues entity);

    SelectionListValuesDTO save(SelectionListValuesDTO dto);

    SelectionListValuesDTO create(SelectionListValuesDTO dto);

    SelectionListValues create(SelectionListValues entity);

    void delete(Long id);

    List<SelectionListValues> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<SelectionListValuesDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<SelectionListValues> findAll(Pageable pageable);

    Page<SelectionListValuesDTO> findAllDto(Pageable pageable);

    Page<SelectionListValues> findAll(Pageable pageable, Predicate predicate);

    Page<SelectionListValuesDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<SelectionListValues> findAllByPredicate(Predicate predicate);

    List<SelectionListValuesDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<SelectionListValues> entities);

    List<SelectionListValues> saveAll(List<SelectionListValues> entities);

    List<SelectionListValuesDTO> saveAllDto(List<SelectionListValuesDTO> dtos);

    Set<SelectionListValues> saveAll(Set<SelectionListValues> entities);

    Set<SelectionListValuesDTO> saveAllDto(Set<SelectionListValuesDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<SelectionListValues> findOne(Predicate predicate);

    Optional<SelectionListValuesDTO> findOneDto(Predicate predicate);
}
