package org.enargit.karaf.core.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;
import java.util.Date;

public class JodaDateTimeSerializer extends JsonSerializer<Date> {

    private static final DateTimeFormatter DATE_FORMATTER =
            ISODateTimeFormat.dateTime();


    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(DATE_FORMATTER.print(value.getTime()));
    }
}
