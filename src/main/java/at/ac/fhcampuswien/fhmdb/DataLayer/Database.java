package at.ac.fhcampuswien.fhmdb.DataLayer;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

//unsere H2 datenbank müssen wir mit ORN kite verbinden
//Singleton Pattern führt dazu, dass man eine Klasse nur einmal instanzieren kann oder Object einer Klasse
public class Database {
    public static final String DB_URL = "jdbc:h2:file: ./db/watchlistdb";

    //H2 Datenbank schützen mit User und PW -ist eh wurscht welches weil Lokal
    public static final String username ="ManuelMindic";
    public static final String password ="MitM?";

    private static ConnectionSource connectionSource;

    //mit Dao's kann ich etwas mit den Tabellen machen zbp eine Operation darauf ausführen
    //In WatchlistEntity ist die ID ein Long, wäre es String dann String oder int
    private Dao<WatchlistEntity, Long> dao;

    private static Database instance;

    //private kann mit new kein neues Object erstellen
    private Database(){
        try{
            createConnectionSource(); // verbindung hergestellt
            dao = DaoManager.createDao(connectionSource, WatchlistEntity.class);
            createTables(); //Tabelle erstelle, wenns nicht schon existiert
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    //testen aber iwas ist falsch
    public void testDB() throws SQLException {
        WatchlistEntity watchlist = new WatchlistEntity("1", "James Programmiert", "er lernt Prog FrFr", "Drama", 2023,"..." , 98,2);
        getDao().create(watchlist); // dao
    }


    public static Database getDatabase(){
        if(instance==null){
            instance = new Database();
        }
        return instance;
    }


    private static void createConnectionSource() throws SQLException {
        connectionSource = new JdbcConnectionSource(DB_URL, username, password); // Bei erstellung Exception erschienen
    }

    public static ConnectionSource getConnectionSource() {
        return connectionSource;
    }

    public static void createTables() throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, WatchlistEntity.class);
    }

    public Dao<WatchlistEntity, Long> getDao() {
        return this.dao;
    }
}
