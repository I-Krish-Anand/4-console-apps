package cinematicketbooking.admincontrols;

import java.util.TreeSet;

public interface AdminControlsModelToController {
    void addSchedule(String movieName, TreeSet<Integer> noOfScreens, boolean[] shows);

    void getSchedule();
}