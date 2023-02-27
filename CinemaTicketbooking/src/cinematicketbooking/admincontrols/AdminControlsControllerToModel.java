package cinematicketbooking.admincontrols;

import cinematicketbooking.dto.ShowSpecificDetails;

import java.time.LocalDate;
import java.util.HashMap;

public interface AdminControlsControllerToModel {

    void scheduleAddedSuccessfully(String movieName);

    void scheduleAdditionFailed();

    void printSchedule(HashMap<LocalDate, ShowSpecificDetails[][]> map);

}