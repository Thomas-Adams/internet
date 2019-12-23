package org.enargit.karaf.web.rest.api;

import org.enargit.karaf.core.dto.TagDTO;
import org.enargit.karaf.data.api.TagDao;

import java.util.List;

public interface TagRestService {

    public static String PATH_PREFIX = "/tag";

    void bind(TagDao dao);

    TagDao getDao();

    Long convert(String id);

    List<TagDTO> getAll();

    TagDTO getById(String id);

    TagDTO update(String id, TagDTO entity);

    TagDTO create(TagDTO entity);

    TagDTO deleteById(String id);
}
