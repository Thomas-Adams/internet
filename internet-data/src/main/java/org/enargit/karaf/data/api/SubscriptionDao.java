package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.SubscriptionDTO;
import org.enargit.karaf.core.entities.Subscription;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.SubscriptionMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SubscriptionDao {

    SubscriptionMapper getMapper();

    void setMapper(SubscriptionMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    Subscription find(Long id);

    SubscriptionDTO findDto(Long id);

    List<Subscription> findAll();

    List<SubscriptionDTO> findAllDto();

    void persist(Subscription entity);

    Subscription merge(Subscription entity);

    SubscriptionDTO merge(SubscriptionDTO dto);

    Subscription save(Subscription entity);

    SubscriptionDTO save(SubscriptionDTO dto);

    SubscriptionDTO create(SubscriptionDTO dto);

    Subscription create(Subscription entity);

    void delete(Long id);

    List<Subscription> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<SubscriptionDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<Subscription> findAll(Pageable pageable);

    Page<SubscriptionDTO> findAllDto(Pageable pageable);

    Page<Subscription> findAll(Pageable pageable, Predicate predicate);

    Page<SubscriptionDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<Subscription> findAllByPredicate(Predicate predicate);

    List<SubscriptionDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<Subscription> entities);

    List<Subscription> saveAll(List<Subscription> entities);

    List<SubscriptionDTO> saveAllDto(List<SubscriptionDTO> dtos);

    Set<Subscription> saveAll(Set<Subscription> entities);

    Set<SubscriptionDTO> saveAllDto(Set<SubscriptionDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<Subscription> findOne(Predicate predicate);

    Optional<SubscriptionDTO> findOneDto(Predicate predicate);
}
