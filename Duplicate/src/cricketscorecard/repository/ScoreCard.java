package cricketscorecard.repository;

import cricketscorecard.dto.MatchDetails;
import cricketscorecard.dto.OverDetails;
import cricketscorecard.dto.PlayerDetails;
import cricketscorecard.dto.TeamDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScoreCard {

    private  static ScoreCard scoreCard;

    private MatchDetails matchDetails;
    private static int chase;
    private LinkedHashMap<Integer, OverDetails> overDetailsLinkedHashMap=new LinkedHashMap<>();

    private ArrayList<PlayerDetails>teamAPlayers=new ArrayList<>();

    private ArrayList<PlayerDetails>teamBPlayers=new ArrayList<>();


    private TeamDetails teamA;

    private TeamDetails teamB;
    private ScoreCard(){ }

    public static ScoreCard getInstance() {
        if(scoreCard==null) {
            scoreCard = new ScoreCard();
        }
        return scoreCard;
    }
    public void setTeamAndPlayerDetails(String teamName,String captainName, int captainJerseyNo, HashMap<Integer,String> players, char teamKey) {

        if (teamKey == 'A') {
            teamA = new TeamDetails(teamName, captainName, captainJerseyNo, teamKey);
            for (Map.Entry<Integer, String> entry : players.entrySet()) {
                PlayerDetails playerDetails = new PlayerDetails(entry.getValue(), entry.getKey());
                teamAPlayers.add(playerDetails);
            }
            teamA.setPlayers(teamAPlayers);
        }
        else{
            teamB = new TeamDetails(teamName, captainName, captainJerseyNo, teamKey);
            for (Map.Entry<Integer, String> entry : players.entrySet()) {
              PlayerDetails playerDetails = new PlayerDetails(entry.getValue(), entry.getKey());
              teamBPlayers.add(playerDetails);
            }
            teamB.setPlayers(teamBPlayers);
        }

    }

    /**
     *     To set team and players values initially, for easier validation.
     */

    public void intitialSetup(){
        MatchDetails.teamA="RCB";
        MatchDetails.teamB="CSK";
        MatchDetails.venue="Chennai";
        MatchDetails.date= LocalDateTime.now();
        MatchDetails.oversPerInnings=2;
        MatchDetails.oversLimitPerBowler=1;
        MatchDetails.toss="RCB";
        MatchDetails.tossDecision="Batting";
        if(MatchDetails.teamA.equals("RCB"))
            MatchDetails.tossLostBy="CSK";
        else
            MatchDetails.tossLostBy="RCB";
        teamA = new TeamDetails("RCB", "Kohli", 18, 'A');
        HashMap<Integer,String>map=new HashMap<>();
        map.put(18,"Kohli");
        map.put(1,"Faf");
        map.put(2,"Rajat");
        map.put(3,"Maxwell");
        map.put(4,"Lormor");
        map.put(5,"karthick");
        map.put(6,"Shabaz");
        map.put(7,"Hasaranga");
        map.put(8,"H.Patel");
        map.put(9,"Siraj");
        map.put(10,"Josh");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            PlayerDetails playerDetails = new PlayerDetails(entry.getValue(), entry.getKey());
            teamAPlayers.add(playerDetails);
        }
        teamA.setPlayers(teamAPlayers);
        map=new HashMap<>();
        teamB=new TeamDetails("CSK","Dhoni",7,'B');
        map.put(7,"Dhoni");
        map.put(1,"Gaikwad");
        map.put(2,"Raydu");
        map.put(3,"MoenALi");
        map.put(4,"Stokes");
        map.put(5,"Jadeja");
        map.put(6,"Bravo");
        map.put(15,"Ashwin");
        map.put(8,"D.Chahar");
        map.put(9,"Mukesh");
        map.put(10,"Kedhar");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            PlayerDetails playerDetails = new PlayerDetails(entry.getValue(), entry.getKey());
            teamBPlayers.add(playerDetails);
        }
        teamB.setPlayers(teamBPlayers);

    }

    public void setMatchDetails(String team1Name,String team2Name,String venue, LocalDateTime date, int oversPerinnings, String tossWinner, String tossDecission) {
        MatchDetails.teamA=team1Name;
        MatchDetails.teamB=team2Name;
        MatchDetails.venue=venue;
        MatchDetails.date=date;
        MatchDetails.oversPerInnings=oversPerinnings;
        MatchDetails.oversLimitPerBowler=oversPerinnings/5;
        MatchDetails.toss=tossWinner;
        MatchDetails.tossDecision=tossDecission;
        if(MatchDetails.teamA.equals(tossWinner))
            MatchDetails.tossLostBy=team2Name;
        else
            MatchDetails.tossLostBy=team1Name;
    }
    public MatchDetails tossDetails() {
        return matchDetails ;
    }
    public PlayerDetails getbowlerDetails(String bowler, int jerseyNo, String team) {

        PlayerDetails playerDetails=null;
        if(teamA.getTeamName()==team) {
            for (PlayerDetails temp : teamAPlayers) {
                if(temp.getPlayersName().equals(bowler) && temp.getJerseyNo()==jerseyNo)
                playerDetails = temp;
            }
        }
        else if(teamB.getTeamName()==team) {
            for (PlayerDetails temp : teamBPlayers) {
                if(temp.getPlayersName().equals(bowler) && temp.getJerseyNo()==jerseyNo)
                playerDetails = temp;
            }
        }
        return playerDetails;
    }
    public PlayerDetails[] getbatsmanDetails(String striker, int jerseyNo1, String nonStriker, int jerseyNo2, String battingTeam) {

        PlayerDetails[] playerDetails=new PlayerDetails[2];
        if(teamA.getTeamName()==battingTeam) {
            for (PlayerDetails temp : teamAPlayers) {
                if(temp.getPlayersName().equals(striker) && temp.getJerseyNo()==jerseyNo1)
                    playerDetails[0] = temp;
                else if(temp.getPlayersName().equals(nonStriker) && temp.getJerseyNo()==jerseyNo2)
                 playerDetails[1] = temp;
            }
        }
        else if(teamB.getTeamName()==battingTeam) {
            for (PlayerDetails temp : teamBPlayers) {
                if(temp.getPlayersName().equals(striker) && temp.getJerseyNo()==jerseyNo1)
                    playerDetails[0] = temp;
                else if(temp.getPlayersName().equals(nonStriker) && temp.getJerseyNo()==jerseyNo2)
                    playerDetails[1] = temp;
            }
        }

        return playerDetails;

    }
    public PlayerDetails newBatsman(String newBatsmanName,int jerseyNo,String battingTeam) {

        PlayerDetails playerDetails=null;
        if(teamA.getTeamName()==battingTeam) {
            for (PlayerDetails temp : teamAPlayers) {
                if(temp.getPlayersName().equals(newBatsmanName) && temp.getJerseyNo()==jerseyNo)
                    playerDetails = temp;
            }
        }
        else if(teamB.getTeamName()==battingTeam) {
            for (PlayerDetails temp : teamBPlayers) {
                if(temp.getPlayersName().equals(newBatsmanName) && temp.getJerseyNo()==jerseyNo)
                    playerDetails = temp;
            }
        }

        return playerDetails;

    }
    public TeamDetails getTeamDetails(String team) {
          if(teamA.getTeamName().equals(team)){
              return teamA;
          }
          else
              return teamB;
    }

}
