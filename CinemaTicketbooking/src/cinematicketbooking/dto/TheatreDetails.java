package cinematicketbooking.dto;

public class TheatreDetails {

    private final int noOfScreens=2;

    private final int shows=4;

    private final String theatreID="PVRGC";

    private final int scheduledDays=4;
    private final String theatreName="PVR---Guduvancheri";

    public int getNoOfScreens() {
        return noOfScreens;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public int getShows() {
        return shows;
    }

    public int getScheduledDays() {
        return scheduledDays;
    }

    public String getTheatreID() {
        return theatreID;
    }
}
