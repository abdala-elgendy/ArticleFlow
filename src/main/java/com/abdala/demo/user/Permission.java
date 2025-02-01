package com.abdala.demo.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    NORMALUSER_READ("normaluser:read"),
    NORMALUSER_UPDATE("normaluser:update"),
    NORMALUSER_DELETE("normaluser:delete"),
    NORMALUSER_CREATE("normaluser:create");

    ;

    @Getter
    private final String permission;
}
