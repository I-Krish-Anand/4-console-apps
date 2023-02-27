package cinematicketbooking.booktickets;

import cinematicketbooking.dto.MovieDetails;
import cinematicketbooking.dto.ShowSpecificDetails;
import cinematicketbooking.dto.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookTicketsController implements BookTicketsControllerToView, BookTicketsControllerToModel {
    private final BookTicketsViewToController bookticketsView;
    private final BookTicketsModelToController bookticketsModel;

    BookTicketsController(BookTicketsView bookticketsView) {
        this.bookticketsView = bookticketsView;
        bookticketsModel = new BookTicketsModel(this);
    }

    @Override
    public void getMoviesNames()  {
        bookticketsModel.getMoviesNames();
    }

    @Override
    public boolean checkAvaliablity(String movieName, LocalDate date) {
        if(date.isBefore(LocalDate.now()))
            return bookticketsView.dateIsInPast();
        else
            return bookticketsModel.checkAvaliablity(movieName,date);
    }

    @Override
    public void printMoviesName(ArrayList<MovieDetails> movieDetailsArrayList)  {
        bookticketsView.printMoviesName(movieDetailsArrayList);
    }

    @Override
    public void getMoviesNameQueryFailed() {
        bookticketsView.getMoviesNameQueryFailed();
    }

    @Override
    public void getAvaliableShows(ArrayList<ShowSpecificDetails> tempQuery) {
        bookticketsView.getAvaliableShows(tempQuery);
    }

    @Override
    public void showsUserQueryFailed() {
        bookticketsView.showsUserQueryFailed();
    }

    @Override
    public void printVaccancy(User user, ShowSpecificDetails showSpecificDetails) {
        bookticketsView.printVaccancy(user,showSpecificDetails);
    }

    @Override
    public void invalidShowID() {
        bookticketsView.invalidShowID();
    }

    @Override
    public void validChoice(ShowSpecificDetails showSpecificDetails, String[] seatsChosen, User user) {
        bookticketsView.validChoice(showSpecificDetails,seatsChosen,user);
    }

    @Override
    public void inValidChoice() {
        bookticketsView.inValidChoice();
    }

    @Override
    public void bookingSuccess(String bookingID, String showChoice, String[] seatsChosen) {
        bookticketsView.bookingSuccess(bookingID,showChoice,seatsChosen);
    }

    @Override
    public void printTickets(String bookingname, String bookingID, String[] seatsChosen, String showID, String time, LocalDate date) {
        bookticketsView.printTickets(bookingname,bookingID,seatsChosen,showID,time,date);
    }

    @Override
    public boolean checkIfSeatsAreValid(ShowSpecificDetails showSpecificDetails, String[] seatsChosen, User user) {
        return  bookticketsModel.checkIfSeatsAreValid(showSpecificDetails,seatsChosen,user);
    }

    @Override
    public void getShowVaccancyDetails(String bookingName,String userShowChoice, int noOfSeatsRequested) {
        bookticketsModel.getShowVaccancyDetails( bookingName,userShowChoice,noOfSeatsRequested);
    }

    @Override
    public void bookingConfirmation(boolean confirmTickets, ShowSpecificDetails showSpecificDetails, String[] seatsChosen, User user) {
        if(confirmTickets)
            bookticketsModel.bookingConfirmation(showSpecificDetails,seatsChosen,user);
        else
            declineBooking();
    }

    @Override
    public void getYourBookedTickets(String bookingID) {
        bookticketsModel.getYourBookedTickets(bookingID);
    }

    @Override
    public void checkUserChoice(int choice) {
        switch (choice){

            case 1-> bookticketsView.getMoviesNames();

            case 2-> bookticketsView.getYourBookedTickets();

            default -> System.out.println("Invalid choice");
        }
    }

    private void declineBooking(){
        bookticketsView.declineBooking();
    }
}