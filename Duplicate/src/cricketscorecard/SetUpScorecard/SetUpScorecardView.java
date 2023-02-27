package cricketscorecard.SetUpScorecard;

import cricketscorecard.startmatch.StartMatchView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class SetUpScorecardView implements SetUpScorecardViewToController {
    private SetUpScorecardControllerToView setupscorecardController;

    private Scanner input=new Scanner(System.in);

    SetUpScorecardView() {
        setupscorecardController = new SetUpScorecardController(this);
    }

    public static void main(String[] args) {
        SetUpScorecardView setUpScorecardView=new SetUpScorecardView();
        setUpScorecardView.create();
    }
    private void create(){
        setupscorecardController.initialSetup();
        //getMatchDetails();
        //getTeamAndPlayerDetails(MatchDetails.toss,'A');
        //getTeamAndPlayerDetails(MatchDetails.tossLostBy,'B');
        updationSuccess();
    }

    /**
     *
     * @param team - Team Name
     * @param key to differentiate teams easier, currently not in use.
     *
     * To get Team and Player details
     */
    public void getTeamAndPlayerDetails(String team,char key){

        try {
            String teamName = team;
            System.out.println("Enter Captain Name and JerseyNo:");
            String captainName = input.next();
            int captainJerseyNo = input.nextInt();
            System.out.format("%20s", teamName + " TEAM LIST\n");
            System.out.println("\n1) " + captainName + " " + captainJerseyNo + " (C)");
            LinkedHashMap<Integer, String> playerDetails = new LinkedHashMap<>();
            playerDetails.put(captainJerseyNo, captainName);
            for (int i = 0; i < 10; i++) {
                System.out.println((i + 2) + " " + " " + "JerseyNo ?" + " " + "PlayerName ?");
                playerDetails.put(input.nextInt(), input.next());
            }
            setupscorecardController.setTeamAndPlayerDetails(teamName, captainName, captainJerseyNo, playerDetails, key);
        }
        catch (Exception e){
            System.out.println("Invalid Input Format");
            getTeamAndPlayerDetails(team,key);
        }
    }

    /**
     *  To get Match details
     */
    private void getMatchDetails(){
       try {
           System.out.println("Enter Venue");
           String venue = input.next();
           System.out.println("Match Timings:");
           System.out.println(LocalDate.now());
           LocalDateTime date = LocalDateTime.now();
           System.out.println("Enter Team A Name:");
           String team1Name = input.next();
           System.out.println("Enter Team B Name:");
           String team2Name = input.next();
           System.out.println("No of overs:?");
           int oversPerinnings = input.nextInt();
           System.out.println("Toss Details: toss won by?");
           String tossWinner = input.next();
           System.out.println("Batting or Fielding?");
           String tossDecission = input.next();
           setupscorecardController.setMatchDetails(team1Name, team2Name, venue, date, oversPerinnings, tossWinner, tossDecission);
       }
       catch (Exception e){
           System.out.println("Input mismatch");
           getMatchDetails();
       }
    }

    /**
     *  When the match is ready to begin
     */

    @Override
    public void updationSuccess() {
        System.out.println("Updation Success");
        StartMatchView startMatchView=new StartMatchView();
        startMatchView.create();
    }
}