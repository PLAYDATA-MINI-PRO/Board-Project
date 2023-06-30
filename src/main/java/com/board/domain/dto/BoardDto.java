package com.board.domain.dto;

import java.sql.Timestamp;

public class BoardDto {
    private Integer id;
    private String title;
    private String category;
    private String content;
    private String username;

    private String name;
    private Timestamp createAt;

    public BoardDto(Integer id, String title, String category, String content, String username, String name, Timestamp createAt) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.content = content;
        this.username = username;
        this.name = name;
        this.createAt = createAt;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }
}
