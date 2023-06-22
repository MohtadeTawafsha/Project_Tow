package com.example.project_tow;

public class ListItems {
    public String name;
    public String description;
    public int image;

    public ListItems(String name, String description,int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
