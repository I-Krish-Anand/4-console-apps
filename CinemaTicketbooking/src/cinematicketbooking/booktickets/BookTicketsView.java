package cinematicketbooking.booktickets;

import cinematicketbooking.dto.MovieDetails;
import cinematicketbooking.dto.ShowSpecificDetails;
import cinematicketbooking.dto.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class BookTicketsView implements BookTicketsViewToController {
    private final BookTicketsControllerToView bookticketsController;

    private final Scanner input=new Scanner(System.in);

    private final Scanner dateInput=new Scanner(System.in);

    public BookTicketsView() {
        bookticketsController = new BookTicketsController(this);
    }

    public void create()  {
      getMovieDetails();
    }
    private void getMovieDetails()  {
       boolean toContinue=false;
       do {
           System.out.println("\t --->WELCOME TO PVR CINEMAS<---");
           System.out.println("1. Press 1 to Book Tickets:");
           System.out.println("2. Press 2 to View Your Booked Tickets");
           try {
               int choice = input.nextInt();
               bookticketsController.checkUserChoice(choice);
               System.out.println("Do you want to continue");
               toContinue = input.nextBoolean();
           }
           catch (Exception e){
               getMoviesNames();
           }
       }while (toContinue);
    }
    @Override
    public void getMoviesNames()  {
        bookticketsController.getMoviesNames();
    }

    @Override
    public void getYourBookedTickets(){
        System.out.println("Enter your BookingID");
        String bookingID=input.next();
        bookticketsController.getYourBookedTickets(bookingID);
    }


    @Override
    public void getMoviesNameQueryFailed() {
        System.out.println("We aren't running shows currently, Sorry");
    }

    @Override
    public void printMoviesName(ArrayList<MovieDetails> movieDetailsArrayList)  {

    boolean toContinue=false;
    do {
        System.out.print("NOW SHOWING:\t");
        for (MovieDetails movieDetails : movieDetailsArrayList) {
            System.out.print(movieDetails.getMovieName() + "    ");
        }
        input.nextLine();
        System.out.println("\nEnter movie of your Choice");
        String userMovieChoice = input.nextLine();
        System.out.println("Enter Date of your Choice dd/mm/yyyy");
        String dateOfChoice = dateInput.nextLine();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Validate Date
        if (null != dateOfChoice && dateOfChoice.trim().length() > 0) {
            LocalDate date = LocalDate.parse(dateOfChoice, format);
            toContinue=bookticketsController.checkAvaliablity(userMovieChoice, date);
        }
    }while (!toContinue);

    }

    @Override
    public void getAvaliableShows(ArrayList<ShowSpecificDetails> tempQuery)
    {
            for (ShowSpecificDetails showSpecificDetails : tempQuery) {
                System.out.println("SHOW ID: " + showSpecificDetails.getShowId() + " " + showSpecificDetails + " Seats Left: " + showSpecificDetails.getCapacity());
            }
            try {
                input.nextLine();
                System.out.println("Enter Booking Name");
                String bookingName = input.nextLine();
                System.out.println("Enter your preferred SHOW-ID");
                String userShowChoice = input.next();
                System.out.println("Enter no of Tickets");
                int noOfSeatsRequested = input.nextInt();
                getShowVaccancyDetails(bookingName, userShowChoice, noOfSeatsRequested);
            }
            catch (Exception e){
                getAvaliableShows(tempQuery);
            }
    }
    private void getShowVaccancyDetails(String bookingName,String userShowChoice,int noOfSeatsRequested){
         bookticketsController.getShowVaccancyDetails(bookingName,userShowChoice,noOfSeatsRequested);
    }

    @Override
    public void showsUserQueryFailed() {
        System.out.println("Shows aren't running at the moment");
    }

    @Override
    public void printVaccancy(User user, ShowSpecificDetails showSpecificDetails) {

        String[][]seatingArrangement=showSpecificDetails.getSeatingArrangement();
        boolean toContinue;
        do {

            System.out.print(" ");
            for (int i = 0; i < seatingArrangement[0].length; i++)
                System.out.format("%3.5s", i);
            System.out.println(" ");

            for (int i = 0; i < seatingArrangement.length; i++) {
                System.out.print((char)(i+65)+" ");
                for (int j = 0; j < seatingArrangement[0].length; j++) {
                    System.out.format("%3s", seatingArrangement[i][j]);
                }
                System.out.println();
            }
            System.out.format("\n%23s", " SCREEN\n\n");

            // Pick your seats
            System.out.println("Choose your Seats");
            String[] seatsChosen = new String[user.getNoOfTickets()];
            for (int i = 0; i < user.getNoOfTickets(); i++)
                seatsChosen[i] = input.next();
            toContinue=checkIfSeatsAreValid(showSpecificDetails, seatsChosen, user);
        }while (!toContinue);

    }


    @Override
    public void invalidShowID() {
        System.out.println("Criteria not met or you might have probably entered a wrong ID,Try again!");
    }

    @Override
    public void validChoice(ShowSpecificDetails showSpecificDetails, String[] seatsChosen, User user) {
        try {
            System.out.println("Choice Confirmed!");
            System.out.println("Continue Booking? True/false ");
            boolean confirmTickets = input.nextBoolean();
            bookingConfirmation(confirmTickets, showSpecificDetails, seatsChosen, user);
        }
        catch (Exception e){
            System.out.println("Input Mismatch");
            validChoice(showSpecificDetails,seatsChosen,user);
        }
    }
    private void bookingConfirmation(boolean confirmTickets, ShowSpecificDetails showSpecificDetails, String[] seatsChosen, User user){
        bookticketsController.bookingConfirmation(confirmTickets,showSpecificDetails,seatsChosen,user);
    }

    @Override
    public void inValidChoice() {
        System.out.println("Invalid Choice, try again!");

    }

    private  boolean checkIfSeatsAreValid(ShowSpecificDetails showSpecificDetails, String[] seatsChosen, User user){
        return bookticketsController.checkIfSeatsAreValid(showSpecificDetails,seatsChosen,user);
    }
    public void declineBooking(){
        System.out.println("Session Ended");
    }

    @Override
    public void bookingSuccess(String bookingID, String showChoice, String[] seatsChosen) {
        System.out.println("Booking Confirmed: Your Seats are");
        for(String tickets:seatsChosen)
            System.out.print(tickets+" ");
        System.out.println("\nBooking ID:"+bookingID+" "+showChoice);
    }
    public boolean dateIsInPast(){
        System.out.println("Date cannot point to past!");
        return false;
    }

    @Override
    public void printTickets(String bookingname, String bookingID, String[] seatsChosen, String showID, String time, LocalDate date) {
        System.out.println("Booking Name:"+bookingname);
        System.out.println("Booking ID:"+bookingID);
        System.out.println("Booking Confirmed: Your Seats are");
        for(String tickets:seatsChosen)
            System.out.print(tickets+" ");
        System.out.println("SCREEN ID:"+showID+" DATE:"+date+" TIME "+time);

    }


}