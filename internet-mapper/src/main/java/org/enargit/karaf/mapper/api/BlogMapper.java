package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.BlogDTO;
import org.enargit.karaf.core.entities.Blog;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface BlogMapper extends BaseMapper  {

        List<Blog> convertToEntityList(List<BlogDTO> dtoList);

        List<BlogDTO> convertToDTOList(List<Blog> entityList);

        Set<Blog> convertToEntitySet(Set<BlogDTO> dtoSet);
        
        Set<BlogDTO> convertToDTOSet(Set<Blog> entitySet);

        Blog convertToEntity(BlogDTO dto);

        BlogDTO convertToDTO(Blog entity);

        Page<Blog> convertToEntityPage(Page<BlogDTO> dtoPage);

        Page<BlogDTO> convertToDTOPage(Page<Blog> entityPage);

}
