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



    // GETTER
    public String getName() {
        return name;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public int getTimesPurchased() {
        return timesPurchased;
    }


}
