package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.SelectionListDTO;
import org.enargit.karaf.core.entities.SelectionList;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.SelectionListMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SelectionListDao {

    SelectionListMapper getMapper();

    void setMapper(SelectionListMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    SelectionList find(Long id);

    SelectionListDTO findDto(Long id);

    List<SelectionList> findAll();

    List<SelectionListDTO> findAllDto();

    void persist(SelectionList entity);

    SelectionList merge(SelectionList entity);

    SelectionListDTO merge(SelectionListDTO dto);

    SelectionList save(SelectionList entity);

    SelectionListDTO save(SelectionListDTO dto);

    SelectionListDTO create(SelectionListDTO dto);

    SelectionList create(SelectionList entity);

    void delete(Long id);

    List<SelectionList> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<SelectionListDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<SelectionList> findAll(Pageable pageable);

    Page<SelectionListDTO> findAllDto(Pageable pageable);

    Page<SelectionList> findAll(Pageable pageable, Predicate predicate);

    Page<SelectionListDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<SelectionList> findAllByPredicate(Predicate predicate);

    List<SelectionListDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<SelectionList> entities);

    List<SelectionList> saveAll(List<SelectionList> entities);

    List<SelectionListDTO> saveAllDto(List<SelectionListDTO> dtos);

    Set<SelectionList> saveAll(Set<SelectionList> entities);

    Set<SelectionListDTO> saveAllDto(Set<SelectionListDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<SelectionList> findOne(Predicate predicate);

    Optional<SelectionListDTO> findOneDto(Predicate predicate);
}
