package com.example.todoapp2.dto;


public class TodoDto {
    public TodoDto(Long id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }

    public TodoDto() {
    }

    private Long id;

    private String title;

    private boolean done;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
