package com.vti.template.converter;

import com.vti.template.entity.Type;

import javax.persistence.AttributeConverter;

public class ArticleStatusConverter implements AttributeConverter<Type, String> {
    @Override
    public String convertToDatabaseColumn(Type status) {
        if (status == null) {
            return null;
        }
        return status.getSql();
    }

    @Override
    public Type convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        return Type.toEnum(s);
    }
}
