package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.BlogDTO;
import org.enargit.karaf.core.entities.Blog;
import org.modelmapper.AbstractConverter;

public class BlogToBlogDTOConverter extends AbstractConverter<Blog, BlogDTO> {

    private int level;

    public BlogToBlogDTOConverter(int level) {
        this.level = level;
    }

    public BlogToBlogDTOConverter() {
        this.level = 0;
    }

    @Override
    protected BlogDTO convert(Blog source) {
        return BlogDTO.builder().id(source.getId())
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
