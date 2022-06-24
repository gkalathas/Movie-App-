package net.geoge.movieapp.repositories;

import androidx.lifecycle.LiveData;

import net.geoge.movieapp.models.MovieModel;
import net.geoge.movieapp.request.MovieApiClient;

import java.util.List;

public class MovieRepository {
    //Repositories

    private static MovieRepository instance;

    private MovieApiClient movieApiClient;

    private String mQuery;
    private int mPageNumber;


    public static MovieRepository getInstance() {
        if (instance == null) {
            instance = new MovieRepository();
        }
        return instance;

    }

    private MovieRepository(){

        movieApiClient = MovieApiClient.getInstance();
    }




    public LiveData<List<MovieModel>> getMovies(){
        return movieApiClient.getMovies();
    }

    // Calling the method in repository
    public void serachMovieApi(String query, int pageNumber){
        mQuery = query;
        mPageNumber = pageNumber;
        movieApiClient.searchMoviesApi(query, pageNumber);
    }


    public void searchNextPage(){
        serachMovieApi(mQuery, mPageNumber+1);
    }





    public LiveData<List<MovieModel>> getPop(){
        return movieApiClient.getPop();
    }

    // Calling the method in repository
    public void serachMoviePop(int pageNumber){

        mPageNumber = pageNumber;
        movieApiClient.searchMoviesPop( pageNumber);
    }

}




