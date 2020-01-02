package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.RoleDTO;
import org.enargit.karaf.core.entities.Role;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.RoleMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoleDao {

    RoleMapper getMapper();

    void setMapper(RoleMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    Role find(Long id);

    RoleDTO findDto(Long id);

    List<Role> findAll();

    List<RoleDTO> findAllDto();

    void persist(Role entity);

    Role merge(Role entity);

    RoleDTO merge(RoleDTO dto);

    Role save(Role entity);

    RoleDTO save(RoleDTO dto);

    RoleDTO create(RoleDTO dto);

    Role create(Role entity);

    void delete(Long id);

    List<Role> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<RoleDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<Role> findAll(Pageable pageable);

    Page<RoleDTO> findAllDto(Pageable pageable);

    Page<Role> findAll(Pageable pageable, Predicate predicate);

    Page<RoleDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<Role> findAllByPredicate(Predicate predicate);

    List<RoleDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<Role> entities);

    List<Role> saveAll(List<Role> entities);

    List<RoleDTO> saveAllDto(List<RoleDTO> dtos);

    Set<Role> saveAll(Set<Role> entities);

    Set<RoleDTO> saveAllDto(Set<RoleDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<Role> findOne(Predicate predicate);

    Optional<RoleDTO> findOneDto(Predicate predicate);
}
