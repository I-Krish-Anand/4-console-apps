package cinematicketbooking.admincontrols;

import java.util.TreeSet;

public interface AdminControlsControllerToView {
    void addSchedule(String movieName, TreeSet<Integer> noOfScreens, boolean[] shows);

    void getSchedule();

    void checkUserChoice(int choice);
}