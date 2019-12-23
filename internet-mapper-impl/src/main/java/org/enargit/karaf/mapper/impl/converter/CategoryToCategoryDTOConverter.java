package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.CategoryDTO;
import org.enargit.karaf.core.entities.Category;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class CategoryToCategoryDTOConverter extends AbstractConverter<Category, CategoryDTO> {
    private int level;

    public CategoryToCategoryDTOConverter(int level) {
        this.level = level;
    }

    public CategoryToCategoryDTOConverter() {
        this.level = 0;
    }

    @Override
    protected CategoryDTO convert(Category source) {
        return CategoryDTO.builder().attributes(new ArrayList<>())
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
