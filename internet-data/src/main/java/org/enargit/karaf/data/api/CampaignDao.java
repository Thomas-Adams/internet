package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.CampaignDTO;
import org.enargit.karaf.core.entities.Campaign;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.CampaignMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CampaignDao {

    CampaignMapper getMapper();

    void setMapper(CampaignMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    Campaign find(Long id);

    CampaignDTO findDto(Long id);

    List<Campaign> findAll();

    List<CampaignDTO> findAllDto();

    void persist(Campaign entity);

    Campaign merge(Campaign entity);

    CampaignDTO merge(CampaignDTO dto);

    Campaign save(Campaign entity);

    CampaignDTO save(CampaignDTO dto);

    CampaignDTO create(CampaignDTO dto);

    Campaign create(Campaign entity);

    void delete(Long id);

    List<Campaign> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<CampaignDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<Campaign> findAll(Pageable pageable);

    Page<CampaignDTO> findAllDto(Pageable pageable);

    Page<Campaign> findAll(Pageable pageable, Predicate predicate);

    Page<CampaignDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<Campaign> findAllByPredicate(Predicate predicate);

    List<CampaignDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<Campaign> entities);

    List<Campaign> saveAll(List<Campaign> entities);

    List<CampaignDTO> saveAllDto(List<CampaignDTO> dtos);

    Set<Campaign> saveAll(Set<Campaign> entities);

    Set<CampaignDTO> saveAllDto(Set<CampaignDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<Campaign> findOne(Predicate predicate);

    Optional<CampaignDTO> findOneDto(Predicate predicate);
}
