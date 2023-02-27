package cricketscorecard.startmatch;

import cricketscorecard.dto.InningsScorecard;
import cricketscorecard.dto.OverDetails;
import cricketscorecard.dto.PlayerDetails;
import cricketscorecard.dto.TeamDetails;
import cricketscorecard.repository.ScoreCard;

public class StartMatchModel implements StartMatchModelToController {
    StartMatchControllerToModel startmatchController;

    StartMatchModel(StartMatchController startmatchController) {
        this.startmatchController = startmatchController;
    }
    @Override
    public void getbowlerDetails(String player, int jerseyNo, String battingTeam, String team, PlayerDetails[]playerDetails, InningsScorecard inningsScorecard, OverDetails thisOver) {
        PlayerDetails bowler=ScoreCard.getInstance().getbowlerDetails(player,jerseyNo,team);

        if(playerDetails!=null)
            bowlerDetailsVaild(bowler,playerDetails,inningsScorecard,battingTeam,team,thisOver);

    }

    @Override
    public void getbatsmanDetails(String striker, int jerseyNo1, String nonStriker, int jerseyNo2, String battingTeam, String bowlingTeam, InningsScorecard inningsScorecard) {
       PlayerDetails[] playerDetails=ScoreCard.getInstance().getbatsmanDetails(striker,jerseyNo1,nonStriker,jerseyNo2,battingTeam);
       if(playerDetails[0]!=null && playerDetails[1]!=null)
           openingBatsmanNameValid(playerDetails,battingTeam,bowlingTeam,inningsScorecard);
       else
           queryFailed();
    }

    @Override
    public boolean newBatsman(int jersyNo, String newBatsmanName, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, String battingTeam, String bowlingTeam) {
       PlayerDetails newBatsman=ScoreCard.getInstance().newBatsman(newBatsmanName,jersyNo,battingTeam);
       if(newBatsman!=null) {
           startmatchController.newBatsmanDetailsValid(newBatsman, playerDetails, inningsScorecard, battingTeam, bowlingTeam);
           return true;
       }
       return false;
    }

    @Override
    public void getTeamDetails(String team) {
        TeamDetails teamDetails=ScoreCard.getInstance().getTeamDetails(team);
        printTeamDetails(teamDetails);

    }

    @Override
    public void getBattingScorecard(String battingTeam) {
        TeamDetails teamDetails=ScoreCard.getInstance().getTeamDetails(battingTeam);
        printBattingScorecard(teamDetails);

    }

    @Override
    public void getBowlingScorecard(String bowlingTeam) {
        TeamDetails teamDetails=ScoreCard.getInstance().getTeamDetails(bowlingTeam);
        printBowlingScorecard(teamDetails);

    }
    private void printBattingScorecard(TeamDetails teamDetails){
        startmatchController.printBattingScorecard(teamDetails);
    }
    private void printBowlingScorecard(TeamDetails teamDetails){
        startmatchController.printBowlingScorecard(teamDetails);
    }

    private void printTeamDetails(TeamDetails team){
        startmatchController.printTeamDetails(team);
    }


    private void openingBatsmanNameValid(PlayerDetails[] playerDetails,String battingTeam, String bowlingTeam, InningsScorecard inningsScorecard){
        startmatchController.openingBatsmanNameValid(playerDetails,battingTeam,bowlingTeam,inningsScorecard);
    }

    private void querySuccess(PlayerDetails playerDetails){
        startmatchController.querySuccess(playerDetails);
    }
    private void queryFailed(){
        startmatchController.queryFailed();
    }
    private void bowlerDetailsVaild(PlayerDetails bowler, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, String battingTeam, String bowlingTeam, OverDetails thisOver){
        startmatchController.bowlerDetailsVaild(bowler,playerDetails,inningsScorecard,battingTeam,bowlingTeam,thisOver);
    }
}