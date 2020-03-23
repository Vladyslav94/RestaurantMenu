package outsideKitchen;

import kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        System.out.println(Dish.allDishesToString());
        System.out.println("Please, choose the dish:");
        String chooseTheDish = readString();
        List<String> dis = new ArrayList<>();
        for (int i = 0; i < Dish.values().length; i++) {
            dis.add(Dish.values()[i].toString().toLowerCase());
        }

        while (!chooseTheDish.equals("exit")){
            for (int i = 0; i < Dish.values().length; i++) {
                if(chooseTheDish.equalsIgnoreCase(Dish.values()[i].toString())){
                    dishes.add(Dish.values()[i]);
                }
            }

            if(!dis.contains(chooseTheDish.toLowerCase())){
                System.out.println("No such a dish in the menu");
            }
            chooseTheDish = readString();
        }
        return dishes;
    }
}
