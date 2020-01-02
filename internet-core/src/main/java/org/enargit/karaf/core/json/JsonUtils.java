package org.enargit.karaf.core.json;

import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtils {


    public static ObjectMapper getPrettyObjectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        PrettyPrinter prettyPrinter = new DefaultPrettyPrinter().withArrayIndenter(new DefaultIndenter("    ", DefaultIndenter.SYS_LF));
        objectMapper.setDefaultPrettyPrinter(prettyPrinter);
        return objectMapper;
    }
}
