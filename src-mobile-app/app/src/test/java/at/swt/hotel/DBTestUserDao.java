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
public class DBTestUserDao {

    private UserDao userDao;
    private AppDatabase db;
    private Context ApplicationProvider;
    public static final String DB_NAME = "Hotel_db";

    @Before
    public void createDb() {
        db = Mockito.mock(AppDatabase.class);
        userDao = Mockito.mock(UserDao.class);
        Mockito.when(db.userDao()).thenReturn(userDao);
    }

    @Test
    public void testUsergetAll() throws Exception {
        User testUser = new User();
        testUser.name = "test Hans";
        testUser.email = "testmail@tugraz.at";

        Mockito.when(userDao.getAll()).thenReturn(Arrays.asList(testUser));

        List<User> users = db.userDao().getAll();
        assertEquals(1,users.size());
        
    }

    @Test
    public void testUsergetAllEmpty() throws Exception {
        List<User> emptyList = new ArrayList<>();
        Mockito.when(userDao.getAll()).thenReturn(emptyList);

        List<User> users = db.userDao().getAll();
        assertEquals(0,users.size());
    }

    @Test
    public void testAddUser() throws Exception {

        User testUser = new User();
        testUser.name = "test Hans";
        testUser.email = "testmail@tugraz.at";

        Mockito.doNothing().when(userDao).insertAll(testUser);
        db.userDao().insertAll(testUser);

        Mockito.when(userDao.getAll()).thenReturn(Arrays.asList(testUser));

        List<User> users = db.userDao().getAll();
        assertEquals(1,users.size());
        assertEquals(users.get(0),testUser);
    }

    @Test
    public void testLoadUsersByIds() throws Exception {

        User testUser = new User();
        testUser.id = 1337;
        testUser.name = "test Hans";
        testUser.email = "testmail@tugraz.at";

        User testUser2 = new User();
        testUser2.id = 19;
        testUser2.name = "CoVid";
        testUser2.email = "alarm@mail.lol";

        Mockito.when(userDao.loadAllByIds(new int[]{19,1337})).thenReturn(Arrays.asList(testUser2,testUser));

        List<User> users = db.userDao().loadAllByIds(new int[]{19,1337});
        assertEquals(2,users.size());
        assertEquals(users.get(0),testUser2);
        assertEquals(users.get(1),testUser);
    }

    @Test
    public void testDeleteUser() throws Exception {

        User testUser = new User();
        testUser.id = 1337;
        testUser.name = "test Hans";
        testUser.email = "testmail@tugraz.at";

        User testUser2 = new User();
        testUser2.id = 19;
        testUser2.name = "CoVid";
        testUser2.email = "alarm@mail.lol";

        Mockito.doNothing().when(userDao).delete(testUser);
        db.userDao().delete(testUser);

        Mockito.when(userDao.loadAllByIds(new int[]{19,1337})).thenReturn(Arrays.asList(testUser2));
        db.userDao().loadAllByIds(new int[]{19,1337});

        List<User> users = db.userDao().loadAllByIds(new int[]{19,1337});
        assertEquals(1,users.size());
        assertEquals(users.get(0),testUser2);
    }

}
