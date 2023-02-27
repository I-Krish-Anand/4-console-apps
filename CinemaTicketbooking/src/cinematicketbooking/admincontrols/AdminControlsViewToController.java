package cinematicketbooking.admincontrols;

import cinematicketbooking.dto.ShowSpecificDetails;

import java.time.LocalDate;
import java.util.HashMap;

public interface AdminControlsViewToController {

    void scheduleAddedSuccessfully(String movieName);

    void scheduleAdditionFailed();

    void printSchedule(HashMap<LocalDate, ShowSpecificDetails[][]> map);

    void viewSchedule();

    void addSchedule();

}