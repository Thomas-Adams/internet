package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.ProfileDTO;
import org.enargit.karaf.core.entities.Profile;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.ProfileMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProfileDao {

    ProfileMapper getMapper();

    void setMapper(ProfileMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    Profile find(Long id);

    ProfileDTO findDto(Long id);

    List<Profile> findAll();

    List<ProfileDTO> findAllDto();

    void persist(Profile entity);

    Profile merge(Profile entity);

    ProfileDTO merge(ProfileDTO dto);

    Profile save(Profile entity);

    ProfileDTO save(ProfileDTO dto);

    ProfileDTO create(ProfileDTO dto);

    Profile create(Profile entity);

    void delete(Long id);

    List<Profile> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<ProfileDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<Profile> findAll(Pageable pageable);

    Page<ProfileDTO> findAllDto(Pageable pageable);

    Page<Profile> findAll(Pageable pageable, Predicate predicate);

    Page<ProfileDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<Profile> findAllByPredicate(Predicate predicate);

    List<ProfileDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<Profile> entities);

    List<Profile> saveAll(List<Profile> entities);

    List<ProfileDTO> saveAllDto(List<ProfileDTO> dtos);

    Set<Profile> saveAll(Set<Profile> entities);

    Set<ProfileDTO> saveAllDto(Set<ProfileDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<Profile> findOne(Predicate predicate);

    Optional<ProfileDTO> findOneDto(Predicate predicate);
}
