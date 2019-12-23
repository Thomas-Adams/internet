package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.TagDTO;
import org.enargit.karaf.core.entities.Tag;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface TagMapper extends BaseMapper  {

        List<Tag> convertToEntityList(List<TagDTO> dtoList);

        List<TagDTO> convertToDTOList(List<Tag> entityList);

        Set<Tag> convertToEntitySet(Set<TagDTO> dtoSet);
        
        Set<TagDTO> convertToDTOSet(Set<Tag> entitySet);

        Tag convertToEntity(TagDTO dto);

        TagDTO convertToDTO(Tag entity);

        Page<Tag> convertToEntityPage(Page<TagDTO> dtoPage);

        Page<TagDTO> convertToDTOPage(Page<Tag> entityPage);

}
