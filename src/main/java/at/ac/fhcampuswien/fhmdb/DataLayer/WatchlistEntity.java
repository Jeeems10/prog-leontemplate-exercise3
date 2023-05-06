package at.ac.fhcampuswien.fhmdb.DataLayer;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

//Diese Klasse soll eine Datenbanktabelle werden
//wenn DatabaseTable rot markiert ist, dann entweder Library oder es fehlt etwas in module - irgendein requires

@DatabaseTable(tableName = "watchlist")
public class WatchlistEntity {
    @DatabaseField(generatedId = true) // Datenbank erstellt ID von sich aus, müssen es nicht selber machen
    private long id;

    @DatabaseField
    private String apiId;
    @DatabaseField // Attribute in der Tablle
    private String title;
    @DatabaseField
    private String description;
    @DatabaseField
    private String genres; // muss noch schauen wie das geht
    @DatabaseField
    private int releaseYear;
    @DatabaseField
    private String imgUrl;
    @DatabaseField
    private int lengthInMinutes;
    @DatabaseField
    private double rating;

    public WatchlistEntity(){
    }

    public WatchlistEntity( String apiId, String title, String description, String genres, int releaseYear, String imgUrl, int lengthInMinutes, double rating) {
        this.apiId = apiId;
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.releaseYear = releaseYear;
        this.imgUrl = imgUrl;
        this.lengthInMinutes = lengthInMinutes;
        this.rating = rating;
    }

    /*public String genresToString(List<Genre> genres){

    }*/

    public long getId() {
        return id;
    }

    public String getApiId() {
        return apiId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGenres() {
        return genres;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "WatchlistEntity{" +
                "id=" + id +
                ", apiId='" + apiId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", genres='" + genres + '\'' +
                ", releaseYear=" + releaseYear +
                ", imgUrl='" + imgUrl + '\'' +
                ", lengthInMinutes=" + lengthInMinutes +
                ", rating=" + rating +
                '}';
    }
}
