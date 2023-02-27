package cricketscorecard.startmatch;

import cricketscorecard.dto.*;

import java.util.Scanner;

public class StartMatchView implements StartMatchViewToController {
    private final StartMatchControllerToView startmatchController;

    private final Scanner input=new Scanner(System.in);

    public StartMatchView() {
        startmatchController = new StartMatchController(this);
    }

    public void create(){
      tossDetails();
    }

    /**
     *
     * @param battingTeam
     * @param bowlingTeam
     * To get Striker and Non Striker details at the
     */
    public void beginMatch(String battingTeam, String bowlingTeam){

        System.out.println("\t\tTEAM:"+battingTeam);
        startmatchController.getTeamDetails(battingTeam);
        startmatchController.getBattingScorecard(battingTeam);
        System.out.println("Enter Striker Name");
        String striker=input.next();
        System.out.println("Enter Jersey No:");
        int jersyNo1=input.nextInt();
        System.out.println("Enter Non Striker Name");
        String nonStriker=input.next();
        System.out.println("Enter Jersey No:");
        int jersyNo2=input.nextInt();
        startmatchController.getbatsmanDetails(striker,jersyNo1,nonStriker,jersyNo2,battingTeam,bowlingTeam,new InningsScorecard());

    }

    /**
     *

     * @param battingTeam
     * @param bowlingTeam
     * @param inningsScorecard
     *
     * To get bowler details for a new over
     */
    private void newOver(PlayerDetails[] playerDetails,String battingTeam,String bowlingTeam, InningsScorecard inningsScorecard){

       try {
           while (inningsScorecard.getOversUp() < MatchDetails.oversPerInnings && inningsScorecard.getWicketsDown() < 10 && inningsScorecard.getTeamScore() <= InningsScorecard.toChase) {

               System.out.println("\t\tTEAM:" + bowlingTeam);
               startmatchController.getTeamDetails(bowlingTeam);
               startmatchController.getBowlingScorecard(bowlingTeam);
               System.out.println("Enter bowler Name");
               String bowlerName = input.next();
               System.out.println("Enter Jersey NO:");
               int jerseyNo = input.nextInt();
               OverDetails thisOver = new OverDetails();
               startmatchController.getbowlerDetails(bowlerName, jerseyNo, battingTeam, bowlingTeam, playerDetails, inningsScorecard, thisOver);

           }

           if (InningsScorecard.toChase != Integer.MAX_VALUE) {
               if (inningsScorecard.getTeamScore() > InningsScorecard.toChase)
                   System.out.println(battingTeam + " WON");
               else
                   System.out.println(bowlingTeam + " WON");
           }
           startmatchController.toChase(inningsScorecard.getTeamScore());
       }
       catch (Exception e){
           System.out.println("Invalid Input");
           newOver(playerDetails,battingTeam,bowlingTeam,inningsScorecard);
       }
    }

    /**
     * @param bowler object points to current bowler

     * @param inningsScorecard
     * @param battingTeam
     * @param bowlingTeam
     *
     * Start new over
     * @param thisOver object points to reference of current over
     */
    private void beginNewOver(PlayerDetails bowler, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, String battingTeam, String bowlingTeam, OverDetails thisOver){

       try {
           while (thisOver.getLegalDeliveries() < 6 && inningsScorecard.getWicketsDown() < 10 && inningsScorecard.getTeamScore() <= InningsScorecard.toChase) {
               System.out.println("Over:" + inningsScorecard.getOversUp() + " " + "  Enter 1-wide | 2-Noball | 3-dot | 4-Four | 5-Byes Conceded | 6-Sixer | 7-Run Conceded | 8-Wicket");
               int choice = input.nextInt();
               startmatchController.overInput(thisOver, choice, bowler, playerDetails, inningsScorecard, battingTeam, bowlingTeam);
               printScore(bowler, playerDetails, inningsScorecard, battingTeam, bowlingTeam, thisOver.getLegalDeliveries(), thisOver);
           }
           startmatchController.swap(playerDetails);
           inningsScorecard.setOversUp(inningsScorecard.getOversUp() + 1);
           startmatchController.setRunRate(inningsScorecard);
           startmatchController.setOversBowled(bowler);
           startmatchController.getBattingScorecard(battingTeam);
       }
       catch (Exception e){
           System.out.println("Invalid Input");
           beginNewOver(bowler,playerDetails,inningsScorecard,battingTeam,bowlingTeam,thisOver);
       }

    }

