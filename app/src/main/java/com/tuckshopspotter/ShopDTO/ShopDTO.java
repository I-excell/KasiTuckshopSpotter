package com.tuckshopspotter.ShopDTO;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by CodeTribe on 2015-03-15.
 */
public class ShopDTO implements Serializable{
    private Integer shopID;
    private String shopname;
    private String inventory;
    private Double latitude;
    private Double longitude;
    private String photourl;
    private Date dateTaken;


    public ShopDTO(int i, String shopname, String inventory, Double latitude, Double longitude, String photourl) {
    }

    public ShopDTO(Integer shopID, String shopname, String inventory, Double latitude, Double longitude) {
        this.shopID = shopID;
        this.shopname = shopname;
        this.inventory = inventory;
        this.latitude = latitude;
        this.longitude = longitude;
        this.photourl = photourl;
        this.dateTaken = dateTaken;
    }

    public Integer getShopID() {
        return shopID;
    }

    public void setShopID(Integer shopID) {
        this.shopID = shopID;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }
}