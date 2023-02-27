package cricketscorecard.startmatch;
import cricketscorecard.dto.*;



public class StartMatchController implements StartMatchControllerToView, StartMatchControllerToModel {
    private StartMatchViewToController startmatchView;
    private StartMatchModelToController startmatchModel;

    StartMatchController(StartMatchView startmatchView) {
        this.startmatchView = startmatchView;
        startmatchModel = new StartMatchModel(this);
    }

    @Override
    public void tossDetails() {
        if(MatchDetails.tossDecision.equals("Batting"))
            startmatchView.beginMatch(MatchDetails.toss,MatchDetails.tossLostBy);
        else
            startmatchView.beginMatch(MatchDetails.tossLostBy,MatchDetails.toss);

        if(MatchDetails.tossDecision.equals("Batting"))
            startmatchView.beginMatch(MatchDetails.tossLostBy,MatchDetails.toss);
        else
            startmatchView.beginMatch(MatchDetails.toss,MatchDetails.tossLostBy);
    }
    public void overInput(OverDetails thisOver, int choice, PlayerDetails bowler, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, String battingTeam, String bowlingTeam) {

    switch (choice) {

        case 1 -> {
            thisOver.setNoOfWides(thisOver.getNoOfWides()+1);
            thisOver.setRunsConceded(thisOver.getRunsConceded()+1);
            thisOver.getBallHistory().add("WIDE");
            bowler.setRunsConceded(bowler.getRunsConceded()+1);
            inningsScorecard.setTeamScore(inningsScorecard.getTeamScore()+1);

        }
        case 2 -> {
            thisOver.setNoBalls(thisOver.getNoBalls()+1);
            thisOver.setRunsConceded(thisOver.getRunsConceded()+1);
            thisOver.getBallHistory().add("NB");
            bowler.setRunsConceded(bowler.getRunsConceded()+1);
            inningsScorecard.setTeamScore(inningsScorecard.getTeamScore()+1);

        }
        case 3 -> {
            thisOver.setNoOfDots(thisOver.getNoOfDots()+1);
            thisOver.getBallHistory().add(".");
            playerDetails[0].setBallsFaced(playerDetails[0].getBallsFaced()+1);
            thisOver.setLegalDeliveries(thisOver.getLegalDeliveries()+1);

        }
        case 4 -> {
            thisOver.setRunsConceded(thisOver.getRunsConceded()+4);
            thisOver.setNoOfFours(thisOver.getNoOfFours()+1);
            thisOver.getBallHistory().add("4");
            bowler.setRunsConceded(bowler.getRunsConceded()+4);
            playerDetails[0].setRunsScored(playerDetails[0].getRunsScored()+4);
            playerDetails[0].setBallsFaced(playerDetails[0].getBallsFaced()+1);
            playerDetails[0].setFours(playerDetails[0].getFours()+1);
            inningsScorecard.setTeamScore(inningsScorecard.getTeamScore()+4);
            thisOver.setLegalDeliveries(thisOver.getLegalDeliveries()+1);

        }
        case 5 -> {
            int temp=startmatchView.getRunsConceded();
            thisOver.setRunsConceded(thisOver.getRunsConceded()+temp);
            thisOver.setByes(thisOver.getByes()+temp);
            thisOver.getBallHistory().add(temp + "B");
            playerDetails[0].setBallsFaced(playerDetails[0].getBallsFaced()+1);
            thisOver.setLegalDeliveries(thisOver.getLegalDeliveries()+1);
            inningsScorecard.setTeamScore(inningsScorecard.getTeamScore()+temp);
            if(temp%2!=0)
                swap(playerDetails);


        }
        case 6 -> {
            thisOver.setRunsConceded(thisOver.getRunsConceded()+6);
            thisOver.setNoOfSixes(thisOver.getNoOfSixes()+1);
            thisOver.getBallHistory().add(6);
            bowler.setRunsConceded(bowler.getRunsConceded()+6);
            playerDetails[0].setRunsScored(playerDetails[0].getRunsScored()+6);
            playerDetails[0].setSixes(playerDetails[0].getSixes()+1);
            playerDetails[0].setBallsFaced(playerDetails[0].getBallsFaced()+1);
            inningsScorecard.setTeamScore(inningsScorecard.getTeamScore()+6);
            thisOver.setLegalDeliveries(thisOver.getLegalDeliveries()+1);

        }
        case 7 -> {
            int temp=startmatchView.getRunsConceded();
            thisOver.setRunsConceded(thisOver.getRunsConceded()+temp);
            thisOver.getBallHistory().add(temp);
            bowler.setRunsConceded(bowler.getRunsConceded()+temp);
            playerDetails[0].setRunsScored(playerDetails[0].getRunsScored()+temp);
            playerDetails[0].setBallsFaced(playerDetails[0].getBallsFaced()+1);
            System.out.println(temp);
            inningsScorecard.setTeamScore(inningsScorecard.getTeamScore()+temp);
            thisOver.setLegalDeliveries(thisOver.getLegalDeliveries()+1);
            if(temp%2!=0)
                swap(playerDetails);

        }
        case 8 -> {
            thisOver.setNoOfWickets(thisOver.getNoOfWickets()+1);
            thisOver.getBallHistory().add("W");
            bowler.setWickets(bowler.getWickets()+1);
            playerDetails[0].setBallsFaced(playerDetails[0].getBallsFaced()+1);
            playerDetails[0].setKnockedOutBy(bowler);
            playerDetails[0].setNotOut(false);
            inningsScorecard.setWicketsDown(inningsScorecard.getWicketsDown()+1);
            getBattingScorecard(battingTeam);
            thisOver.setLegalDeliveries(thisOver.getLegalDeliveries()+1);
            boolean toContinue;
            do {
                toContinue=startmatchView.getnewBatsmanDetails(playerDetails, inningsScorecard, battingTeam, bowlingTeam);
            }while (!toContinue);

        }

        default -> {
            System.out.println("Invalid choice, Re-enter");

        }
    }



}

