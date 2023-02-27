package cinematicketbooking.booktickets;

import cinematicketbooking.dto.ShowSpecificDetails;
import cinematicketbooking.dto.User;

import java.time.LocalDate;

public interface BookTicketsModelToController {

    void getMoviesNames();

    boolean checkAvaliablity(String movieName, LocalDate date);

    boolean checkIfSeatsAreValid(ShowSpecificDetails showSpecificDetails, String[] seatsChosen, User user);

    void getShowVaccancyDetails(String bookingName,String userShowChoice, int noOfSeatsRequested);

    void bookingConfirmation(ShowSpecificDetails showSpecificDetails, String[] seatsChosen, User user);

    void getYourBookedTickets(String bookingID);

}