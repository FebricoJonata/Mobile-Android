package com.example.sqlite;

public class News {

//    private int ID;
    private int image;
    private String tittle;
    private String description;


    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public News(){}

    public News(int image, String tittle, String description) {
        this.image = image;
        this.tittle = tittle;
        this.description = description;
    }
}
