package org.enargit.karaf.data.enums;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public enum DataTypes {

    STRING(String.class), INT(Integer.class), LONG(Long.class),
    DATE(Date.class), BOOLEAN(Boolean.class), FLOAT(Float.class),
    DOUBLE(Double.class), BIGDECIMAL(BigDecimal.class),
    DATETIME(Timestamp.class);

    private Class<?> clazz;

    DataTypes(Class<?> clazz) {
        this.clazz = clazz;
    }
}
