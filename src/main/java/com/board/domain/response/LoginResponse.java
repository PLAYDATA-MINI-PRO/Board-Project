package com.board.domain.response;

import com.board.domain.dto.UserDto;

public class LoginResponse {
    private Integer id;
    private String name;
    private boolean permissoin;
    public LoginResponse(UserDto dto){
        this.id = dto.getId();
        this.name = dto.getName();
        this.permissoin = dto.isPermissoin();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPermissoin() {
        return permissoin;
    }

    public void setPermissoin(boolean permissoin) {
        this.permissoin = permissoin;
    }

    public LoginResponse(Integer id, String name, boolean permissoin) {
        this.id = id;
        this.name = name;
        this.permissoin = permissoin;
    }
}
