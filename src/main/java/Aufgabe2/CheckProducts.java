package Aufgabe2;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CheckProducts {

    private static String filepath = Main.jsonFile; // get the Path to the .json file from the Main class
    private static List<Product> productList;

    /**
     * Reads in all data from a .json file and pass them into a list.
     * @param filepath .json Path to the file
     * @return List from type product
     */
    private static List<Product> readFromJSONFile(String filepath){
        final Type PRODUCT_LIST_TYPE= new TypeToken<ArrayList<Product>>(){}.getType();
        Gson gson = new Gson();
        try{
            JsonReader reader = new JsonReader(new FileReader(filepath));
            return gson.fromJson(reader, PRODUCT_LIST_TYPE);
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (JsonParseException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Checks for the given CountryCode (see ISO-3166-2) and collects all products that match with it
     * @param countryCode String with the country code of ISO-3166-2
     * @return ArrayList of countries that matches the countryCode
     */
    public ArrayList<String> checkForCountry (String countryCode) {
        productList = readFromJSONFile(filepath);
        ArrayList<String> temp = new ArrayList<>();
        List<Product> collect = productList.stream().filter(x -> x.getCountryOfOrigin().contentEquals(countryCode)).collect(Collectors.toList());
        for(Product product : collect){
             temp.add(product.getName());
        }
        System.out.println(temp);
        return temp;
    }

    /**
     * Checks for the highest price of all products
     * @return String Name of the product with the highest price
     */
    public String checkForHighestPrice(){
         productList = readFromJSONFile(filepath);
         ArrayList<Float> prices = new ArrayList<Float>();
         float temp = 0.0f;
         String nameOfProductWithHighestPrice = "";
        for (Product product : productList) {
            prices.add(product.getPrice().floatValue());
            if(product.getPrice().floatValue()>temp) {
                temp = product.getPrice().floatValue();
                nameOfProductWithHighestPrice = product.getName();
            }
        }
        //float tempFloat = Collections.max(prices);
        //System.out.println("Liste aller Preise: " + prices + " Höchster Preis: " + Collections.max(prices));// There are more efficient methods to get that value
        return nameOfProductWithHighestPrice;
    }

    /**
     * Checks for the cheapest price of all products
     * @return String Name of the product with the cheapest price
     */
    public String checkForCheapestPrice(){
        productList = readFromJSONFile(filepath);
        ArrayList<Float> prices = new ArrayList<>();
        float temp = 0.0f;
        String nameOfProductWithCheapestPrice = "";
        if (productList != null) { // check if there is an object in the productList...
            temp = productList.get(0).getPrice().floatValue(); // ...set the price of the first object as initial value...
            nameOfProductWithCheapestPrice = productList.get(0).getName(); // set the name
        } else {
            return ""; // ...or returns an empty string if productList is empty
        }

        for (Product product : productList) {
            prices.add(product.getPrice().floatValue());
            if(product.getPrice().floatValue()<temp) {
                temp = product.getPrice().floatValue();
                nameOfProductWithCheapestPrice = product.getName();
            }
        }
        //float tempFloat = Collections.max(prices);
        //System.out.println("Liste aller Preise: " + prices + " Niedrigster Preis: " + Collections.min(prices));// There are more efficient methods to get that value
        return nameOfProductWithCheapestPrice;
    }

    /**
     * Checks for the most popular product
     * @return String Name of the most popular product
     */
    public String checkForMostPopular(){
        productList = readFromJSONFile(filepath);
        ArrayList<Integer> purchases = new ArrayList<Integer>();
        int temp;
        String nameOfMostPopularProduct;
        if (productList != null) { // check if there is an object in the productList...
            temp = productList.get(0).getTimesPurchased(); // ...get the number of the first object as initial value...
            nameOfMostPopularProduct = productList.get(0).getName(); // set the name
        } else {
            return ""; // ...or returns an empty string if productList is empty
        }

        for (Product product: productList) {
            purchases.add(product.getTimesPurchased());
            if(product.getTimesPurchased()>temp) {
                temp = product.getTimesPurchased();
                nameOfMostPopularProduct = product.getName();
            }
        }
        //float tempFloat = Collections.max(purchases);
        //System.out.println("Liste aller Käufe: " + purchases + " Meist gekauftes Produkt: " + Collections.max(purchases));// There are more efficient methods to get that value
        return nameOfMostPopularProduct;
    }

    /**
     * Checks if there is a fragile Product or not.
     * Returns true if at least one product is fragile.
     * @return Boolean
     */
    public Boolean checkForFragile(){
        productList = readFromJSONFile(filepath);
        Boolean containsFragile = false;

        for (Product product : productList) {
            if (product.isFragile()){
                containsFragile = true;
            }
        }

        return containsFragile;
    }
}
