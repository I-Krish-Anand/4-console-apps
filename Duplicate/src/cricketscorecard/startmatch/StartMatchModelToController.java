package cricketscorecard.startmatch;

import cricketscorecard.dto.InningsScorecard;
import cricketscorecard.dto.OverDetails;
import cricketscorecard.dto.PlayerDetails;

public interface StartMatchModelToController {


    void getbowlerDetails(String bowlerName, int jerseyNo, String battingTeam, String team, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, OverDetails thisOver);

    void getbatsmanDetails(String striker, int jerseyNo1, String nonStriker, int jerseyNo2, String battingTeam, String bowlingTeam, InningsScorecard inningsScorecard);

    boolean newBatsman(int jerseyNo, String newBatsmanName, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, String battingTeam, String bowlingTeam);

    void getTeamDetails(String team);

    void getBattingScorecard(String battingTeam);

    void getBowlingScorecard(String bowlingTeam);
}