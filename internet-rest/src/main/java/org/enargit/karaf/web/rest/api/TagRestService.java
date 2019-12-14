package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.data.dao.api.TagDao;
import org.enargit.karaf.data.dto.TagDto;
import org.enargit.karaf.data.entities.Tag;
import org.enargit.karaf.data.entities.querydsl.QTag;

import java.util.List;

public interface TagRestService extends BasicRestService<Tag,TagDto, TagDao, QTag, Long> {

    static String PATH_PREFIX = "/tags";


    List<TagDto> getAll();

    TagDto getById(String id);

    TagDto update( String id, TagDto entity);

    TagDto create(TagDto entity);

    TagDto deleteById(String id);
}
