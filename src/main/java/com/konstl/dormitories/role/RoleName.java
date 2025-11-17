package com.konstl.dormitories.role;

public enum RoleName {

    admin,
    header,
    resident,
    employee;

    public String getAuthority() {
        return "ROLE_" + name().toUpperCase();
    }
}