    /**
     *
     * @param bowler
     *
     * @param inningsScorecard
     * @param battingTeam
     * @param bowlingTeam
     * @param ballNo
     * @param thisOver
     *
     * To Print Score;
     */
    public void printScore(PlayerDetails bowler, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard,String battingTeam,String bowlingTeam,int ballNo,OverDetails thisOver){
        System.out.print("\nScore:"+battingTeam+" "+inningsScorecard.getTeamScore()+"|"+inningsScorecard.getWicketsDown()+" "+inningsScorecard.getOversUp()+"."+(ballNo)+" ");

        if(InningsScorecard.toChase!=Integer.MAX_VALUE)
            System.out.println("Required Runs To Win:"+(InningsScorecard.toChase-inningsScorecard.getTeamScore()));

        System.out.print(playerDetails[0].getPlayersName()+"* "+playerDetails[0].getRunsScored()+"("+playerDetails[0].getBallsFaced()+")"+" ");
        System.out.print(playerDetails[1].getPlayersName()+" "+playerDetails[1].getRunsScored()+"("+playerDetails[1].getBallsFaced()+")"+" ");
        System.out.print(bowler.getPlayersName()+" "+bowler.getOversBowled()+"."+(ballNo)+" "+bowler.getRunsConceded()+" "+bowler.getWickets());
        System.out.println("  Timeline:"+thisOver.getBallHistory()+"\n");
    }
    private void tossDetails(){
        startmatchController.tossDetails();
    }
    public int getRunsConceded(){
        System.out.println("Enter runs conceded:");
        return input.nextInt();
    }

    @Override
    public void querySuccess(PlayerDetails playerDetails){

    }

    @Override
    public void queryFailed() {
        System.out.println("Invalid Player Details");
        startmatchController.tossDetails();
    }

    @Override
    public void printTeamDetails(TeamDetails team) {
        int i=1;
        for(PlayerDetails playerDetails:team.getPlayers())
            System.out.println(i++ +")  JERSEY NO:"+playerDetails.getJerseyNo()+" "+playerDetails.getPlayersName());

    }

    @Override
    public void printBattingScorecard(TeamDetails teamDetails)
    {
        System.out.format("%60s","BATTING SCORECARD\n\n");
        for(PlayerDetails playerDetails:teamDetails.getPlayers())
        {
            System.out.format("%15s %10s %10s %5s %5s %5s %5s %5s %5s",playerDetails.getPlayersName(),playerDetails.getRunsScored(),playerDetails.getBallsFaced(),"   FOURS:  ",playerDetails.getFours(),"   SIXES:   ",playerDetails.getSixes(),"   NOTOUT? ",playerDetails.isNotOut());
            System.out.println();
        }

    }

    @Override
    public void printBowlingScorecard(TeamDetails teamDetails) {

        System.out.println();
        for (PlayerDetails playerDetails:teamDetails.getPlayers()){
            if(playerDetails.getOversBowled()>0)
             System.out.format("%15s %10s %10s %5s %5s %5s %5s",playerDetails.getPlayersName()," OVERS: ",playerDetails.getOversBowled()," RUNS:",playerDetails.getRunsConceded()," WICKETS:",playerDetails.getWickets()+"\n");
        }
    }

    @Override
    public void openingBatsmanNameValid(PlayerDetails[] playerDetails, String battingTeam,String bowlingTeam, InningsScorecard inningsScorecard) {
        newOver(playerDetails,battingTeam,bowlingTeam,inningsScorecard);
    }




    public boolean getnewBatsmanDetails(PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, String battingTeam, String bowlingTeam){

        String newBatsmanName=null;
        int jersyNo=0;
        try {
            System.out.println("Enter new Batsman:");
            newBatsmanName = input.next();
            System.out.println("Enter new Batsman JersyNo:");
            jersyNo = input.nextInt();
        }
        catch (Exception e){
            getnewBatsmanDetails(playerDetails,inningsScorecard,battingTeam,bowlingTeam);
        }
        finally {
            return startmatchController.newBatsman(jersyNo, newBatsmanName, playerDetails, inningsScorecard, battingTeam, bowlingTeam);

        }
    }

    @Override
    public void bowlerDetailsVaild(PlayerDetails bowler, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, String battingTeam, String bowlingTeam, OverDetails thisOver) {
        beginNewOver(bowler,playerDetails,inningsScorecard,battingTeam,bowlingTeam,thisOver);
    }
}