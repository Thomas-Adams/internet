package org.enargit.karaf.mapper.impl.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.enargit.karaf.core.dto.AttributeDTO;
import org.enargit.karaf.core.entities.Attribute;
import org.enargit.karaf.core.entities.Category;
import org.enargit.karaf.core.enums.ObjectTypes;
import org.enargit.karaf.core.enums.ValueTypes;
import org.enargit.karaf.core.utils.JsonUtils;
import org.enargit.karaf.mapper.impl.AttributeMapperImpl;
import org.junit.Test;

import java.util.Date;

public class TestAttributeMapperImpl {


    @Test
    public void testAttributeMapperImpl() throws JsonProcessingException {

        Category category = Category.builder().id(1L).name("Category-1")
                .created(new Date()).createdBy("tadams")
                .modified(new Date()).modifiedBy("tadams")
                .description("This is category 1")
                .version(1L).build();


        Attribute attribute = Attribute.builder().id(1L)
                .name("Attribute-1").description("This is attribute 1")
                .created(new Date()).createdBy("tadams")
                .modified(new Date()).modifiedBy("tadams")
                .category(category).title("Attribute No. 1")
                .type(ObjectTypes.PROFILE)
                .valueType(ValueTypes.STRING)
                .version(1L).build();


        AttributeMapperImpl mapper = new AttributeMapperImpl();

        AttributeDTO attributeDTO = mapper.convertToDTO(attribute);

        ObjectMapper objectMapper = JsonUtils.getPrettyObjectMapper();

        System.out.println(objectMapper.writeValueAsString(attributeDTO));



    }

}
