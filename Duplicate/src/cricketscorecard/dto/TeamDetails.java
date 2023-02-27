package cricketscorecard.dto;

import java.util.ArrayList;

public class TeamDetails extends MatchDetails {

    private String teamName;

    private char key;

    private String captainName;

    private int captainJerseyNo;

    ArrayList<PlayerDetails>players=new ArrayList<>();

    public ArrayList<PlayerDetails> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<PlayerDetails> players) {
        this.players = players;
    }

    public TeamDetails(String teamName, String captainName, int captainJerseyNo, char key)
    {
      this.teamName=teamName;
      this.captainName=captainName;
      this.captainJerseyNo=captainJerseyNo;
      this.key=key;
    }
    public TeamDetails(){}

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public int getCaptainJerseyNo() {
        return captainJerseyNo;
    }

    public void setCaptainJerseyNo(int captainJerseyNo) {
        this.captainJerseyNo = captainJerseyNo;
    }


}
