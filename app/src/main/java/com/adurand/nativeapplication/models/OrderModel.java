package com.adurand.nativeapplication.models;

/**
 * Created by adurand on 31/01/17.
 */
public class OrderModel {

    private Integer id;
    private String name;
    private Integer amount;
    private boolean done;

    public OrderModel() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
