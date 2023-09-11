package com.codingdojo.Fruity;

public class Models {
    private String name;
    private double price;

    public Models(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
