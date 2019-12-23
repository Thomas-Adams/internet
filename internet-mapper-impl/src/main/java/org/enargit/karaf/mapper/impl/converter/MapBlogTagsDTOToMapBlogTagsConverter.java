package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.MapBlogTagsDTO;
import org.enargit.karaf.core.entities.MapBlogTags;
import org.modelmapper.AbstractConverter;

public class MapBlogTagsDTOToMapBlogTagsConverter extends AbstractConverter<MapBlogTagsDTO, MapBlogTags> {

    private int level;

    public MapBlogTagsDTOToMapBlogTagsConverter(int level) {
        this.level = level;
    }

    public MapBlogTagsDTOToMapBlogTagsConverter() {
        this.level = 0;
    }

    @Override
    protected MapBlogTags convert(MapBlogTagsDTO source) {
        MapBlogTags.MapBlogTagsBuilder builder = MapBlogTags.builder()
                .tag(null)
                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());
        if (this.level == 0) {
            builder.blog(new BlogDTOToBlogConverter(this.level + 1).convert(source.getBlog()));
        }
        return builder.build();
    }
}
