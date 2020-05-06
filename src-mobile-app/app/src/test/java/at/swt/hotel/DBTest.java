package at.swt.hotel;

import android.content.Context;

import androidx.room.Room;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

//@RunWith(AndroidJUnit4.class)
public class DBTest{

    private UserDao userDao;
    private AppDatabase db;
    private Context ApplicationProvider;
    public static final String DB_NAME = "Hotel_db";

    

    @Test
    public void testUsergetAll() throws Exception {
        UserDao userDao = Mockito.mock(UserDao.class);

        User testUser = new User();
        testUser.name = "test Hans";
        testUser.email = "testmail@tugraz.at";

        Mockito.when(userDao.getAll()).thenReturn(Arrays.asList(testUser));

        List<User> users = userDao.getAll();
        assertEquals(1,users.size());
    }

    @Test
    public void testUsergetAllEmpty() throws Exception {
        UserDao userDao = Mockito.mock(UserDao.class);

        List<User> emptyList = new ArrayList<>();
        Mockito.when(userDao.getAll()).thenReturn(emptyList);

        List<User> users = userDao.getAll();
        assertEquals(0,users.size());
    }
}
