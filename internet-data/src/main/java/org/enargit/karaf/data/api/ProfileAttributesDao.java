package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.ProfileAttributesDTO;
import org.enargit.karaf.core.entities.ProfileAttributes;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.ProfileAttributesMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProfileAttributesDao {

    ProfileAttributesMapper getMapper();

    void setMapper(ProfileAttributesMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    ProfileAttributes find(Long id);

    ProfileAttributesDTO findDto(Long id);

    List<ProfileAttributes> findAll();

    List<ProfileAttributesDTO> findAllDto();

    void persist(ProfileAttributes entity);

    ProfileAttributes merge(ProfileAttributes entity);

    ProfileAttributesDTO merge(ProfileAttributesDTO dto);

    ProfileAttributes save(ProfileAttributes entity);

    ProfileAttributesDTO save(ProfileAttributesDTO dto);

    ProfileAttributesDTO create(ProfileAttributesDTO dto);

    ProfileAttributes create(ProfileAttributes entity);

    void delete(Long id);

    List<ProfileAttributes> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<ProfileAttributesDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<ProfileAttributes> findAll(Pageable pageable);

    Page<ProfileAttributesDTO> findAllDto(Pageable pageable);

    Page<ProfileAttributes> findAll(Pageable pageable, Predicate predicate);

    Page<ProfileAttributesDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<ProfileAttributes> findAllByPredicate(Predicate predicate);

    List<ProfileAttributesDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<ProfileAttributes> entities);

    List<ProfileAttributes> saveAll(List<ProfileAttributes> entities);

    List<ProfileAttributesDTO> saveAllDto(List<ProfileAttributesDTO> dtos);

    Set<ProfileAttributes> saveAll(Set<ProfileAttributes> entities);

    Set<ProfileAttributesDTO> saveAllDto(Set<ProfileAttributesDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<ProfileAttributes> findOne(Predicate predicate);

    Optional<ProfileAttributesDTO> findOneDto(Predicate predicate);
}
