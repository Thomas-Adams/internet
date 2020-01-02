package org.enargit.karaf.data.api;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.enargit.karaf.core.dto.WidgetDTO;
import org.enargit.karaf.core.entities.Widget;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.Pageable;
import org.enargit.karaf.mapper.api.WidgetMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface WidgetDao {

    WidgetMapper getMapper();

    void setMapper(WidgetMapper mapper);

    JpaTemplate getJpaTemplate();

    void setJpaTemplate(JpaTemplate jpaTemplate);

    Widget find(Long id);

    WidgetDTO findDto(Long id);

    List<Widget> findAll();

    List<WidgetDTO> findAllDto();

    void persist(Widget entity);

    Widget merge(Widget entity);

    WidgetDTO merge(WidgetDTO dto);

    Widget save(Widget entity);

    WidgetDTO save(WidgetDTO dto);

    WidgetDTO create(WidgetDTO dto);

    Widget create(Widget entity);

    void delete(Long id);

    List<Widget> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    List<WidgetDTO> findAllDto(Predicate predicate, OrderSpecifier<?>... orderSpecifiers);

    Page<Widget> findAll(Pageable pageable);

    Page<WidgetDTO> findAllDto(Pageable pageable);

    Page<Widget> findAll(Pageable pageable, Predicate predicate);

    Page<WidgetDTO> findAllDto(Pageable pageable, Predicate predicate);

    List<Widget> findAllByPredicate(Predicate predicate);

    List<WidgetDTO> findAllDtoByPredicate(Predicate predicate);

    void deleteInBatch(Iterable<Widget> entities);

    List<Widget> saveAll(List<Widget> entities);

    List<WidgetDTO> saveAllDto(List<WidgetDTO> dtos);

    Set<Widget> saveAll(Set<Widget> entities);

    Set<WidgetDTO> saveAllDto(Set<WidgetDTO> dtos);

    long count();

    long count(Predicate predicate);

    boolean exists(Predicate predicate);

    boolean exists(Long id);

    Optional<Widget> findOne(Predicate predicate);

    Optional<WidgetDTO> findOneDto(Predicate predicate);
}
