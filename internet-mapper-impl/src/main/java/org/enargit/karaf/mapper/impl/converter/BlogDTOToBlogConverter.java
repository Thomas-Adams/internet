package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.BlogDTO;
import org.enargit.karaf.core.entities.Blog;
import org.modelmapper.AbstractConverter;

public class BlogDTOToBlogConverter extends AbstractConverter<BlogDTO,Blog> {

    private int level;

    public BlogDTOToBlogConverter(int level) {
        this.level = level;
    }

    public BlogDTOToBlogConverter() {
        this.level = 0;
    }

    @Override
    protected Blog convert(BlogDTO source) {
        return Blog.builder().id(source.getId())
                .author(source.getAuthor())
                .summary(source.getSummary())
                .text(source.getText())
                .title(source.getTitle())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion()).build();
    }
}
