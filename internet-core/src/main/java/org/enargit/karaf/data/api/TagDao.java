package org.enargit.karaf.data.api;

import org.enargit.karaf.data.dto.TagDto;
import org.enargit.karaf.data.entities.Tag;
import org.enargit.karaf.data.entities.querydsl.QTag;
import org.enargit.karaf.data.mapper.api.TagMapper;

public interface TagDao extends BasicDao<Tag, TagDto, Long, QTag, TagMapper> {
    TagMapper getMapper();

    void setMapper(TagMapper mapper);
}
