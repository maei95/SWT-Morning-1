package at.swt.hotel;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    public static final String DB_NAME = "Hotel_db";
    private boolean firstRun = false;
    private ListView hotelList;
    public static Context applicationContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        applicationContext = getApplicationContext();


        hotelList = (ListView) findViewById(R.id.hotel_list);

        SharedPreferences preferences = getSharedPreferences("HOTEL_PREFS", 0);
        firstRun = preferences.getBoolean("FIRST_RUN", true);
        if (firstRun)
        {
            HotelProvider.getInstance().initDataBase();
            preferences = getSharedPreferences("HOTEL_PREFS", 0);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("FIRST_RUN", false);
            editor.apply();
        }

        Button btn_sort = findViewById(R.id.btn_sort);
        Button btn_login = findViewById(R.id.btn_Login_main);
        Button btn_filter = findViewById(R.id.btn_filter);
        Button btn_delete = findViewById(R.id.btn_delete_hotel);
        Button btn_edit = findViewById(R.id.btn_editHotel);
        Button btn_logout = findViewById(R.id.btn_logout);
        Button btn_add_hotel = findViewById(R.id.btn_add_hotel);
        //ImageButton btn_search = findViewById(R.id.btn_delete_hotel)
        btn_delete.setVisibility(View.INVISIBLE);
        btn_edit.setVisibility(View.INVISIBLE);
        btn_logout.setVisibility(View.INVISIBLE);
        btn_add_hotel.setVisibility(View.INVISIBLE);

        if (getIntent().getExtras() != null)
        {
            Bundle bun=getIntent().getExtras();
            int val=bun.getInt("VAL");
            if(val == 1) {
                btn_delete.setVisibility(View.VISIBLE);
                btn_edit.setVisibility(View.VISIBLE);
                btn_logout.setVisibility(View.VISIBLE);
                btn_add_hotel.setVisibility(View.VISIBLE);
                btn_sort.setVisibility(View.INVISIBLE);
                btn_login.setVisibility(View.INVISIBLE);
                btn_filter.setVisibility(View.INVISIBLE);
            } else if (val == 2) {
                btn_delete.setVisibility(View.INVISIBLE);
                btn_edit.setVisibility(View.INVISIBLE);
                btn_logout.setVisibility(View.INVISIBLE);
            }
        }
        switchToHotelView(btn_sort);
        switchToLoginView(btn_login);
        switchToFilterView(btn_filter);
        logOutAdmin(btn_logout);

        // TODO: Bernhard designs this more beautiful!
        CustomAdapter customAdapter = new CustomAdapter(applicationContext, HotelProvider.getInstance().getHotelContainerList());
        hotelList.setAdapter(customAdapter);
        deleteHotel(btn_delete, customAdapter);
        editHotel(btn_edit, customAdapter);
        addHotel(btn_add_hotel, customAdapter);

    }

    public void refresh(List<HotelContainer> hotelContainers) {
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), hotelContainers);
        hotelList.setAdapter(customAdapter);
    }


    public void deleteHotel(Button btn, final CustomAdapter adapter) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hotelList.setAdapter(adapter);
                hotelList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView parent, View view, int position, long id) {

                        HotelContainer hc = (HotelContainer) parent.getItemAtPosition(position);
                        HotelProvider.getInstance().deleteHotel(hc);

                        finish();
                        overridePendingTransition(0,0);
                        startActivity(getIntent());
                        overridePendingTransition(0,0);
                    }
                });

            }
        });
    }

    public void editHotel(Button btn, final CustomAdapter adapter) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hotelList.setAdapter(adapter);
                hotelList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView parent, View view, int position, long id) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("edit", true);
                        //TODO: add to bundle Hotel Container
                        HotelContainer hc = (HotelContainer) parent.getItemAtPosition(position);
                        bundle.putInt("HCId", hc.hotel.id);

                        Intent editAddActivityIntent = new Intent(MainActivity.this, EditAddActivity.class);
                        editAddActivityIntent.putExtras(bundle);
                        startActivity(editAddActivityIntent);


                    }
                });

            }
        });
    }

    public void addHotel(Button btn, final CustomAdapter adapter) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("add", true);
                Intent EditAddActivityIntent = new Intent(MainActivity.this, EditAddActivity.class);
                EditAddActivityIntent.putExtras(bundle);
                startActivity(EditAddActivityIntent);
            }
        });
    }

    public void switchToHotelView(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HotelActivityIntent = new Intent(MainActivity.this, HotelViewActivity.class);
                MainActivity.this.startActivity(HotelActivityIntent);
            }
         });
    }

    public void logOutAdmin(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent LogoutIntent = new Intent(MainActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("VAL", 2);
                getIntent().putExtras(bundle);
                finish();
                overridePendingTransition(0,0);
                startActivity(getIntent());
                overridePendingTransition(0,0);
               // MainActivity.this.startActivity(LogoutIntent);

            }
        });
    }

    public void switchToLoginView(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginActivityIntent = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(LoginActivityIntent);

            }
        });
    }

    public void switchToFilterView(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginActivityIntent = new Intent(MainActivity.this, FilterActivity.class);
                MainActivity.this.startActivity(LoginActivityIntent);

            }
        });
    }
}