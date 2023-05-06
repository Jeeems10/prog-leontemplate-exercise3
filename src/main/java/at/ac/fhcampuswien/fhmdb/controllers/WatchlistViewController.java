package at.ac.fhcampuswien.fhmdb.controllers;

import at.ac.fhcampuswien.fhmdb.DataLayer.WatchlistEntity;
import at.ac.fhcampuswien.fhmdb.DataLayer.WatchlistRepository;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WatchlistViewController extends HomeController{

    @FXML
    public JFXListView movieWatchListView;

    WatchlistRepository repo;
    public void initiale() throws SQLException {

        System.out.println("Watchlist" );

        repo = new WatchlistRepository();
        List<WatchlistEntity> watchlist = new ArrayList<>();

        try {
            List<WatchlistEntity> watchlists = repo.getAll();
        } catch (SQLException e){

        }

        for( WatchlistEntity item : watchlist){
            System.out.println(item);
        }

    }
}
