package com.board.domain.dto;

public class SearchDto {
    private String username;
    private String name;
    private int id;
    private String title;
    private String content;
    private String category;
    private String create_at;


    public SearchDto(String username, String name, int id, String title, String content, String category, String create_at) {
        this.username = username;
        this.name = name;
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.create_at = create_at;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }
}
