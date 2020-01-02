package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.AttributeDTO;
import org.enargit.karaf.core.entities.Attribute;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.AttributeMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AttributeDao {

    AttributeMapper getMapper();

    void setMapper(AttributeMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    Attribute find(Long id);

    AttributeDTO findDto(Long id);

    List<Attribute> findAll();

    List<AttributeDTO> findAllDto();

    void persist(Attribute entity);

    Attribute merge(Attribute entity);

    AttributeDTO merge(AttributeDTO dto);

    Attribute save(Attribute entity);

    AttributeDTO save(AttributeDTO dto);

    AttributeDTO create(AttributeDTO dto);

    Attribute create(Attribute entity);

    void delete(Long id);

    List<Attribute> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<AttributeDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<Attribute> findAll(Pageable pageable);

    Page<AttributeDTO> findAllDto(Pageable pageable);

    Page<Attribute> findAll(Pageable pageable, Predicate predicate);

    Page<AttributeDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<Attribute> findAllByPredicate(Predicate predicate);

    List<AttributeDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<Attribute> entities);

    List<Attribute> saveAll(List<Attribute> entities);

    List<AttributeDTO> saveAllDto(List<AttributeDTO> dtos);

    Set<Attribute> saveAll(Set<Attribute> entities);

    Set<AttributeDTO> saveAllDto(Set<AttributeDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<Attribute> findOne(Predicate predicate);

    Optional<AttributeDTO> findOneDto(Predicate predicate);
}
