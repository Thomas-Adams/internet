package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.WidgetDTO;
import org.enargit.karaf.core.entities.Widget;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class WidgetToWidgetDTOConverter extends AbstractConverter<Widget, WidgetDTO> {

    private int level;


    public WidgetToWidgetDTOConverter() {
        this.level = 0;
    }

    public WidgetToWidgetDTOConverter(int level) {
        this.level = level;
    }

    @Override
    protected WidgetDTO convert(Widget source) {
        return WidgetDTO.builder()
                .description(source.getDescription())
                .formFields(new ArrayList<>())
                .name(source.getName())
                .widgetProperties(new ArrayList<>())
                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion()).build();
    }
}
