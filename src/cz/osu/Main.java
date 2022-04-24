package cz.osu;

import cz.osu.dataProcessing.MovieManager;
import cz.osu.model.Movie;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// IMDBMovies
        MovieManager mm = new MovieManager();
        mm.loadFromCsv("IMDBMovies.csv");
   //     System.out.println(mm.getHighestRevenueMovie());
   //     System.out.println("###############HighestBois#############################");
   //     ArrayList<Movie> highestRevenueMovies =  mm.getHighestRevenueMovies(5,true);
//        for (Movie movie : highestRevenueMovies){
//            System.out.println(movie.getTitle());
//        }
 //       System.out.println("##############LowestBois#####################");
  //      ArrayList<Movie> lowestRevenueMovies =  mm.getLowestRevenueMovies(5,true);
//        for (Movie movie : lowestRevenueMovies){
//            System.out.println(movie.getTitle());
//        }
        System.out.println("##############HighRatingBois#####################");
        ArrayList<Movie> highestRatingMovies =  mm.getHighestRatingMovies(5, true);
//        for (Movie movie : highestRatingMovies){
//            System.out.println(movie.getTitle());
//        }
        ArrayList<Movie> highestRatingMoviesMerge = mm.getHighestRatingMovieMergeSort(5,true);
              for (Movie movie : highestRatingMoviesMerge){
          System.out.println(movie.getTitle());
      }
        ArrayList<Movie> highestRatingMoviesQuick = mm.getHighestRatingMovieQuickSort(5,true);
        for (Movie movie : highestRatingMoviesQuick){
            System.out.println(movie.getTitle());
        }
        ArrayList<Movie> highestRatingMoviesLib = mm.getHighestRatingMovieLib(5,true);
        for (Movie movie : highestRatingMoviesLib){
            System.out.println(movie.getTitle());
        }
              //     System.out.println("##############LowRatingBois#####################");
   //     ArrayList<Movie> lowestRatingMovies =  mm.getLowestRatingMovies(5,true);
//        for (Movie movie : lowestRatingMovies){
//            System.out.println(movie.getTitle());
//        }
     //   System.out.println("##############ShortestBois#####################");
    //    ArrayList<Movie> shortestRuntime =  mm.getShortestMovies(5,true);
//        for (Movie movie : shortestRuntime){
//            System.out.println(movie.getTitle() + " " + movie.getRuntime());
//        }
      //  mm.recursion(100);
    }
}
