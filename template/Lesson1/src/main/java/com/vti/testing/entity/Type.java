package com.vti.testing.entity;

public enum Type {
    DEV("D"), TEST("T"), PM("P");
    private String sql;

    Type(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    public static Type toEnum(String sql) {
        for (Type type : Type.values()) {
            if (type.sql.equals(sql)) {
                return type;
            }
        }
        return null;
    }
}
