package cz.osu.dataProcessing;

import cz.osu.model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MovieManager {
    private ArrayList<Movie> movies;
    private long currentTime;
    public  MovieManager(){
        movies = new ArrayList<>();
    }

    public void loadFromCsv(String fileName){
        movies.clear();
        ArrayList<String> lines = FileManager.readCsv(fileName);
        for(String line : lines.subList(1, lines.size())){
            String[] components = line.split(";");
            if(components.length == 10){
                try{
                    movies.add(new Movie(components));
                }catch (Exception ex){

                }
            }
        }
    }
    public Movie getHighestRevenueMovie(){
        Movie ret = null;
        for(Movie movie : movies){
            if(ret == null || ret.getRevenue() < movie.getRevenue()){
                ret=movie;
            }
        }
        return ret;
    }

    private void setTime(){
        currentTime = System.nanoTime();
    }
    private void  printTime(String name){
        long endTime = System.nanoTime();
        System.out.println(name + " " + Long.toString(endTime-currentTime));
    }
    //Bubble sort algorithm
    public ArrayList<Movie> getHighestRevenueMovies(int count, boolean printTime){
        setTime();
        for (int i = 0; i < movies.size(); i++) {
            boolean change = false;
            for (int j = 0; j < movies.size() - 1; j++) {
                if (movies.get(j).getRevenue() < movies.get(j+1).getRevenue()){
                    //Movie tmp = movies.get(j);
                    //movies.set(j, movies.get(j+1));
                    //movies.set(j+1,tmp);
                    Collections.swap(movies,j,j+1);
                    change = true;
                }
                }
            if(!change){
                break;
            }
        }
        long endTime = System.nanoTime();
        if(printTime){
            printTime("Bubble sort");
        }
        return new ArrayList<>(movies.subList(0,count ));
    }
// bubble sort but reverse without optimization
    public ArrayList<Movie> getLowestRevenueMovies(int count, boolean printTime){
        setTime();
        for (int i = 0; i < movies.size(); i++) {
            for (int j = 0; j < movies.size() - 1 - i; j++) {
                if (movies.get(j).getRevenue() > movies.get(j+1).getRevenue()){
                    Collections.swap(movies,j,j+1);
                }
            }
        }
        long endTime = System.nanoTime();
        if(printTime){
            printTime("Unoptimized bubble sort");
        }
        return new ArrayList<>(movies.subList(0,count ));
    }
// selection sort
    public ArrayList<Movie> getHighestRatingMovies(int count, boolean printTime){
        setTime();
        for (int i = 0; i < movies.size() -1 ; i++) {
            int maxIndex = i;
            for (int j = i+1; j < movies.size(); j++) {
                if(movies.get(j).getRating() > movies.get(maxIndex).getRating()){
                    maxIndex = j;
                }
            }
            if(maxIndex != i){
                Collections.swap(movies,maxIndex,i);
            }
        }
        if(printTime){
            printTime("selection sort");
        }
        return new ArrayList<>(movies.subList(0,count));
    }

    public ArrayList<Movie> getLowestRatingMovies(int count, boolean printTime){
        setTime();
        for (int i = 0; i < movies.size() -1 ; i++) {
            int minIndex = i;
            for (int j = i+1; j < movies.size(); j++) {
                if(movies.get(j).getRating() < movies.get(minIndex).getRating()){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                Collections.swap(movies,minIndex,i);
            }
        }
        long endTime = System.nanoTime();
        if(printTime){
            printTime("selection sort lowest: ");
        }
        return new ArrayList<>(movies.subList(0,count));
    }
// insert sort
    public ArrayList<Movie> getShortestMovies(int count, boolean printTime){
        setTime();
        for (int i = 1; i < movies.size()-1; i++) {
            int j = i;
            while (j > 0 && movies.get(j-1).getRuntime() > movies.get(j).getRuntime()){
                Collections.swap(movies,j-1,j);
                j--;
            }
        }
        if (printTime){
            printTime("Insert sort: ");
        }
        return new ArrayList<>(movies.subList(0,count));
    }
// merge sort
    public ArrayList<Movie> getHighestRatingMovieMergeSort(int count, boolean printTime){
        setTime();
        Movie[] auxArray = new Movie[movies.size()];
        mergeSort(auxArray,0,movies.size()-1);
        if(printTime){
            printTime("merge sort");
        }
        ArrayList<Movie>ret = new ArrayList<>();
        Collections.addAll(ret,auxArray);
        return new ArrayList<>(ret.subList(0,count));
    }
    private void  mergeSort(Movie[] auxArray, int start, int end){
        if (start == end){
            return;
        }
        int middle = (start+end) /2;
        mergeSort(auxArray,start,middle);
        mergeSort(auxArray, middle+1,end);
        merge(auxArray,start,middle,end);
    }

    private void  merge(Movie[] auxArray, int start, int middle, int end){
        int leftIndex = start;
        int rightIndex = middle + 1;
        int currentIndex = start;

        while (leftIndex <= middle && rightIndex <= end){
            if (movies.get(leftIndex).getRating() > movies.get(rightIndex).getRating()){
                auxArray[currentIndex] = movies.get(leftIndex);
                leftIndex ++;
            }else {
                auxArray[currentIndex] = movies.get(rightIndex);
                rightIndex++;
            }
            currentIndex++;
        }
        while (leftIndex <= middle){
            auxArray[currentIndex] = movies.get(leftIndex);;
            currentIndex++;
            leftIndex++;
        }
        while (rightIndex <= end){
            auxArray[currentIndex] = movies.get(rightIndex);;
            currentIndex++;
            rightIndex++;
        }
    }
// quick sort
    public ArrayList<Movie> getHighestRatingMovieQuickSort(int count, boolean printTime){
        setTime();
        quickSort(0, movies.size()-1);
        if (printTime){
            printTime("Quick sort");
        }
        return new ArrayList<>(movies.subList(0,count));
    }

    private void quickSort(int start, int end){
        if(start == end){
            return;
        }
        int pivot = start;

        for (int i = start + 1; i < end; i++) {
            if (movies.get(i).getRating() > movies.get(start).getRating()){
                Collections.swap(movies,i,++pivot);
            }
        }
        Collections.swap(movies,start,pivot);
        quickSort(start,pivot);
        quickSort(pivot+1,end);
    }

//best sorting
    public  ArrayList<Movie> getHighestRatingMovieLib(int count, boolean printTime){
        setTime();
        //movies.sort(Comparator.comparing(Movie::getRating).reversed());
        Collections.sort(movies);
        if (printTime){
            printTime("Library quick sort");
        }
        return new ArrayList<>(movies.subList(0,count));
    }


    public void  recursion(int i){
        if (i == 0){
            return;
        }
        System.out.println(i);
        recursion(i - 1);
    }
}
