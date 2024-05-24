package com.vti.testing.converter;

import com.vti.testing.entity.Type;

import javax.persistence.AttributeConverter;

public class DepartmentTypeConverter implements AttributeConverter<Type, String> {

    @Override
    public String convertToDatabaseColumn(Type type) {
        return type.getSql();
    }

    @Override
    public Type convertToEntityAttribute(String s) {
        return Type.toEnum(s);
    }
}
