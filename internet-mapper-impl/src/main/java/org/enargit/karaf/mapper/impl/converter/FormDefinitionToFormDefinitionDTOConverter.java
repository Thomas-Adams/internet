package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.FormDefinitionDTO;
import org.enargit.karaf.core.entities.FormDefinition;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class FormDefinitionToFormDefinitionDTOConverter extends AbstractConverter<FormDefinition, FormDefinitionDTO> {

    private int level;

    public FormDefinitionToFormDefinitionDTOConverter(int level) {
        this.level = level;
    }

    public FormDefinitionToFormDefinitionDTOConverter() {
        this.level=0;
    }

    @Override
    protected FormDefinitionDTO convert(FormDefinition source) {
        FormDefinitionDTO.FormDefinitionDTOBuilder builder = FormDefinitionDTO.builder()
                .description(source.getDescription())
                .formFields(new ArrayList<>())
                .validationRules(new ArrayList<>())
                .name(source.getName())
                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());
        if(this.level==0) {
            builder.campaign(new CampaignToCampaignDTOConverter(this.level+1).convert(source.getCampaign()));
        }
        return builder.build();
    }
}
