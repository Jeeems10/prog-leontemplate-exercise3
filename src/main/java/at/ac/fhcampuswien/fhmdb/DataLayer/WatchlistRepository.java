package at.ac.fhcampuswien.fhmdb.DataLayer;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class WatchlistRepository {
    Dao<WatchlistEntity,Long> dao;

    public WatchlistRepository(){
        this.dao = Database.getDatabase().getDao();
    }

    public void  addToWatchlist(Movie movie) throws SQLException {
        WatchlistEntity movies = new WatchlistEntity("ey", movie.getTitle(), movie.getDescription(), "movie.getGenres()", movie.getReleaseYear(), movie.getImgUrl(), movie.getLengthInMinutes(), movie.getRating());
        dao.create(movies);
    }

    public void removeFromWatchlist(WatchlistEntity movie) throws SQLException {
        WatchlistEntity movies = new WatchlistEntity( movie.getApiId(), movie.getTitle(), movie.getDescription(), movie.getGenres(), movie.getReleaseYear(), movie.getImgUrl(), movie.getLengthInMinutes(), movie.getRating());
        dao.delete(movies);
    }

    public List<WatchlistEntity> getAll() throws SQLException {
        return dao.queryForAll(); // sollte mir vll durchlesen, was das macht
    }
}
