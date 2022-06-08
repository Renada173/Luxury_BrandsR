package com.example.luxury_brands;

enum sogProduct
{
    womenShoes ,menShoes, menAccess,womenAccess, menTshirts, womenDresses;
}

public class Product {

    private String ProductName;
    private String description;
    private String address;
    private String phone;
    private sogProduct sog;
    private String photo;

    public Product(String productName, String description, String address, String phone, sogProduct sog, String photo) {
        ProductName = productName;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.sog = sog;
        this.photo = photo;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public sogProduct getSog() {
        return sog;
    }

    public String getPhoto() {
        return photo;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSog(sogProduct sog) {
        this.sog = sog;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + ProductName + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", Sog=" + sog +
                ", photo='" + photo + '\'' +
                '}';
    }
}
