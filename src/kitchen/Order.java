package kitchen;

import outsideKitchen.ConsoleHelper;
import outsideKitchen.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order (Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();

    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    public int getTotalCookingTime(){
        int time = 0;
        if(dishes.contains(Dish.Fish))
            time += 25;
        if(dishes.contains(Dish.Steak))
            time += 30;
        if(dishes.contains(Dish.Soup))
            time += 15;
        if(dishes.contains(Dish.Juice))
            time += 5;
        if (dishes.contains(Dish.Water))
            time += 3;

        return time;
    }

    @Override
    public String toString() {
        if(dishes.isEmpty()){
            return "";
        }
        return "Your order: " + dishes.toString() + " of " + tablet.toString();
    }
}


