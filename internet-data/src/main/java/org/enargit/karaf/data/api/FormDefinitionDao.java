package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.FormDefinitionDTO;
import org.enargit.karaf.core.entities.FormDefinition;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.FormDefinitionMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FormDefinitionDao {

    FormDefinitionMapper getMapper();

    void setMapper(FormDefinitionMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    FormDefinition find(Long id);

    FormDefinitionDTO findDto(Long id);

    List<FormDefinition> findAll();

    List<FormDefinitionDTO> findAllDto();

    void persist(FormDefinition entity);

    FormDefinition merge(FormDefinition entity);

    FormDefinitionDTO merge(FormDefinitionDTO dto);

    FormDefinition save(FormDefinition entity);

    FormDefinitionDTO save(FormDefinitionDTO dto);

    FormDefinitionDTO create(FormDefinitionDTO dto);

    FormDefinition create(FormDefinition entity);

    void delete(Long id);

    List<FormDefinition> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<FormDefinitionDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<FormDefinition> findAll(Pageable pageable);

    Page<FormDefinitionDTO> findAllDto(Pageable pageable);

    Page<FormDefinition> findAll(Pageable pageable, Predicate predicate);

    Page<FormDefinitionDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<FormDefinition> findAllByPredicate(Predicate predicate);

    List<FormDefinitionDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<FormDefinition> entities);

    List<FormDefinition> saveAll(List<FormDefinition> entities);

    List<FormDefinitionDTO> saveAllDto(List<FormDefinitionDTO> dtos);

    Set<FormDefinition> saveAll(Set<FormDefinition> entities);

    Set<FormDefinitionDTO> saveAllDto(Set<FormDefinitionDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<FormDefinition> findOne(Predicate predicate);

    Optional<FormDefinitionDTO> findOneDto(Predicate predicate);
}
