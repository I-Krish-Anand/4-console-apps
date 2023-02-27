package cinematicketbooking.booktickets;

import cinematicketbooking.dto.MovieDetails;
import cinematicketbooking.dto.ShowSpecificDetails;
import cinematicketbooking.dto.User;
import cinematicketbooking.repository.TicketRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookTicketsModel implements BookTicketsModelToController {
    BookTicketsControllerToModel bookticketsController;

    BookTicketsModel(BookTicketsController bookticketsController) {
        this.bookticketsController = bookticketsController;
    }

    @Override
    public void getMoviesNames()  {
        boolean flag= TicketRepository.getInstance().getMoviesNames();
        if(flag)
            printMoviesName();
        else
            getMoviesNameQueryFailed();

    }
    private void printMoviesName()  {
        ArrayList<MovieDetails>movieDetailsArrayList=TicketRepository.getInstance().printMoviesName();
        bookticketsController.printMoviesName(movieDetailsArrayList);
    }
    private void getMoviesNameQueryFailed(){
         bookticketsController.getMoviesNameQueryFailed();
    }

    @Override
    public boolean checkAvaliablity(String movieName, LocalDate date) {
         boolean flag=TicketRepository.getInstance().checkAvaliablity(movieName,date);
         if(flag)
             getAvaliableShows();
         else
             showsUserQueryFailed();

         return flag;

    }
    private void getAvaliableShows(){
      ArrayList<ShowSpecificDetails>tempQuery=TicketRepository.getInstance().getAvaliableShows();
      bookticketsController.getAvaliableShows(tempQuery);
    }
    private void showsUserQueryFailed(){
        bookticketsController.showsUserQueryFailed();
    }

    @Override
    public void getShowVaccancyDetails(String bookingName,String userShowChoice, int noOfSeatsRequested) {
        Object[] dualObj=TicketRepository.getInstance().getShowVaccancyDetails(bookingName,userShowChoice,noOfSeatsRequested);
        if(dualObj==null)
            invalidShowID();
        else
            printVaccancy((User) dualObj[0], (ShowSpecificDetails) dualObj[1]);

    }

    @Override
    public void bookingConfirmation(ShowSpecificDetails showSpecificDetails, String[] seatsChosen, User user) {
         TicketRepository.getInstance().bookingConfirmation(showSpecificDetails,seatsChosen,user);
         bookingSuccess(user.getBookingID(),user.getShowChoice().getShowId(),seatsChosen);
    }

    @Override
    public void getYourBookedTickets(String bookingID) {
        User user=TicketRepository.getInstance().getYourBookedTickets(bookingID);

        if(user!=null)
            bookticketsController.printTickets(user.getBookingName(),user.getBookingID(),user.getTicketsChosen(),user.getShowChoice().getShowId(),user.getShowChoice().getShowTimings(),user.getDate());
        else
            bookticketsController.inValidChoice();
    }

    private void bookingSuccess(String bookingID, String showChoice, String[] seatsChosen){
        bookticketsController.bookingSuccess(bookingID,showChoice,seatsChosen);
    }

    @Override
    public boolean checkIfSeatsAreValid(ShowSpecificDetails showSpecificDetails, String[] seatsChosen, User user) {
        ShowSpecificDetails  checkNull=TicketRepository.getInstance().checkIfSeatsAreValid(showSpecificDetails,seatsChosen,user);
        if(checkNull!=null) {
            validChoice(showSpecificDetails, seatsChosen, user);
            return true;
        }
        else {
            inValidChoice();
            return false;
        }
    }

    private void validChoice(ShowSpecificDetails showSpecificDetails, String[] seatsChosen, User user){
        bookticketsController.validChoice(showSpecificDetails,seatsChosen,user);
    }
    private void inValidChoice(){
        bookticketsController.inValidChoice();
    }

    private void printVaccancy(User user, ShowSpecificDetails showSpecificDetails){
        bookticketsController.printVaccancy(user,showSpecificDetails);
    }
    private void invalidShowID(){
       bookticketsController.invalidShowID();
    }
}