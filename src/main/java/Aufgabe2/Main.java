package Aufgabe2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String jsonFile = "C:\\Users\\Schnapfel\\IdeaProjects\\Aufgabe2\\src\\main\\java\\Aufgabe2\\sampleProductsData.json";

    public static void main(String[] args) {

        Product prod1 = new Product("testProduct", "DE", "123.50", true, 150);
        System.out.println(prod1.getPrice());

        // READ IN JSON FILE HERE --------------------------------------------------------------
        final Type PRODUCT_LIST_TYPE= new TypeToken<ArrayList<Product>>(){}.getType();
        Gson gson = new Gson();
        try{
            JsonReader reader = new JsonReader(new FileReader(jsonFile));
            List<Product> products = gson.fromJson(reader, PRODUCT_LIST_TYPE);
            System.out.println(products.get(1));
        }
            catch(FileNotFoundException e) {
                e.printStackTrace();
            }
        //-------------------------------------------------------------------------------------

        CheckProducts check = new CheckProducts();
        check.checkForCountry("DE");
        check.checkForHighestPrice();
        //System.out.println(check.checkForHighestPrice());
        check.checkForCheapestPrice();
        //System.out.println(check.checkForCheapestPrice());
        check.checkForMostPopular();
        //System.out.println(check.checkForMostPopular());
        check.checkForFragile();
        //System.out.println(check.checkForFragile());

        OutputProduct outPro = OutputProduct.getInstance();
        outPro.serializeOutputProduct();
    }
}
