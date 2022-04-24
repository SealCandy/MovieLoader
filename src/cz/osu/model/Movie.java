package cz.osu.model;
//Title;Genre;Description;Director;Actors;Year;Runtime (Minutes);Rating;Votes;Revenue (Millions)
public class Movie implements Comparable<Movie>{
    private String title;
    private String genre;
    private String description;
    private String director;
    private String actors;
    private int year;
    private int runtime;
    private double rating;
    private int votes;
    private double revenue;

    public Movie(String[] components) {
        title = components[0];
        genre = components[1];
        description = components[2];
        director = components[3];
        actors = components[4];
        year = Integer.parseInt(components[5]);
        runtime = Integer.parseInt(components[6]);
        rating = Double.parseDouble(components[7].replace(',','.'));
        votes = Integer.parseInt(components[8]);
        revenue = Double.parseDouble(components[9].replace(',','.'));
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return director;
    }

    public String getActors() {
        return actors;
    }

    public int getYear() {
        return year;
    }

    public int getRuntime() {
        return runtime;
    }

    public double getRating() {
        return rating;
    }

    public int getVotes() {
        return votes;
    }

    public double getRevenue() {
        return revenue;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
                ", actors='" + actors + '\'' +
                ", year=" + year +
                ", runtime=" + runtime +
                ", rating=" + rating +
                ", votes=" + votes +
                ", revenue=" + revenue +
                '}';
    }

    @Override
    public int compareTo(Movie m) {
        if (m.getRating() == getRating()){
            return 0;
        }
        if (m.getRating()> getRating()){
            return 1;
        }
        return -1;
    }
}