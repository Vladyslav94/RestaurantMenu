package ad;

import outsideKitchen.ConsoleHelper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds){
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){
        if(storage.list().isEmpty())
            throw new NoVideoAvailableException();

        List<Advertisement> list = storage.list();
        list.sort(Comparator.comparing(Advertisement::getAmountPerOneDisplaying).thenComparing(Advertisement :: getDuration));
        Collections.reverse(list);

        for (Advertisement vid : list) {
            if (vid.getDuration() <=timeSeconds && vid.getAmountPerOneDisplaying()>0) {
                System.out.println(vid.getName()+" is displaying... "+vid.getAmountPerOneDisplaying()+", "+vid.getAmountPerOneDisplaying()*1000/vid.getDuration());
                vid.revalidate();
                timeSeconds = timeSeconds - vid.getDuration();
            }
        }
    }
}


