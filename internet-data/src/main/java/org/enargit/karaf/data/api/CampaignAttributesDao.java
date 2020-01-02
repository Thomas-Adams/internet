package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.CampaignAttributesDTO;
import org.enargit.karaf.core.entities.CampaignAttributes;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.CampaignAttributesMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CampaignAttributesDao {

    CampaignAttributesMapper getMapper();

    void setMapper(CampaignAttributesMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    CampaignAttributes find(Long id);

    CampaignAttributesDTO findDto(Long id);

    List<CampaignAttributes> findAll();

    List<CampaignAttributesDTO> findAllDto();

    void persist(CampaignAttributes entity);

    CampaignAttributes merge(CampaignAttributes entity);

    CampaignAttributesDTO merge(CampaignAttributesDTO dto);

    CampaignAttributes save(CampaignAttributes entity);

    CampaignAttributesDTO save(CampaignAttributesDTO dto);

    CampaignAttributesDTO create(CampaignAttributesDTO dto);

    CampaignAttributes create(CampaignAttributes entity);

    void delete(Long id);

    List<CampaignAttributes> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<CampaignAttributesDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<CampaignAttributes> findAll(Pageable pageable);

    Page<CampaignAttributesDTO> findAllDto(Pageable pageable);

    Page<CampaignAttributes> findAll(Pageable pageable, Predicate predicate);

    Page<CampaignAttributesDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<CampaignAttributes> findAllByPredicate(Predicate predicate);

    List<CampaignAttributesDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<CampaignAttributes> entities);

    List<CampaignAttributes> saveAll(List<CampaignAttributes> entities);

    List<CampaignAttributesDTO> saveAllDto(List<CampaignAttributesDTO> dtos);

    Set<CampaignAttributes> saveAll(Set<CampaignAttributes> entities);

    Set<CampaignAttributesDTO> saveAllDto(Set<CampaignAttributesDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<CampaignAttributes> findOne(Predicate predicate);

    Optional<CampaignAttributesDTO> findOneDto(Predicate predicate);
}
