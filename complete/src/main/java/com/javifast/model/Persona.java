package com.javifast.model;

public class Persona {

    private final long id;
    private final String content;

    public Persona(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
