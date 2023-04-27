package com.example.recyclerview;

public class Item {
    //image menggunakan tipe data int dikarenakan method getImageResource hanya menerima parameter int
    private int image;
    private String name;
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Item(int image, String name, int quantity) {
        this.image = image;
        this.name = name;
        this.quantity = quantity;
    }
}
