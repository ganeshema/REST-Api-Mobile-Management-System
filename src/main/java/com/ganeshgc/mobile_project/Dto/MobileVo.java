package com.ganeshgc.mobile_project.Dto;

public class MobileVo {
    private int mid;
    private String vendor;
    private String color;
    private double price;
    private String description;

    public MobileVo(int mid, String vendor, String color, double price, String description) {
        this.mid = mid;
        this.vendor = vendor;
        this.color = color;
        this.price = price;
        this.description = description;
    }

    public MobileVo() {
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MobileVo{" +
                "mid=" + mid +
                ", vendor='" + vendor + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
