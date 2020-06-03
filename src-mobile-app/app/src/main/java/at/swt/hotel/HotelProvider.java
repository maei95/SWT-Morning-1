package at.swt.hotel;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Room;

public class HotelProvider extends Application {

    private static HotelProvider instance;
    private List<HotelContainer> hotelContainerList;
    public static final String DB_NAME = "Hotel_db";
    private AppDatabase db;

    public HotelProvider() {
        db = Room.databaseBuilder(
                MainActivity.applicationContext,
                AppDatabase.class,
                DB_NAME)
                .allowMainThreadQueries()
                .build();

        resetHotelList();
    }

    public void initDataBase() {
        DataInitializer dataInitializer = new DataInitializer();
        dataInitializer.initBasicData(db);
        resetHotelList();
    }

    public void deleteHotel(final HotelContainer hc) {
        hc.delete(db.hotelDao());
        hotelContainerList.removeIf(tmp->tmp.hotel.id == hc.hotel.id);
    }

    public void insertHotel(final HotelContainer hc) {
        hotelContainerList.add(hc);
        db.hotelDao().insertHotels(hc.hotel);
        db.hotelDao().insertHotelPictures(hc.hotelpictures.toArray(new HotelPicture[hc.hotelpictures.size()]));
    }

    public int getNextHotelId() {
        int max = 0;
        for (HotelContainer hc : hotelContainerList) {
            if( max < hc.hotel.id) {
                max = hc.hotel.id;
            }
        }
        return max + 1;
    }

    public int getNextPictureId() {
        int max = 0;
        for (HotelContainer hc : hotelContainerList) {
            for ( HotelPicture hp : hc.hotelpictures) {
                if( max < hp.id) {
                    max = hp.id;
                }
            }
        }
        return max + 1;
    }

    public static HotelProvider getInstance() {
        if (instance == null) {
            instance = new HotelProvider();
        }
        return instance;
    }

    public List<HotelContainer> getHotelContainerList() {
        return hotelContainerList;
    }

    public void updateHotelList(final List<HotelContainer> updatedList) {
        hotelContainerList = updatedList;
    }

    public void resetHotelList() {
        hotelContainerList = new ArrayList<>();
        List<Hotel> hotels = db.hotelDao().getHotels();
        for(Hotel hotel : hotels){
            List<HotelPicture> hpic = db.hotelDao().getHotelPictures(hotel.id);
            List<HotelInterest> hint = db.hotelDao().getHotelInterests(hotel.id);
            hotelContainerList.add(new HotelContainer(hotel,hpic,hint));
        }
    }
}
