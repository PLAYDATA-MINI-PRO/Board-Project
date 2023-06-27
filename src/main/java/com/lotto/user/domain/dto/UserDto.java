package com.lotto.user.domain.dto;

public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private boolean permission;

    public UserDto(Integer id, String username, String password, String name, boolean permission) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.permission = permission;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }
}
