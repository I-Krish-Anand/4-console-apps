package cricketscorecard.SetUpScorecard;

import cricketscorecard.repository.ScoreCard;

import java.time.LocalDateTime;
import java.util.HashMap;

public class SetUpScorecardModel implements SetUpScorecardModelToController {
    SetUpScorecardControllerToModel setupscorecardController;

    SetUpScorecardModel(SetUpScorecardController setupscorecardController) {
        this.setupscorecardController = setupscorecardController;
    }

    @Override
    public void initialSetup() {
        ScoreCard.getInstance().intitialSetup();
    }


    @Override
    public void setTeamAndPlayerDetails(String teamName, String captainName, int captainJerseyNo, HashMap<Integer,String> players, char teamKey) {
        ScoreCard.getInstance().setTeamAndPlayerDetails(teamName,captainName,captainJerseyNo,players,teamKey);

    }

    @Override
    public void setMatchDetails(String team1Name,String team2Name,String venue, LocalDateTime date, int oversPerinnings, String tossWinner, String tossDecission) {
        ScoreCard.getInstance().setMatchDetails(team1Name,team2Name,venue,date,oversPerinnings,tossWinner,tossDecission);
    }
    private void updationSuccess(){
        setupscorecardController.updationSuccess();
    }
}