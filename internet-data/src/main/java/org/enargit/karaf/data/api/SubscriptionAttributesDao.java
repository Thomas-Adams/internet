package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.SubscriptionAttributesDTO;
import org.enargit.karaf.core.entities.SubscriptionAttributes;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.SubscriptionAttributesMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SubscriptionAttributesDao {

    SubscriptionAttributesMapper getMapper();

    void setMapper(SubscriptionAttributesMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    SubscriptionAttributes find(Long id);

    SubscriptionAttributesDTO findDto(Long id);

    List<SubscriptionAttributes> findAll();

    List<SubscriptionAttributesDTO> findAllDto();

    void persist(SubscriptionAttributes entity);

    SubscriptionAttributes merge(SubscriptionAttributes entity);

    SubscriptionAttributesDTO merge(SubscriptionAttributesDTO dto);

    SubscriptionAttributes save(SubscriptionAttributes entity);

    SubscriptionAttributesDTO save(SubscriptionAttributesDTO dto);

    SubscriptionAttributesDTO create(SubscriptionAttributesDTO dto);

    SubscriptionAttributes create(SubscriptionAttributes entity);

    void delete(Long id);

    List<SubscriptionAttributes> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<SubscriptionAttributesDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<SubscriptionAttributes> findAll(Pageable pageable);

    Page<SubscriptionAttributesDTO> findAllDto(Pageable pageable);

    Page<SubscriptionAttributes> findAll(Pageable pageable, Predicate predicate);

    Page<SubscriptionAttributesDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<SubscriptionAttributes> findAllByPredicate(Predicate predicate);

    List<SubscriptionAttributesDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<SubscriptionAttributes> entities);

    List<SubscriptionAttributes> saveAll(List<SubscriptionAttributes> entities);

    List<SubscriptionAttributesDTO> saveAllDto(List<SubscriptionAttributesDTO> dtos);

    Set<SubscriptionAttributes> saveAll(Set<SubscriptionAttributes> entities);

    Set<SubscriptionAttributesDTO> saveAllDto(Set<SubscriptionAttributesDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<SubscriptionAttributes> findOne(Predicate predicate);

    Optional<SubscriptionAttributesDTO> findOneDto(Predicate predicate);
}
