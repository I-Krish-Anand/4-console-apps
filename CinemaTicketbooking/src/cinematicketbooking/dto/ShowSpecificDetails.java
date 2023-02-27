package cinematicketbooking.dto;

import java.util.Arrays;

public class ShowSpecificDetails extends MovieDetails{

    @Override
    public String toString() {
        return this.movieName+" Time: "+this.showTimings;
    }

    private String showId;

    private static int showNo;

    private String movieName;

    private int screenNo;

    private String showTimings;

    private int capacity=100;

    String[][]seatingArrangement=new String[10][10];

    {
        for(String[] rows: seatingArrangement)
            Arrays.fill(rows, "💺");
    }

    public void setSeatingArrangement(String[][] seatingArrangement) {
        this.seatingArrangement = seatingArrangement;
    }

    public String[][] getSeatingArrangement() {
        return seatingArrangement;
    }

    public ShowSpecificDetails(String movieName, int screenNo){
        this.movieName=movieName;
        this.screenNo=screenNo;
        showNo++;
        showId=getTheatreID()+showNo;
    }
    public String getShowId() {
        return showId;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getShowTimings() {
        return showTimings;
    }


    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setShowTimings(String showTimings) {
        this.showTimings = showTimings;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
