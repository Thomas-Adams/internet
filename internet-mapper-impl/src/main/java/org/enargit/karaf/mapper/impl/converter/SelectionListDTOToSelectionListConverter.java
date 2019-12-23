package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.SelectionListDTO;
import org.enargit.karaf.core.entities.SelectionList;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class SelectionListDTOToSelectionListConverter extends AbstractConverter<SelectionListDTO, SelectionList> {

    private int level;

    public SelectionListDTOToSelectionListConverter(int level) {
        this.level = level;
    }

    public SelectionListDTOToSelectionListConverter() {
        this.level = 0;
    }

    @Override
    protected SelectionList convert(SelectionListDTO source) {
        SelectionList.SelectionListBuilder builder = SelectionList.builder()
                .listType(source.getListType())
                .selectionListValues(new ArrayList<>())
                .name(source.getName())
                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());
        if (this.level == 0) {
            builder.attribute(new AttributeDTOToAttributeConverter(this.level + 1).convert(source.getAttribute()));
        }
        return builder.build();
    }
}
