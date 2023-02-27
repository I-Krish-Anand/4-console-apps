package cricketscorecard.SetUpScorecard;

import java.time.LocalDateTime;
import java.util.HashMap;

public interface SetUpScorecardControllerToView {

    void initialSetup();

    void setPlayerDetails();

    void setTeamAndPlayerDetails(String teamName, String captainName, int captainJerseyNo, HashMap<Integer,String> players, char teamKey);

    void setMatchDetails(String team1Name,String team2Name,String venue, LocalDateTime date, int oversPerinnings, String tossWinner, String tossDecission);
}