package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.SelectionListValuesDTO;
import org.enargit.karaf.core.entities.SelectionListValues;
import org.modelmapper.AbstractConverter;

public class SelectionListValuesDTOToSelectionListValuesConveter extends AbstractConverter<SelectionListValuesDTO,SelectionListValues> {

    private int level;

    public SelectionListValuesDTOToSelectionListValuesConveter(int level) {
        this.level = level;
    }

    public SelectionListValuesDTOToSelectionListValuesConveter() {
        this.level = 0;
    }

    @Override
    protected SelectionListValues convert(SelectionListValuesDTO source) {
        SelectionListValues.SelectionListValuesBuilder builder = SelectionListValues.builder()
                .bigDecimalValue(source.getBigDecimalValue())
                .booleanValue(source.getBooleanValue())
                .dateTimeValue(source.getDateTimeValue())
                .dateValue(source.getDateValue())
                .description(source.getDescription())
                .doubleValue(source.getDoubleValue())
                .floatValue(source.getFloatValue())
                .integerValue(source.getIntegerValue())
                .label(source.getLabel())
                .longValue(source.getLongValue())
                .stringValue(source.getStringValue())
                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());
        if (this.level == 0) {
            builder.selectionList(new SelectionListDTOToSelectionListConverter(this.level + 1).convert(source.getSelectionList()));
        }
        return builder.build();
    }
}
