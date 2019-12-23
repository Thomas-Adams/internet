package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.MapBlogTagsDTO;
import org.enargit.karaf.core.entities.MapBlogTags;
import org.modelmapper.AbstractConverter;

public class MapBlogTagsToMapBlogTagsDTOConverter extends AbstractConverter<MapBlogTags, MapBlogTagsDTO> {

    private int level;

    public MapBlogTagsToMapBlogTagsDTOConverter(int level) {
        this.level = level;
    }

    public MapBlogTagsToMapBlogTagsDTOConverter() {
        this.level = 0;
    }

    @Override
    protected MapBlogTagsDTO convert(MapBlogTags source) {
        MapBlogTagsDTO.MapBlogTagsDTOBuilder builder = MapBlogTagsDTO.builder()
                .tag(null)
                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());
        if (this.level == 0) {
            builder.blog(new BlogToBlogDTOConverter(this.level + 1).convert(source.getBlog()));
        }
        return builder.build();
    }
}
