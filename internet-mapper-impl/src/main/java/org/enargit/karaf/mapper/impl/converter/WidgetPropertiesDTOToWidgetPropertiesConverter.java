package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.WidgetPropertiesDTO;
import org.enargit.karaf.core.entities.WidgetProperties;
import org.modelmapper.AbstractConverter;

public class WidgetPropertiesDTOToWidgetPropertiesConverter extends AbstractConverter<WidgetPropertiesDTO, WidgetProperties> {

    private int level;

    public WidgetPropertiesDTOToWidgetPropertiesConverter(int level) {
        this.level = level;
    }

    public WidgetPropertiesDTOToWidgetPropertiesConverter() {
        this.level = 0;
    }

    @Override
    protected WidgetProperties convert(WidgetPropertiesDTO source) {
        WidgetProperties.WidgetPropertiesBuilder builder = WidgetProperties.builder()
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
            builder.widget(new WidgetDTOToWidgetConverter(this.level+1).convert(source.getWidget()));
        }
        return builder.build();
    }
}
