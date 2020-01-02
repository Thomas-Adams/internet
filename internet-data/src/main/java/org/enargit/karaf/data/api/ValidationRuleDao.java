package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.ValidationRuleDTO;
import org.enargit.karaf.core.entities.ValidationRule;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.ValidationRuleMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ValidationRuleDao {

    ValidationRuleMapper getMapper();

    void setMapper(ValidationRuleMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    ValidationRule find(Long id);

    ValidationRuleDTO findDto(Long id);

    List<ValidationRule> findAll();

    List<ValidationRuleDTO> findAllDto();

    void persist(ValidationRule entity);

    ValidationRule merge(ValidationRule entity);

    ValidationRuleDTO merge(ValidationRuleDTO dto);

    ValidationRule save(ValidationRule entity);

    ValidationRuleDTO save(ValidationRuleDTO dto);

    ValidationRuleDTO create(ValidationRuleDTO dto);

    ValidationRule create(ValidationRule entity);

    void delete(Long id);

    List<ValidationRule> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<ValidationRuleDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<ValidationRule> findAll(Pageable pageable);

    Page<ValidationRuleDTO> findAllDto(Pageable pageable);

    Page<ValidationRule> findAll(Pageable pageable, Predicate predicate);

    Page<ValidationRuleDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<ValidationRule> findAllByPredicate(Predicate predicate);

    List<ValidationRuleDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<ValidationRule> entities);

    List<ValidationRule> saveAll(List<ValidationRule> entities);

    List<ValidationRuleDTO> saveAllDto(List<ValidationRuleDTO> dtos);

    Set<ValidationRule> saveAll(Set<ValidationRule> entities);

    Set<ValidationRuleDTO> saveAllDto(Set<ValidationRuleDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<ValidationRule> findOne(Predicate predicate);

    Optional<ValidationRuleDTO> findOneDto(Predicate predicate);
}
