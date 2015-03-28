package com.tuckshopspotter.ShopDTO;

/**
 * Created by CodeTribe on 2015-03-15.
 */
public class ShopDTO {
    private static final long serialVersionUID = 1l;
    private final String inventory;
    private Integer shopID, InventoryID;
    private String shopname;
    private Double latitude;
    private Double longitude;



//   public ShopDTO(int i, String shopname, String inventory, double latitude, double longitude) {
//   }

    public ShopDTO(String shopname,String inventory, Double latitude, Double longitude) {

        this.shopname = shopname;
        this.inventory = inventory;
        this.latitude = latitude;
        this.longitude = longitude;


    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Override
    public String toString() {
        return "ShopDTO{" +
                ", shopID=" + shopID +
                ", shoopname='" + shopname + '\'' +
                ",inventory='" +inventory+ '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public Integer getShopID() {
        return shopID;
    }

    public void setShopID(Integer shopID) {
        this.shopID = shopID;
    }

    public Integer getInventoryID() {
        return InventoryID;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventoryID(Integer inventoryID) {
        InventoryID = inventoryID;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
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



}