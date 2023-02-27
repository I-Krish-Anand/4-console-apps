package cricketscorecard.SetUpScorecard;

import java.time.LocalDateTime;
import java.util.HashMap;

public class SetUpScorecardController implements SetUpScorecardControllerToView, SetUpScorecardControllerToModel {
    private SetUpScorecardViewToController setupscorecardView;
    private SetUpScorecardModelToController setupscorecardModel;

    SetUpScorecardController(SetUpScorecardView setupscorecardView) {
        this.setupscorecardView = setupscorecardView;
        setupscorecardModel = new SetUpScorecardModel(this);
    }


    @Override
    public void initialSetup() {
        setupscorecardModel.initialSetup();
    }

    @Override
    public void setPlayerDetails() {
        setupscorecardModel.setPlayerDetails();
    }

    @Override
    public void setTeamAndPlayerDetails(String teamName, String captainName, int captainJerseyNo, HashMap<Integer,String> players, char teamKey) {
        setupscorecardModel.setTeamAndPlayerDetails(teamName,captainName,captainJerseyNo,players,teamKey);
    }

    @Override
    public void setMatchDetails( String team1Name,String team2Name,String venue, LocalDateTime date, int oversPerinnings, String tossWinner, String tossDecission) {
        setupscorecardModel.setMatchDetails(team1Name,team2Name,venue,date,oversPerinnings,tossWinner,tossDecission);
    }

    @Override
    public void updationSuccess() {
        setupscorecardView.updationSuccess();
    }
}