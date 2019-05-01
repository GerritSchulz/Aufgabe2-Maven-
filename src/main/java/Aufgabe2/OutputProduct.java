package Aufgabe2;

import com.google.gson.Gson;

import java.util.ArrayList;

public class OutputProduct {
    String mostExpensiveProduct;
    String cheapestProduct;
    String mostPopularProduct;
    ArrayList<String> germanProduct;
    ArrayList<String> chineseProduct;
    Boolean containsFragileProducts;


    // Used Singleton Pattern here because there is no need of a second instance of an output Object
    private static OutputProduct instance;
    public static  OutputProduct getInstance(){
        if(OutputProduct.instance == null){
            OutputProduct.instance = new OutputProduct();
        }
        return OutputProduct.instance;
    }
        private OutputProduct(){
            CheckProducts checker = new CheckProducts();
            this.mostExpensiveProduct = checker.checkForHighestPrice();
            this.cheapestProduct = checker.checkForCheapestPrice();
            this.mostPopularProduct = checker.checkForMostPopular();
            this.germanProduct = checker.checkForCountry("DE");
            this.chineseProduct = checker.checkForCountry("CN");
            this.containsFragileProducts = checker.checkForFragile();
    }

    /**
     * Passes the otput object to JSON format.
     */
    public void serializeOutputProduct(){
        OutputProduct outPro = OutputProduct.getInstance();
        Gson gson = new Gson();
        String json = gson.toJson(outPro);
        System.out.println(json);
    }
}
