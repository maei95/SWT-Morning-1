package at.swt.hotel;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    List<Hotel> hotelList;
    String[] hotelNames;
    List<HotelPicture> pictureList;
    LayoutInflater inflter;
    int[] hotelPictures;

    public CustomAdapter(Context applicationContext, List<Hotel> hotelList, List<HotelPicture> picturesList) {
        this.context = context;
        this.hotelList = hotelList;
        this.pictureList = picturesList;
        inflter = (LayoutInflater.from(applicationContext));
        hotelNames = new String[hotelList.size()];
        hotelPictures = new int[pictureList.size()];
        int position = 0;
        for(Hotel h : hotelList){
            hotelNames[position++] = h.name;
        }
        Log.d("ADAPT","pictureList: " + pictureList.size());


        for(HotelPicture hp : pictureList){
            //if(hotelPictures[hp.hotelId] == 0) {
            Log.d("ADAPT","index: " + (hp.hotelId-1));
                hotelPictures[hp.hotelId-1] = hp.picture; // TODO: improve this solution
            //}
        }
    }


    @Override
    public int getCount() {
        return hotelList.size();
    }

    @Override
    public Object getItem(int i) {return null;}

    public Hotel getHotel(int id) {
        int position = 0;
        for(Hotel h : hotelList){
            if(position == id){
                return h;
            }
            position++;
        }
        return null;
    }

    public HotelPicture getHotelPicture(int id) {
        int position = 0;
        for(HotelPicture h : pictureList){
            if(position == id){
                return h;
            }
            position++;
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_list_view, null);
        TextView hotelName = (TextView)view.findViewById(R.id.hotel_text);
        ImageView picture = (ImageView)view.findViewById(R.id.hotel_picture);

        hotelName.setText(hotelNames[i]);
        picture.setImageResource(hotelPictures[i]);
        return view;
    }
}
