package com.learn.springsecurity.enumerated;

import static com.learn.springsecurity.enumerated.Permission.ADMIN_CREATE;
import static com.learn.springsecurity.enumerated.Permission.ADMIN_DELETE;
import static com.learn.springsecurity.enumerated.Permission.ADMIN_READ;
import static com.learn.springsecurity.enumerated.Permission.ADMIN_UPDATE;
import static com.learn.springsecurity.enumerated.Permission.USER_CREATE;
import static com.learn.springsecurity.enumerated.Permission.USER_DELETE;
import static com.learn.springsecurity.enumerated.Permission.USER_READ;
import static com.learn.springsecurity.enumerated.Permission.USER_UPDATE;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    ADMIN_CREATE,
                    USER_READ,
                    USER_UPDATE,
                    USER_DELETE,
                    USER_CREATE)),
    USER(
            Set.of(
                    USER_READ,
                    USER_UPDATE,
                    USER_DELETE,
                    USER_CREATE));

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
