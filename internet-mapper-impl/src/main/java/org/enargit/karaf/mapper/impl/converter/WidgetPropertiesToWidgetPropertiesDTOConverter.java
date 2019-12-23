package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.WidgetPropertiesDTO;
import org.enargit.karaf.core.entities.WidgetProperties;
import org.modelmapper.AbstractConverter;

public class WidgetPropertiesToWidgetPropertiesDTOConverter extends AbstractConverter<WidgetProperties, WidgetPropertiesDTO> {

    private int level;

    public WidgetPropertiesToWidgetPropertiesDTOConverter(int level) {
        this.level = level;
    }

    public WidgetPropertiesToWidgetPropertiesDTOConverter() {
        this.level = 0;
    }

    @Override
    protected WidgetPropertiesDTO convert(WidgetProperties source) {
        WidgetPropertiesDTO.WidgetPropertiesDTOBuilder builder = WidgetPropertiesDTO.builder()
                .dataType(source.getDataType())
                .name(source.getName())
                .value(source.getValue())
                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());
        if (this.level == 0) {
            builder.widget(new WidgetToWidgetDTOConverter(this.level+1).convert(source.getWidget()));
        }
        return builder.build();
    }
}
