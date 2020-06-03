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
    List<HotelContainer> hotelList;
    String[] hotelNames;
    LayoutInflater inflter;
    int[] hotelPictures;

    public CustomAdapter(Context applicationContext, List<HotelContainer> hotelList) {
        this.context = context;
        this.hotelList = hotelList;
        inflter = (LayoutInflater.from(applicationContext));
        hotelNames = new String[hotelList.size()];
        hotelPictures = new int[hotelList.size()];
        int position = 0;
        for(HotelContainer h : hotelList){
            hotelNames[position] = h.hotel.name;
            hotelPictures[position++] = h.hotelpictures.get(0) == null ? null : h.hotelpictures.get(0).picture;
        }
    }


    @Override
    public int getCount() {
        return hotelList.size();
    }

    @Override
    public Object getItem(int i) { return hotelList.get(i);}

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
