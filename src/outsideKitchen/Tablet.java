package outsideKitchen;

import ad.AdvertisementManager;
import ad.NoVideoAvailableException;
import kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        Order order = null;

        try {
            order = new Order(this);
            if(!order.isEmpty()){
                ConsoleHelper.writeMessage(order.toString());
                setChanged();
                notifyObservers(order);}
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }

        AdvertisementManager advertisementManager = null;
        try{
            assert order != null;
            advertisementManager = new AdvertisementManager(order.getTotalCookingTime()*60);
            advertisementManager.processVideos();
        } catch (NoVideoAvailableException e){
            logger.log(Level.INFO, "No video is available for the order " + order);
        }

        return order;
    }

    @Override
    public String toString() {
        return "Tablet{number=" + this.number + "}";

    }
}
