package cinematicketbooking.admincontrols;

import cinematicketbooking.dto.ShowSpecificDetails;
import cinematicketbooking.repository.TicketRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.TreeSet;

public class AdminControlsController implements AdminControlsControllerToView, AdminControlsControllerToModel {
    private final AdminControlsViewToController admincontrolsView;
    private final AdminControlsModelToController admincontrolsModel;

    AdminControlsController(AdminControlsView admincontrolsView) {
        this.admincontrolsView = admincontrolsView;
        admincontrolsModel = new AdminControlsModel(this);
    }

    @Override
    public void addSchedule(String movieName, TreeSet<Integer> scrnChoice, boolean[] shows) {
        admincontrolsModel.addSchedule(movieName,scrnChoice,shows);
    }
    public void scheduleAddedSuccessfully(String movieName){
       admincontrolsView.scheduleAddedSuccessfully(movieName);
    }
    public void scheduleAdditionFailed(){
       admincontrolsView.scheduleAdditionFailed();
    }

    @Override
    public void getSchedule() {
       admincontrolsModel.getSchedule();
    }

    @Override
    public void checkUserChoice(int choice) {
        switch (choice) {
            case 1 -> admincontrolsView.viewSchedule();

            case 2 -> admincontrolsView.addSchedule();

            default-> System.out.println("Invalid Input");

        }
    }

    @Override
    public void printSchedule(HashMap<LocalDate, ShowSpecificDetails[][]> map) {
        admincontrolsView.printSchedule(map);
    }
}