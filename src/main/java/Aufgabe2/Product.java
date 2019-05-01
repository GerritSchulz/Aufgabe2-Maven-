package Aufgabe2;

import java.math.BigDecimal;

public class Product {

    private String name;
    private String countryOfOrigin;
    private BigDecimal price;
    private boolean isFragile;
    private int timesPurchased;


    public Product(String name, String countryOfOrigin, String priceValue, boolean isFragile, int timesPurchased){
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.price = new BigDecimal(priceValue);
        this.isFragile = isFragile;
        this.timesPurchased = timesPurchased;
    }



    // GETTER and SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }

    public int getTimesPurchased() {
        return timesPurchased;
    }

    public void setTimesPurchased(int timesPurchased) {
        this.timesPurchased = timesPurchased;
    }
}
