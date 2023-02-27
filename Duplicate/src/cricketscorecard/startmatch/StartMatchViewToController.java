package cricketscorecard.startmatch;

import cricketscorecard.dto.InningsScorecard;
import cricketscorecard.dto.OverDetails;
import cricketscorecard.dto.PlayerDetails;
import cricketscorecard.dto.TeamDetails;

public interface StartMatchViewToController {

    void beginMatch(String battingTeam, String bowlingTeam);

    int getRunsConceded();

    void querySuccess(PlayerDetails playerDetails);

    void queryFailed();

    void printTeamDetails(TeamDetails team);

    void printBattingScorecard(TeamDetails teamDetails);

    void printBowlingScorecard(TeamDetails teamDetails);

    void printScore(PlayerDetails bowler, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, String battingTeam, String bowlingTeam, int ballNo, OverDetails thisOver);


    void openingBatsmanNameValid(PlayerDetails[] playerDetails, String battingTeam,String bowlingTeam, InningsScorecard inningsScorecard);

    void bowlerDetailsVaild(PlayerDetails bowler, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, String battingTeam, String bowlingTeam, OverDetails thisOver);

    boolean getnewBatsmanDetails(PlayerDetails[]playerDetails, InningsScorecard inningsScorecard, String battingTeam, String bowlingTeam);
}