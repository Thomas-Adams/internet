package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.CategoryDTO;
import org.enargit.karaf.core.entities.Category;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface CategoryMapper extends BaseMapper  {

        List<Category> convertToEntityList(List<CategoryDTO> dtoList);

        List<CategoryDTO> convertToDTOList(List<Category> entityList);

        Set<Category> convertToEntitySet(Set<CategoryDTO> dtoSet);
        
        Set<CategoryDTO> convertToDTOSet(Set<Category> entitySet);

        Category convertToEntity(CategoryDTO dto);

        CategoryDTO convertToDTO(Category entity);

        Page<Category> convertToEntityPage(Page<CategoryDTO> dtoPage);

        Page<CategoryDTO> convertToDTOPage(Page<Category> entityPage);

}
