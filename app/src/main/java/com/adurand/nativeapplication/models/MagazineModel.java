package com.adurand.nativeapplication.models;

import java.util.Date;
import java.util.List;

/**
 * Created by adurand on 30/01/17.
 */

public class MagazineModel {

    private Integer id;
    private String name;
    private String description;
    private String url;
    private String user;
    private Date initDate;
    private Date endDate;
    private List<MagazineImageModel> images;

    public MagazineModel() {}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<MagazineImageModel> getImages() {
        return images;
    }

    public void setImages(List<MagazineImageModel> images) {
        this.images = images;
    }
}
