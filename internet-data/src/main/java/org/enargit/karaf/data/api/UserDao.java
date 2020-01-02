package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.UserDTO;
import org.enargit.karaf.core.entities.User;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.UserMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserDao {

    UserMapper getMapper();

    void setMapper(UserMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    User find(Long id);

    UserDTO findDto(Long id);

    List<User> findAll();

    List<UserDTO> findAllDto();

    void persist(User entity);

    User merge(User entity);

    UserDTO merge(UserDTO dto);

    User save(User entity);

    UserDTO save(UserDTO dto);

    UserDTO create(UserDTO dto);

    User create(User entity);

    void delete(Long id);

    List<User> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<UserDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<User> findAll(Pageable pageable);

    Page<UserDTO> findAllDto(Pageable pageable);

    Page<User> findAll(Pageable pageable, Predicate predicate);

    Page<UserDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<User> findAllByPredicate(Predicate predicate);

    List<UserDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<User> entities);

    List<User> saveAll(List<User> entities);

    List<UserDTO> saveAllDto(List<UserDTO> dtos);

    Set<User> saveAll(Set<User> entities);

    Set<UserDTO> saveAllDto(Set<UserDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<User> findOne(Predicate predicate);

    Optional<UserDTO> findOneDto(Predicate predicate);
}
