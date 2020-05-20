package at.swt.hotel;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {
    @Rule
    public IntentsTestRule<LoginActivity> activityRule
            = new IntentsTestRule<>(LoginActivity.class);


    @Test
    public void LoginSuccesfullTestActivity() {
        onView(withId(R.id.editUserName))
                .perform(scrollTo());

        // Type text and then press the button.
        onView(withId(R.id.editUserName))
                .perform(typeText("admin"), closeSoftKeyboard());
        onView(withId(R.id.editPassword))
                .perform(typeText("password"), closeSoftKeyboard());
        onView(withId(R.id.editUserName))
                .check(matches(withText("admin")));
        onView(withId(R.id.editPassword))
                .check(matches(withText("password")));
        onView(withId(R.id.btn_login_loginactivity)).perform(click());
        intended(hasComponent(AdminActivity.class.getName()));
        onView(withId(R.id.btn_back_main)).perform(click());
        intended(hasComponent(MainActivity.class.getName()));
    }

    @Test
    public void LoginFailedTestActivity() {
        onView(withId(R.id.editUserName))
                .perform(scrollTo());

        // Type text and then press the button.
        onView(withId(R.id.editUserName))
                .perform(typeText("admin"), closeSoftKeyboard());
        onView(withId(R.id.editPassword))
                .perform(typeText("blabla"), closeSoftKeyboard());
        onView(withId(R.id.editUserName))
                .check(matches(withText("admin")));
        onView(withId(R.id.editPassword))
                .check(matches(withText("blabla")));
        onView(withId(R.id.btn_login_loginactivity)).perform(click());
    }

}



