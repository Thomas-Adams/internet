package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.TagDto;
import org.enargit.karaf.core.entities.Tag;
import org.enargit.karaf.core.entities.querydsl.QTag;
import org.enargit.karaf.data.api.TagDao;
import org.enargit.karaf.mapper.api.TagMapper;

import java.util.List;

public interface TagRestService extends BasicRestService<Tag,TagDto, TagMapper, TagDao, QTag, Long> {

    static String PATH_PREFIX = "/tags";


    List<TagDto> getAll();

    TagDto getById(String id);

    TagDto update( String id, TagDto entity);

    TagDto create(TagDto entity);

    TagDto deleteById(String id);
}
