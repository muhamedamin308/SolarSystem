package com.example.recycleview;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = GalaxyClass.class , version = 5)
public abstract class GalaxyRoomdb extends RoomDatabase {
    private static GalaxyRoomdb instance;
    public abstract GalaxyDao galaxyDao();

    //Signlaton
    public static synchronized GalaxyRoomdb getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),GalaxyRoomdb.class ,
                    "planet-data")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new GalaxySpaceAsyncTask(instance).execute();
        }
    };

    private static class GalaxySpaceAsyncTask extends AsyncTask<Void , Void , Void>{
        private GalaxyDao mgalaxyDao;

        GalaxySpaceAsyncTask (GalaxyRoomdb galaxyRoomdb){
            mgalaxyDao = galaxyRoomdb.galaxyDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            mgalaxyDao.insert(new GalaxyClass(R.drawable.mercury, "Mercury" , "Mercury is the smallest planet" +
                    " in the Solar System Average orbital speed: 47.36 km/s Surface gravity: 3.7 m/s2; 0.38 g; Composition by" +
                    " volume: atomic oxygen ;", "\n  Mercury is a chemical element with the symbol Hg and atomic number 80. \n  It is commonly" +
                    " known as quicksilver and was formerly named hydrangea (/haɪˈdrɑːrdʒərəm/ hy-DRAR-jər-əm).\n" +
                    "  [4] A heavy, silvery d-block element, mercury is the only metallic element that is liquid at " +
                    "standard conditions for temperature and pressure; \n  the only other element that is liquid under these " +
                    "conditions is the halogen bromine, though metals such as caesium, gallium, and rubidium melt just above" +
                    " room temperature.\n" +
                    "  Mercury occurs in deposits throughout the world mostly as cinnabar (mercuric sulfide).\n  The red pigment " +
                    "vermilion is obtained by grinding natural cinnabar or synthetic mercuric sulfide.\n"));

            mgalaxyDao.insert(new GalaxyClass(R.drawable.venus, "Venus" , "Venus is the second planet from the Sun. It is named" +
                    " after the Roman goddess of love and beauty. Equatorial rotation velocity: 6.52 km/h (1.81 m/s)" +
                    " Surface gravity: 8.87 m/s2; 0.904 g.", "\n  Venus is the second planet from the Sun. \n  It is named after the Roman goddess of love " +
                    "and beauty. As the brightest natural object in Earth's night sky after the Moon, Venus can cast shadows " +
                    "and can be visible to the naked eye in broad daylight.\n  [18][19] Venus lies within Earth's orbit, and so " +
                    "never appears to venture far from the Sun, either setting in the west just after dusk or rising in the east " +
                    "a little while before dawn. \n  Venus orbits the Sun every 224.7 Earth days.\n  [20] It has a synodic day length of " +
                    "117 Earth days and a sidereal rotation period of 243 Earth days.\n  As a consequence, it takes longer to " +
                    "rotate about its axis than any other planet in the Solar System, and does so in the opposite direction " +
                    "to all but Uranus.\n  This means the Sun rises in the west and sets in the east.\n  [21] Venus does not have " +
                    "any moons, a distinction it shares only with Mercury among the planets in the Solar System.[22]\n"));

            mgalaxyDao.insert(new GalaxyClass(R.drawable.earth, "Earth" ,"Earth is the third planet from the ; Earth's atmosphere " +
                    "consists mostly of ; Earth's gravity interacts with other objects in space,Surface gravity: 9.80665 m/s2,Surface equivalent dose rate: " +
                    "0.274 μSv/h,70% of the Earth's Surface is Covered in Water." ,  "\n  Earth is the third planet from the Sun and the only astronomical " +
                    "object known to harbor life.\n  While large amounts of water can be found throughout the Solar System," +
                    " only Earth sustains liquid surface water.\n  About 71% of Earth's surface is made up of the ocean, dwarfing " +
                    "Earth's polar ice, lakes and rivers.\n  The remaining 29% of Earth's surface is land, consisting of continents" +
                    " and islands.\n  Earth's surface layer is formed of several slowly moving tectonic plates, interacting to" +
                    " produce mountain ranges, volcanoes and earthquakes.\n  Earth's liquid outer core generates the magnetic field" +
                    " that shapes Earth's magnetosphere, deflecting destructive solar winds.\n"));

            mgalaxyDao.insert(new GalaxyClass(R.drawable.mars, "Mars" ,"Mars is th    e fourth planet from the Sun and the " +
                    "second-smallest planet in the Solar System, being larger than only Mercury.\n Mars and Earth have approximately the same landmass and" +
                    " Only 18 missions to Mars have been successful." , "\n  Mars is the fourth planet from the Sun and the second-smallest planet" +
                    " in the Solar System, being larger than only Mercury.\n  In English, Mars carries the name of" +
                    " the Roman god of war and is often referred to as the \"Red Planet\".\n  [17][18] The latter refers " +
                    "to the effect of the iron oxide prevalent on Mars's surface, which gives it a reddish appearance, " +
                    "that is distinctive among the astronomical bodies visible to the naked eye.\n  [19] Mars is a terrestrial" +
                    " planet with a thin atmosphere, with surface features reminiscent of the impact craters of the Moon," +
                    " and the valleys, deserts and polar ice caps of Earth.\n"));

            mgalaxyDao.insert(new GalaxyClass(R.drawable.jupiter, "Jupiter" , "Jupiter is the fifth planet from the Sun and the " +
                    "largest in the Solar System. It is a gas giant with a mass more than two and a half times that of all the othre planets \n Average " +
                    "orbital speed: 13.07 km/s (8.12 mi/s) and Rotation period: 9.9258 h (9 h 55 m 33 s)",  "\n  Jupiter is the fifth planet from the Sun and the largest in the Solar System.\n" +
                    " It is a gas giant with a mass more than two and a half times that of all the other" +
                    " planets in the Solar System combined, but slightly less than one-thousandth the mass of the Sun.\n" +
                    "  Jupiter is the third brightest natural object in the Earth's night sky after the Moon and Venus.\n" +
                    "  People have been observing it since prehistoric times;\n  it was named after the Roman god Jupiter," +
                    " the king of the gods, because of its observed size.\n"));

            mgalaxyDao.insert(new GalaxyClass(R.drawable.saturn, "Saturn" , "Saturn is the sixth planet from the Sun and the " +
                    "second-largest in the Solar System, after Jupiter. \n Average orbital speed: 9.68 km/s (6.01 mi/s) and quatorial rotation velocity: " +
                    "9.87 km/s" , "\n  Saturn is the sixth planet from the Sun and the second-largest" +
                    " in the Solar System, after Jupiter.\n  It is a gas giant with an average radius of about nine" +
                    " and a half times that of Earth.\n  [22][23] It only has one-eighth the average density of Earth;\n  however," +
                    " with its larger volume, Saturn is over 95 times more massive.[24][25][26]\n" +
                    "  The planet's most notable feature is its prominent ring system, which is composed mainly of ice particles, " +
                    "with a smaller amount of rocky debris and dust.\n  At least 83 moons[29] are known to orbit Saturn, " +
                    "of which 53 are officially named;\n  this does not include the hundreds of moonless in its rings.\n"));

            mgalaxyDao.insert(new GalaxyClass(R.drawable.uranus, "Uranus" , "Uranus is the seventh planet from the Sun, and has " +
                    "the third-largest diameter in our solar system. \n Uranus is the coldest planet in the Solar System \n Uranus is the second-least dense " +
                    "planet \n Uranus is the second-least dense planet" , "\n  Uranus is the seventh planet from the Sun.\n  Its name is a reference to the Greek god of" +
                    " the sky, Uranus, who, according to Greek mythology, was the great-grandfather of Ares (Mars), " +
                    "grandfather of Zeus (Jupiter) and father of Cronus (Saturn).\n  It has the third-largest planetary" +
                    " radius and fourth-largest planetary mass in the Solar System.\n  Uranus is similar in composition " +
                    "to Neptune, and both have bulk chemical compositions which differ from that of the larger gas" +
                    " giants Jupiter and Saturn.\n  For this reason, scientists often classify Uranus and Neptune as " +
                    "\"ice giants\" to distinguish them from the other giant planets.\n"));

            mgalaxyDao.insert(new GalaxyClass(R.drawable.neptune, "Neptune" , "Neptune is the eighth and farthest-known Solar planet" +
                    " from the Sun. In the Solar System, it is the fourth-largest planet by diameter. \n Average orbital speed: 5.43 km/s and Equatorial" +
                    " rotation velocity: 2.68 km/s" , "\n  Neptune is the eighth and farthest-known Solar planet from the Sun.\n" +
                    "  In the Solar System, it is the fourth-largest planet by diameter, the third-most-massive planet," +
                    " and the densest giant planet.\n  It is 17 times the mass of Earth, slightly more massive than " +
                    "its near-twin Uranus.\n  Neptune is denser and physically smaller than Uranus because its greater " +
                    "mass causes more gravitational compression of its atmosphere.\n  It is referred to as one of the solar" +
                    " system's two ice giant planets (the other one being its near-twin Uranus.)\n"));
            return null;
        }
    }
}
