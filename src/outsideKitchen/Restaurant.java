package outsideKitchen;

import kitchen.Cook;
import kitchen.Order;
import kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args){
        Tablet tablet = new Tablet(1);
        Cook cook = new Cook("Gosha");
        tablet.addObserver(cook);
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        Order order = tablet.createOrder();


    }
}