    @Override
    public void getbatsmanDetails(String striker, int jerseyNo1, String nonStriker, int jerseyNo2, String battingTeam, String bowlingTeam, InningsScorecard inningsScorecard) {
        startmatchModel.getbatsmanDetails(striker,jerseyNo1,nonStriker,jerseyNo2,battingTeam,bowlingTeam,inningsScorecard);
    }

    @Override
    public void getbowlerDetails(String bowlerName, int jerseyNo, String battingTeam, String team, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, OverDetails thisOver) {
           startmatchModel.getbowlerDetails(bowlerName,jerseyNo,battingTeam,team,playerDetails,inningsScorecard,thisOver);
    }

    @Override
    public PlayerDetails[] swap(PlayerDetails striker, PlayerDetails nonStriker) {
        return new PlayerDetails[0];
    }


    @Override
    public boolean newBatsman(int jerseyNo, String newBatsmanName, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, String battingTeam, String bowlingTeam) {
       return startmatchModel.newBatsman(jerseyNo,newBatsmanName, playerDetails,inningsScorecard,battingTeam,bowlingTeam);
    }

    @Override
    public void getTeamDetails(String team) {
        startmatchModel.getTeamDetails(team);
    }


    @Override
    public void querySuccess(PlayerDetails playerDetails) {
        startmatchView.querySuccess(playerDetails);
    }

    @Override
    public void queryFailed() {
        startmatchView.queryFailed();
    }

    @Override
    public void openingBatsmanNameValid(PlayerDetails[] playerDetails, String battingTeam,String bowlingTeam, InningsScorecard inningsScorecard) {
        startmatchView.openingBatsmanNameValid(playerDetails,battingTeam,bowlingTeam,inningsScorecard);
    }

    @Override
    public void printTeamDetails(TeamDetails team) {
        startmatchView.printTeamDetails(team);
    }

    @Override
    public void newBatsmanDetailsValid(PlayerDetails striker, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, String battingTeam, String bowlingTeam) {
        playerDetails[0]=striker;
    }


    @Override
    public void printBattingScorecard(TeamDetails teamDetails) {
        startmatchView.printBattingScorecard(teamDetails);
    }

    @Override
    public void printBowlingScorecard(TeamDetails teamDetails) {
       startmatchView.printBowlingScorecard(teamDetails);
    }

    @Override
    public void bowlerDetailsVaild(PlayerDetails bowler, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, String battingTeam, String bowlingTeam, OverDetails thisOver) {
        startmatchView.bowlerDetailsVaild(bowler,playerDetails,inningsScorecard,battingTeam,bowlingTeam,thisOver);
    }
    public void toChase(int chase){
        InningsScorecard.toChase=chase;
    }

    @Override
    public void setRunRate(InningsScorecard inningsScorecard) {
        inningsScorecard.setRunrate(inningsScorecard.getTeamScore()/inningsScorecard.getOversUp());
    }

    @Override
    public void setOversBowled(PlayerDetails bowler) {
        bowler.setOversBowled(bowler.getOversBowled()+1);
    }

    @Override
    public void getBattingScorecard(String battingTeam) {
         startmatchModel.getBattingScorecard(battingTeam);
    }

    @Override
    public void getBowlingScorecard(String bowlingTeam) {
        startmatchModel.getBowlingScorecard(bowlingTeam);
    }

    @Override
    public void swap(PlayerDetails[]playerDetails){
        PlayerDetails temp=playerDetails[0];
        playerDetails[0]=playerDetails[1];
        playerDetails[1]=temp;
    }


}