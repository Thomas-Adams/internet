package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.CategoryDTO;
import org.enargit.karaf.core.entities.Category;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class CategoryDTOToCategoryConverter extends AbstractConverter<CategoryDTO, Category> {
    private int level;

    public CategoryDTOToCategoryConverter(int level) {
        this.level = level;
    }

    public CategoryDTOToCategoryConverter() {
        this.level = 0;
    }

    @Override
    protected Category convert(CategoryDTO source) {
        return Category.builder().attributes(new ArrayList<>())
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion()).build();
    }
}
