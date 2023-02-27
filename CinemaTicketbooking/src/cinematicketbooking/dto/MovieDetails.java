package cinematicketbooking.dto;

import java.util.TreeSet;

public class MovieDetails  extends TheatreDetails {


    private String movieName;

    private TreeSet<Integer> screensRequested;

    private boolean[]shows=new boolean[getNoOfScreens()];

    public MovieDetails(String movieName, TreeSet<Integer> screensRequested,boolean[]shows) {
        this.movieName = movieName;
        this.screensRequested = screensRequested;
        this.shows=shows;

    }
    MovieDetails(){

    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public TreeSet<Integer> getScreensRequested() {
        return screensRequested;
    }

    public String getMovieName() {
        return movieName;
    }
}
