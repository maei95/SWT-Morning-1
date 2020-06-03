package at.swt.hotel;

import android.content.Context;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AdminTest {
    @Rule
    public IntentsTestRule<MainActivity> activityRule
            = new IntentsTestRule<>(MainActivity.class);

    @Before
    public void switchToAdminActivity() {
        onView(withId(R.id.btn_Login_main)).perform(click());
        onView(withId(R.id.editUserName))
                .perform(typeText("admin"), closeSoftKeyboard());
        onView(withId(R.id.editPassword))
                .perform(typeText("password"), closeSoftKeyboard());
        onView(withId(R.id.editUserName))
                .check(matches(withText("admin")));
        onView(withId(R.id.editPassword))
                .check(matches(withText("password")));
        onView(withId(R.id.btn_login_loginactivity)).perform(click());
    }

    @Test
    public void AddHotelTest() {
        //Admin page
        onView(withId(R.id.btn_add_hotel)).perform(click());
        onView(withId(R.id.hotel_name_editadd))
                .perform(typeText("Test hotel"), closeSoftKeyboard());
        onView(withId(R.id.hotel_location_editadd))
                .perform(typeText("Test Location"), closeSoftKeyboard());
        onView(withId(R.id.hotel_description_editadd))
                .perform(typeText("Test description"), closeSoftKeyboard());
        onView(withId(R.id.hotel_price_editadd))
                .perform(typeText("1234"), closeSoftKeyboard());
        onView(withId(R.id.hotel_category_editadd))
                .perform(typeText("Test Category"), closeSoftKeyboard());
        //Check fields
        onView(withId(R.id.hotel_name_editadd))
                .check(matches(withText("Test hotel")));
        onView(withId(R.id.hotel_location_editadd))
                .check(matches(withText("Test Location")));
        onView(withId(R.id.hotel_description_editadd))
                .check(matches(withText("Test description")));
        onView(withId(R.id.hotel_price_editadd))
                .check(matches(withText("1234")));
        onView(withId(R.id.hotel_category_editadd))
                .check(matches(withText("Test Category")));
        onView(withId(R.id.btn_editadd)).perform(click());
    }

    @Test
    public void EditHotelTest() {
        //Admin page
        onView(withId(R.id.btn_editHotel)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.hotel_list)).atPosition(1).perform(click());
        intended(hasComponent(EditAddActivity.class.getName()));
        onView(withId(R.id.hotel_name_editadd))
                .perform(clearText(), typeText("Test hotel"), closeSoftKeyboard());
        onView(withId(R.id.hotel_location_editadd))
                .perform(clearText(), typeText("Test Location"), closeSoftKeyboard());
        onView(withId(R.id.hotel_description_editadd))
                .perform(clearText(), typeText("Test description"), closeSoftKeyboard());
        onView(withId(R.id.hotel_price_editadd))
                .perform(clearText(), typeText("1234"), closeSoftKeyboard());
        onView(withId(R.id.hotel_category_editadd))
                .perform(clearText(), typeText("Test Category"), closeSoftKeyboard());
        onView(withId(R.id.btn_editadd)).perform(click());
        onView(withId(R.id.btn_editHotel)).perform(click());
        int size = HotelProvider.getInstance().getHotelContainerList().size();
        onData(anything()).inAdapterView(withId(R.id.hotel_list)).atPosition(size - 1).perform(click());
        onView(withId(R.id.hotel_name_editadd))
                .check(matches(withText("Test hotel")));
        onView(withId(R.id.hotel_location_editadd))
                .check(matches(withText("Test Location")));
        onView(withId(R.id.hotel_description_editadd))
                .check(matches(withText("Test description")));
        onView(withId(R.id.hotel_price_editadd))
                .check(matches(withText("1234")));
        onView(withId(R.id.hotel_category_editadd))
                .check(matches(withText("Test Category")));
    }




}
