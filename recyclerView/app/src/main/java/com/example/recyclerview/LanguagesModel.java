package com.example.recyclerview;

public class LanguagesModel {
    String programmingLanguage;
    String description;
    int image;

    public LanguagesModel(String programmingLanguage,
                          String description,
                          int image){
        this.programmingLanguage = programmingLanguage;
        this.description = description;
        this.image = image;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }
}
