package at.swt.hotel;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import java.util.List;


import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class DataInitializer extends AppCompatActivity {

    /* The name of the data base. */
    public static final String DB_NAME = "Hotel_db";


    public void initBasicData(AppDatabase db) {
        // --------------- HOTEL 1 ---------------
        Hotel firstHotel = new Hotel();
        firstHotel.id = 1;
        firstHotel.name = "Arte-Salzburg";
        firstHotel.description = "Direkt beim Bahnhof und nur 10 Minuten vom Zentrum entfernt liegt unser neues arte Hotel Salzburg, das im Frühling 2019 eröffnet wurde. " +
                "Das Gebäude ist ein beeindruckender Hochbau aus Stahl, Beton und Glas und bietet einen atemberaubenden Blick auf die Altstadt und das Umland. Besonders das Frühstück im 15. " +
                "Stock und ein Drink abends von der Rooftop-Bar „hu:goes14“ mit Dachterrasse im 16. Stock werden einen einzigartigen Eindruck hinterlassen";
        firstHotel.price = 270;
        firstHotel.category = "Romantic";
        firstHotel.location = "Salzburg Rainerstraße 28 5020 Salzburg Österreich";
        firstHotel.stars = 4;

        User user1 = new User();
        user1.email = "user1@test.com";
        user1.id = 1;
        user1.name = "Mausi Lugner";

        User user2 = new User();
        user2.email = "user2@test.com";
        user2.id = 2;
        user2.name = "User 2";

        User user3 = new User();
        user3.email = "user3@test.com";
        user3.id = 3;
        user3.name = "User 3";

        String rating1 = "Moderne Ausstattung, sehr gute Lage, tolles Design. Nicht gefallen · Der Trend zu Badezimmern mit Glaswänden und halbdurchsichtigen Vorhängen ist für Pärchen ggf. ganz nett. Für alle anderen kann es schnell auch unangenehm werden.";

        HotelRating ratingHotel1 = new HotelRating(1,0,7,rating1);

        HotelRating ratingHotel1_1 = new HotelRating();
        ratingHotel1_1.comment = "Moderne Ausstattung, sehr gute Lage, tolles Design. Nicht gefallen · Der Trend zu Badezimmern mit Glaswänden und halbdurchsichtigen Vorhängen ist für Pärchen ggf. ganz nett. Für alle anderen kann es schnell auch unangenehm werden.";
        ratingHotel1_1.rating = 7;
        ratingHotel1_1.hotelId = firstHotel.id;
        ratingHotel1_1.userId = user1.id;

        HotelRating ratingHotel1_2 = new HotelRating();
        ratingHotel1_2.comment = "Das Bad mit Glasscheibe ohne Türe. Der Vorhang ist durchsichtig, den kann man sich sparen. Es ist keinerlei Privatsphäre möglich. Außerdem entweicht jeglicher Dampf ins Zimmer, z.b.beim Duschen friert man, Haarspray und Deo verteilt sich im ganzen Zimmer.. Die Abstellfläche ist zu gering...";
        ratingHotel1_2.rating = 3;
        ratingHotel1_2.hotelId = firstHotel.id;
        ratingHotel1_2.userId = user2.id;

        HotelRating ratingHotel1_3 = new HotelRating();
        ratingHotel1_3.comment = "Das Frühstück war reichhaltig und gut.\n" +
                "Personal immer freundlich und hilfsbereit\n" +
                "Gute Lage zum ÖPNV.\n" +
                "\n" +
                "Nicht gefallen · Zimmer nur durch Klimaanlage belüftet,\n" +
                "Keine separate Klimatisierung von Zimmer und Bad.\n" +
                "Terrasse in der 16. Etage leider geschlossen";
        ratingHotel1_3.rating = 8;
        ratingHotel1_3.hotelId = firstHotel.id;
        ratingHotel1_3.userId = user3.id;

        HotelInterest interestHotel1_1 = new HotelInterest();
        interestHotel1_1.type = "Climbing";
        interestHotel1_1.description = "Fitnesscenter";
        interestHotel1_1.hotelId = firstHotel.id;

        HotelInterest interestHotel1_2 = new HotelInterest();
        interestHotel1_2.type = "Mountainbiking";
        interestHotel1_2.description = "Spa und Wellnesscenter";
        interestHotel1_2.hotelId = firstHotel.id;

        HotelInterest interestHotel1_3 = new HotelInterest();
        interestHotel1_3.type = "Hiking";
        interestHotel1_3.description = "Bibliothek";
        interestHotel1_3.hotelId = firstHotel.id;

        HotelInterest interestHotel1_4 = new HotelInterest();
        interestHotel1_4.type = "Diving";
        interestHotel1_4.description = "Kino";
        interestHotel1_4.hotelId = firstHotel.id;

        HotelPicture hotelPicture1 = new HotelPicture();
        hotelPicture1.id = 1;
        hotelPicture1.hotelId = 1;
        hotelPicture1.picture = R.drawable.hotel_1;

        // --------------- HOTEL 2 ---------------
        Hotel secondHotel = new Hotel();
        secondHotel.id = 2;
        secondHotel.name = "Bubble Tent Salzburg";
        secondHotel.description = "Erlebe einzigartige Nächte im Salzkammergut.\n" +
                "In unseren Bubble Tents – den transparenten Kugelzelten.\n" +
                "Eine Übernachtung im BubbleTent ist ein echtes Natur-Erlebnis, abseits des Gewoehnlichen.\n" +
                "Geniesse die einzigartiger Lage mit freiem Blick auf die vielfältige Landschaft des Salzkammerguts. Abseits vom Stadttrubel, kannst du Körper und Seele baumeln lassen ohne auf den Komfort eines Hotels zu verzichten.\n";
        secondHotel.price = 95;
        secondHotel.category = "Adventure";
        secondHotel.stars = 1;
        secondHotel.location = "Feld 2, 4853 Steinbach am Attersee";

        User user4 = new User();
        user4.email = "user4@test.com";
        user4.id = 4;
        user4.name = "User 4";

        User user5 = new User();
        user5.email = "user5@test.com";
        user5.id = 5;
        user5.name = "User 5";

        User user6 = new User();
        user6.email = "user6@test.com";
        user6.id = 6;
        user6.name = "User 6";

        HotelRating ratingHotel2_1 = new HotelRating();
        ratingHotel2_1.comment = "+Betreiber super nett, Aussicht war trotz Regen super, ein tolles Erlebnis.\n" +
                "-Ein Heizstrahler bei kalten Temperaturen ist etwas zu wenig.";
        ratingHotel2_1.rating = 9;
        ratingHotel2_1.hotelId = secondHotel.id;
        ratingHotel2_1.userId = user4.id;

        HotelRating ratingHotel2_2 = new HotelRating();
        ratingHotel2_2.comment = "Ein super Erlebnis!! War alles Spitze. Ein großes Lob an das gesamte Bubbletent Team! Toller Service, super freundlich und sehr sehr sauber!";
        ratingHotel2_2.rating = 10;
        ratingHotel2_2.hotelId = secondHotel.id;
        ratingHotel2_2.userId = user5.id;

        HotelRating ratingHotel2_3 = new HotelRating();
        ratingHotel2_3.comment = "Super alternative zu einem langweiligen Hotel. Diese Unterkunft hat alles zu bieten, was man braucht. Champing der Extraklasse.\n" +
                "Sternenhimmel inklusive, eine tolle Lage mit Aussicht, der See direkt in der Nähe und Wanderwege, sowie Klettersteig fast direkt vor der Zelttür.\n" +
                "War alles sauber und ist mit liebe zum Detail gestaltet. Auch der Betreiber ist super nett und locker unterwegs.\n" +
                "Für Klimaanlage an heißen Sommertag ist gesorgt. Ebenso gibt es eine Heizdecke für kühle Sommernächte.\n" +
                "Wir sind hellauf begeistert und können es jeden nur ans Herz legen, diese Erfahrung zu machen.\n" +
                "P.S. Das ist kein Werbetext, sondern eine ehrliche Bewertung. Wir hatten tolle zwei Nächte.";
        ratingHotel2_3.rating = 10;
        ratingHotel2_3.hotelId = secondHotel.id;
        ratingHotel2_3.userId = user6.id;

        HotelInterest interestHotel2_1 = new HotelInterest();
        interestHotel2_1.type = "Hiking";
        interestHotel2_1.description = "Wandern";
        interestHotel2_1.hotelId = secondHotel.id;

        HotelInterest interestHotel2_2 = new HotelInterest();
        interestHotel2_2.type = "Mountainbiking";
        interestHotel2_2.description = "Mountain Biken";
        interestHotel2_2.hotelId = secondHotel.id;

        HotelInterest interestHotel2_3 = new HotelInterest();
        interestHotel2_3.type = "Diving";
        interestHotel2_3.description = "Paragliding";
        interestHotel2_3.hotelId = secondHotel.id;

        HotelInterest interestHotel2_4 = new HotelInterest();
        interestHotel2_4.type = "Surfing";
        interestHotel2_4.description = "Bungee Jumping";
        interestHotel2_4.hotelId = secondHotel.id;

        HotelPicture hotelPicture2 = new HotelPicture();
        hotelPicture2.id = 2;
        hotelPicture2.hotelId = 2;
        hotelPicture2.picture = R.drawable.hotel_2;


        // --------------- HOTEL 3 ---------------
        Hotel thirdHotel = new Hotel();
        thirdHotel.id = 3;
        thirdHotel.name = "a&o Graz Hauptbahnhof";
        thirdHotel.description = "Das a&o Graz Hauptbahnhof liegt nur 100 m vom Grazer Hauptbahnhof entfernt. Im eigenen Bad liegen kostenfreie Pflegeprodukte und ein Haartrockner für Sie bereit. WLAN nutzen Sie in allen Bereichen kostenfrei.\n" +
                "Von der Bar auf der Dachterrasse können Sie den Panoramablick über die Stadt genießen. In der Lobby können Sie Tischfußball und Billard spielen. Für die Erkundung der Stadt können Sie den Fahrradverleih nutzen.\n" +
                "In der Lobby und in der Bar sorgt Sat-TV mit verschiedenen Sportkanälen für Unterhaltung.\n" +
                "Verschiedene Restaurants und Geschäfte im Zentrum von Graz können Sie vom a&o Graz Hauptbahnhof in 5 Gehminuten erreichen.\n" +
                "Gries ist bei Reisenden, die an einer schönen Altstadt, Spazieren gehen und Sightseeing interessiert sind, sehr beliebt.\n\n";
        thirdHotel.price = 40;
        thirdHotel.category = "Family";
        thirdHotel.stars = 5;
        thirdHotel.location = "Eggenberger Straße 7, Gries, 8020 Graz, Österreich";

        User user7 = new User();
        user7.email = "user7@test.com";
        user7.id = 7;
        user7.name = "User 7";

        User user8 = new User();
        user8.email = "user8@test.com";
        user8.id = 8;
        user8.name = "User 8";

        User user9 = new User();
        user9.email = "user9@test.com";
        user9.id = 9;
        user9.name = "User 9";

        HotelRating ratingHotel3_1 = new HotelRating();
        ratingHotel3_1.comment = "Das Frühstück war sehr gut, die Abwicklung sehr unkompliziert.\n" +
                "Besonders gefallen hat mir das wirklich sehr freundliche Personal. Das Fenster im Zimmer war gekippt (wohl über mehrere Stunden) und wir haben am Anfang ziemlich gefroren, weil es sehr lange dauerte, bis der Raum wieder angenehm temperiert war.\n" +
                "Das ist aber wirklich der einzige Kritikpunkt, sonst hat alles super gepasst.";
        ratingHotel3_1.rating = 7;
        ratingHotel3_1.hotelId = thirdHotel.id;
        ratingHotel3_1.userId = user7.id;

        HotelRating ratingHotel3_2 = new HotelRating();
        ratingHotel3_2.comment = "The room was like a hotel room, with a nice double-bed, tv, and some hangers and shelves. It was clean and the towels were there waiting for us already when we came.\n" +
                " The bathroom was very nice and we were both surprised by what we got for our money";
        ratingHotel3_2.rating = 6;
        ratingHotel3_2.hotelId = thirdHotel.id;
        ratingHotel3_2.userId = user8.id;

        HotelRating ratingHotel3_3 = new HotelRating();
        ratingHotel3_3.comment = "The rooms are huge, good location next to Hauptbahnhof although a bit of a walk to the tourist attractions. My room faced onto a main road so a bit noisy";
        ratingHotel3_3.rating = 4;
        ratingHotel3_3.hotelId = thirdHotel.id;
        ratingHotel3_3.userId = user9.id;

        HotelInterest interestHotel3_1 = new HotelInterest();
        interestHotel3_1.type = "Climbing";
        interestHotel3_1.description = "Live-Sportveranstaltung";
        interestHotel3_1.hotelId = thirdHotel.id;

        HotelInterest interestHotel3_2 = new HotelInterest();
        interestHotel3_2.type = "Surfing";
        interestHotel3_2.description = "Bibliothek";
        interestHotel3_2.hotelId = thirdHotel.id;

        HotelInterest interestHotel3_3 = new HotelInterest();
        interestHotel3_3.type = "Mountainbiking";
        interestHotel3_3.description = "Fahrradverleih";
        interestHotel3_3.hotelId = thirdHotel.id;

        HotelInterest interestHotel3_4 = new HotelInterest();
        interestHotel3_4.type = "Skating";
        interestHotel3_4.description = "Billard";
        interestHotel3_4.hotelId = thirdHotel.id;

        HotelPicture hotelPicture3 = new HotelPicture();
        hotelPicture3.id = 3;
        hotelPicture3.hotelId = 3;
        hotelPicture3.picture = R.drawable.hotel_3;

        // --------------- HOTEL 4 ---------------
        Hotel fourthHotel = new Hotel();
        fourthHotel.id = 4;
        fourthHotel.name = "Grand Hotel Wiesler";
        fourthHotel.description = "Das Hotel Wiesler in Graz liegt direkt an der Mur in der Grazer Altstadt und verfügt über eine Sauna, einen Fitnessbereich und einen Friseur. Das Hotel bietet auch eine 24-Stunden-Rezeption und kostenloses WLAN.\n" +
                "Das Restaurant Salon Marie serviert österreichische und internationale Küche. Hier wird Ihnen auch das reichhaltige und abwechslungsreiche Frühstücksbuffet serviert.\n" +
                "Das Kunsthaus befindet sich 100 m entfernt, und die Murinsel erreichen Sie bereits nach 300 m vom Hotel Wiesler in Graz. Die Schlossbergbahn liegt 5 Gehminuten entfernt. Leihfahrräder erhalten Sie in der Unterkunft.\n" +
                "Gries ist bei Reisenden, die an einer schönen Altstadt, Spazieren gehen und Sightseeing interessiert sind, sehr beliebt.\n" +
                "Laut unabhängiger Gästebewertungen ist das der beliebteste Teil von Graz.";
        fourthHotel.price = 120;
        fourthHotel.category = "Sport";
        fourthHotel.stars = 4;
        fourthHotel.location = "Grieskai 4-8, Gries, 8020 Graz, Österreich";

        User user10 = new User();
        user10.email = "user10@test.com";
        user10.id = 10;
        user10.name = "User 10";

        User user11 = new User();
        user11.email = "user11@test.com";
        user11.id = 11;
        user11.name = "User 11";

        User user12 = new User();
        user12.email = "user12@test.com";
        user12.id = 12;
        user12.name = "User 12";

        HotelRating ratingHotel4_1 = new HotelRating();
        ratingHotel4_1.comment = "Tolle Location, super freundlich. Ein wirklich tolles, hippes Design (außen Jugendstil, innen künstlerisch gestaltet, modern), " +
                "ein fabelhaftes Frühstück und wirklich nettes Personal. Sehr nah zur Innenstadt. Würde wiederkommen.";
        ratingHotel4_1.rating = 9;
        ratingHotel4_1.hotelId = fourthHotel.id;
        ratingHotel4_1.userId = user10.id;

        HotelRating ratingHotel4_2 = new HotelRating();
        ratingHotel4_2.comment = "Everybody was very helpful and very friendly. Also the dinner was a real experience and the service was excellent. " +
                "It is seen the staff enjoys and know what they do. Very recommendable. Thanks!";
        ratingHotel4_2.rating = 8;
        ratingHotel4_2.hotelId = fourthHotel.id;
        ratingHotel4_2.userId = user11.id;

        HotelRating ratingHotel4_3 = new HotelRating();
        ratingHotel4_3.comment = "Rooms have a great comfort, very modern and clean hotel, quiet as well, although in center. breakfast is amazing. " +
                "Staff is very friendly. Definetly will return!";
        ratingHotel4_3.rating = 10;
        ratingHotel4_3.hotelId = fourthHotel.id;
        ratingHotel4_3.userId = user12.id;

        HotelInterest interestHotel4_1 = new HotelInterest();
        interestHotel4_1.type = "Climbing";
        interestHotel4_1.description = "Fitnesscenter";
        interestHotel4_1.hotelId = fourthHotel.id;

        HotelInterest interestHotel4_2 = new HotelInterest();
        interestHotel4_2.type = "Hiking";
        interestHotel4_2.description = "Spa und Wellnesscenter";
        interestHotel4_2.hotelId = fourthHotel.id;

        HotelPicture hotelPicture4 = new HotelPicture();
        hotelPicture4.id = 4;
        hotelPicture4.hotelId = 4;
        hotelPicture4.picture = R.drawable.hotel4_1;


        // insert data into database
        db.userDao().insertAll(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12);

        db.hotelDao().insertHotels(firstHotel, secondHotel, thirdHotel, fourthHotel);
        db.hotelDao().insertHotelRatings(ratingHotel1_1, ratingHotel1_2, ratingHotel1_3, ratingHotel2_1, ratingHotel2_2, ratingHotel2_3,
                ratingHotel3_1, ratingHotel3_2, ratingHotel3_3, ratingHotel4_1, ratingHotel4_2, ratingHotel4_3);
        db.hotelDao().insertHotelInterests(interestHotel1_1, interestHotel1_2, interestHotel1_3, interestHotel1_4,
                interestHotel2_1, interestHotel2_2, interestHotel2_3, interestHotel2_4, interestHotel3_1, interestHotel3_2,
                interestHotel3_3, interestHotel3_4, interestHotel4_1, interestHotel4_2);
        db.hotelDao().insertHotelPictures(hotelPicture1, hotelPicture2, hotelPicture3, hotelPicture4);
    }
}
