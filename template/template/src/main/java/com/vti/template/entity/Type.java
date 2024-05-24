package com.vti.template.entity;

public enum Type {
    DEV("D"), TEST("T"), PROJECT_MANAGER("P");
    private String sql;

    Type(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return this.sql;
    }

    public static Type toEnum(String sql) {
        for (Type s : Type.values()) {
            if (s.sql.equals(sql)) {
                return s;
            }
        }
        return null;
    }
}
