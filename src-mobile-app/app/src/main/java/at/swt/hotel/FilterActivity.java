package at.swt.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class FilterActivity extends AppCompatActivity {

    List<HotelContainer> priceFilteredHotels;
    List<HotelContainer> starFilteredHotels;
    List<HotelContainer> activityFilteredHotels;
    List<HotelContainer> categoryFilteredHotels;
    List<HotelContainer> locationFilteredHotels;
    boolean pirceFilter = false;
    boolean categoryFilter = false;
    boolean activityFilter = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        pirceFilter = false;
        categoryFilter = false;
        activityFilter = false;

        HotelProvider.getInstance().resetHotelList();
        priceFilteredHotels = new ArrayList<>();
        activityFilteredHotels = new ArrayList<>();
        categoryFilteredHotels = new ArrayList<>();
        starFilteredHotels = new ArrayList<>();

        Button priceButton0_50 = findViewById(R.id.priceToggle1);
        priceButton0_50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                setPriceFilter(0, 50);
            }
        });

        Button priceButton50_100 = findViewById(R.id.priceToggle2);
        priceButton50_100.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setPriceFilter(50, 100);
            }
        });

        Button priceButton100_150 = findViewById(R.id.priceToggle3);
        priceButton100_150.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setPriceFilter(100, 150);
            }
        });

        Button priceButton150_200 = findViewById(R.id.priceToggle4);
        priceButton150_200.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setPriceFilter(150, 200);
            }
        });

        Button priceButton200 = findViewById(R.id.priceToggle5);
        priceButton200.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setPriceFilter(200, 999999);
            }
        });

        Button categoryRomantic  = findViewById(R.id.categoryToggle1);
        categoryRomantic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategoryFilter(categoryRomantic.getText().toString());
            }
        });

        Button categoryAdventure = findViewById(R.id.categoryToggle2);
        categoryAdventure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategoryFilter(categoryAdventure.getText().toString());
            }
        });
        Button categoryFamily    = findViewById(R.id.categoryToggle3);
        categoryFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategoryFilter(categoryFamily.getText().toString());
            }
        });
        Button categorySport     = findViewById(R.id.categoryToggle4);
        categorySport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategoryFilter(categorySport.getText().toString());
            }
        });

        Button activitySurfing  = findViewById(R.id.activityToggleButton1);
        activitySurfing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityFilter(activitySurfing.getText().toString());
            }
        });
        Button activityClimbing = findViewById(R.id.activityToggleButton2);
        activityClimbing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityFilter(activityClimbing.getText().toString());
            }
        });
        Button activityMtb      = findViewById(R.id.activityToggleButton3);
        activityMtb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityFilter(activityMtb.getText().toString());
            }
        });
        Button activityHiking   = findViewById(R.id.activityToggleButton4);
        activityHiking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityFilter(activityHiking.getText().toString());
            }
        });
        Button activityDiving   = findViewById(R.id.activityToggleButton5);
        activityDiving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityFilter(activityDiving.getText().toString());
            }
        });
        Button activitySkating  = findViewById(R.id.activityToggleButton6);
        activitySkating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityFilter(activitySkating.getText().toString());
            }
        });

        Button setFilterButton = findViewById(R.id.applyFilterButton);
        setFilterButton.setOnClickListener(applyFilter());

        ImageButton btnSearch = findViewById(R.id.btnFilterSearch);
        btnSearch.setOnClickListener(applyFilter());
    }

    private View.OnClickListener applyFilter() {
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                EditText location = findViewById(R.id.editFilterLocation);
                String locationText = location.getText().toString();

                List<HotelContainer> filteredHotels = new ArrayList<>();
                if (locationText.isEmpty()) {
                    filteredHotels = HotelProvider.getInstance().getHotelContainerList();
                } else {
                    for (HotelContainer hc : HotelProvider.getInstance().getHotelContainerList()) {
                        if (hc.hotel.location.toLowerCase().contains(locationText.toLowerCase())) {
                            filteredHotels.add(hc);
                        }
                    }
                }

                RatingBar star = findViewById(R.id.ratingBar);
                setStarFilter(Math.round(star.getRating()));
                filteredHotels.retainAll(starFilteredHotels);

                if (!priceFilteredHotels.isEmpty() && pirceFilter) {
                    filteredHotels.retainAll(priceFilteredHotels);
                }

                if (!categoryFilteredHotels.isEmpty() && categoryFilter)
                {
                    filteredHotels.retainAll(categoryFilteredHotels);
                }

                if (!activityFilteredHotels.isEmpty() && activityFilter)
                {
                    filteredHotels.retainAll(activityFilteredHotels);
                }

                HotelProvider.getInstance().updateHotelList(filteredHotels);
                Intent mainActivityIntent = new Intent(FilterActivity.this, MainActivity.class);
                FilterActivity.this.startActivity(mainActivityIntent);
            }
        };
    }

    public void switchToHotelView(ImageButton btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hotelViewActivity = new Intent(FilterActivity.this, HotelViewActivity.class);
                FilterActivity.this.startActivity(hotelViewActivity);

            }
        });
    }

    public void setPriceFilter(final int min, final int max) {
        pirceFilter = true;
        for(HotelContainer hc : HotelProvider.getInstance().getHotelContainerList()) {
           if (hc.hotel.price <= max && hc.hotel.price >= min) {
               priceFilteredHotels.add(hc);
           }
        }
    }

    public void setCategoryFilter(final String category) {
        categoryFilter = true;
        for(HotelContainer hc : HotelProvider.getInstance().getHotelContainerList()) {
            if (hc.hotel.category.equalsIgnoreCase(category)) {
                categoryFilteredHotels.add(hc);
            }
        }
    }

    public void setActivityFilter(final String activity) {
        activityFilter = true;
        for(HotelContainer hc : HotelProvider.getInstance().getHotelContainerList()) {
            for (HotelInterest hi : hc.hotelinterest) {
                if (hi.type.equalsIgnoreCase(activity)) {
                    activityFilteredHotels.add(hc);
                }
            }
        }
    }

    public void setStarFilter(final int minimumStars) {
        for(HotelContainer hc : HotelProvider.getInstance().getHotelContainerList()) {
            if (hc.hotel.stars >= minimumStars) {
                starFilteredHotels.add(hc);
            }
        }
    }
}