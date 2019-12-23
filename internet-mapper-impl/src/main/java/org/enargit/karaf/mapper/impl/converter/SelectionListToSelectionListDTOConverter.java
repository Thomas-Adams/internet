package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.SelectionListDTO;
import org.enargit.karaf.core.entities.SelectionList;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class SelectionListToSelectionListDTOConverter extends AbstractConverter<SelectionList, SelectionListDTO> {

    private int level;

    public SelectionListToSelectionListDTOConverter(int level) {
        this.level = level;
    }

    public SelectionListToSelectionListDTOConverter() {
        this.level = 0;
    }

    @Override
    protected SelectionListDTO convert(SelectionList source) {
        SelectionListDTO.SelectionListDTOBuilder builder = SelectionListDTO.builder()
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
            builder.attribute(new AttributeToAttributeDTOConverter(this.level + 1).convert(source.getAttribute()));
        }
        return builder.build();
    }
}
