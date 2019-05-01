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

        /*  What needs to be done:
            More checks if entries correct
            Checks if two products share the same most expensive or cheapest price, number of purchases etc.
         */

        OutputProduct outPro = OutputProduct.getInstance();
        outPro.serializeOutputProduct();
    }
}
