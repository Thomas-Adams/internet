package org.enargit.karaf.data.api;


import org.enargit.karaf.core.dto.TagDto;
import org.enargit.karaf.core.entities.Tag;
import org.enargit.karaf.core.entities.querydsl.QTag;
import org.enargit.karaf.mapper.api.TagMapper;

public interface TagDao extends BasicDao<Tag, TagDto, Long, QTag, TagMapper> {
    TagMapper getMapper();

    void setMapper(TagMapper mapper);
}
