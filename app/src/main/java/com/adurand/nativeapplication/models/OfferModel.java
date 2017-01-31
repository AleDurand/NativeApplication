package com.adurand.nativeapplication.models;

/**
 * Created by adurand on 31/01/17.
 */

public class OfferModel {

    private Integer id;
    private String description;
    private Double price;
    private String image;

    public OfferModel() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
