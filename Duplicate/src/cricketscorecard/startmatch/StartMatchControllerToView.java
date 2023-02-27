package cricketscorecard.startmatch;

import cricketscorecard.dto.InningsScorecard;
import cricketscorecard.dto.OverDetails;
import cricketscorecard.dto.PlayerDetails;

public interface StartMatchControllerToView {

    void tossDetails();

    void overInput(OverDetails overDetails, int choice, PlayerDetails bowler, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, String battingTeam, String bowlingTeam);

    void getbatsmanDetails(String striker, int jerseyNo1, String nonStriker, int jersyNo2, String battingTeam, String bowlingTeam, InningsScorecard inningsScorecard);

    void getbowlerDetails(String bowlerName, int jerseyNo, String battingTeam, String team, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, OverDetails thisOver);

    PlayerDetails[] swap(PlayerDetails striker, PlayerDetails nonStriker);

    boolean newBatsman(int jerseyN0, String newBatsmanName, PlayerDetails[] playerDetails, InningsScorecard inningsScorecard, String battingTeam, String bowlingTeam);

    void getTeamDetails(String team);

    void toChase(int chase);

    void setRunRate(InningsScorecard inningsScorecard);

    void setOversBowled(PlayerDetails bowler);

    void getBattingScorecard(String battingTeam);

    void getBowlingScorecard(String bowlingTeam);

    void swap(PlayerDetails[]playerDetails);




}