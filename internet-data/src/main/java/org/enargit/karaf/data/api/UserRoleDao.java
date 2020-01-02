package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.UserRoleDTO;
import org.enargit.karaf.core.entities.UserRole;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.UserRoleMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRoleDao {

    UserRoleMapper getMapper();

    void setMapper(UserRoleMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    UserRole find(Long id);

    UserRoleDTO findDto(Long id);

    List<UserRole> findAll();

    List<UserRoleDTO> findAllDto();

    void persist(UserRole entity);

    UserRole merge(UserRole entity);

    UserRoleDTO merge(UserRoleDTO dto);

    UserRole save(UserRole entity);

    UserRoleDTO save(UserRoleDTO dto);

    UserRoleDTO create(UserRoleDTO dto);

    UserRole create(UserRole entity);

    void delete(Long id);

    List<UserRole> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<UserRoleDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<UserRole> findAll(Pageable pageable);

    Page<UserRoleDTO> findAllDto(Pageable pageable);

    Page<UserRole> findAll(Pageable pageable, Predicate predicate);

    Page<UserRoleDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<UserRole> findAllByPredicate(Predicate predicate);

    List<UserRoleDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<UserRole> entities);

    List<UserRole> saveAll(List<UserRole> entities);

    List<UserRoleDTO> saveAllDto(List<UserRoleDTO> dtos);

    Set<UserRole> saveAll(Set<UserRole> entities);

    Set<UserRoleDTO> saveAllDto(Set<UserRoleDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<UserRole> findOne(Predicate predicate);

    Optional<UserRoleDTO> findOneDto(Predicate predicate);
}
