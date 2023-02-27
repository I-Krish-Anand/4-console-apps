package cricketscorecard.startmatch;

import cricketscorecard.dto.InningsScorecard;
import cricketscorecard.dto.OverDetails;
import cricketscorecard.dto.PlayerDetails;
import cricketscorecard.dto.TeamDetails;

public interface StartMatchControllerToModel {

     void querySuccess(PlayerDetails playerDetails);

     void queryFailed();

     void openingBatsmanNameValid(PlayerDetails[] playerDetails,String battingTeam, String bowlingTeam, InningsScorecard inningsScorecard);

     void printTeamDetails(TeamDetails team);

     void newBatsmanDetailsValid( PlayerDetails striker, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, String battingTeam, String bowlingTeam);

     void printBattingScorecard(TeamDetails teamDetails);

     void printBowlingScorecard(TeamDetails teamDetails);

     void bowlerDetailsVaild(PlayerDetails bowler, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, String battingTeam, String bowlingTeam, OverDetails thisOver);

}