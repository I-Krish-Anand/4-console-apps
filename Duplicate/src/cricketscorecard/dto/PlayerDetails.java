package cricketscorecard.dto;

public class PlayerDetails extends TeamDetails {

    private int jerseyNo;

    private String playersName;

    private int runsScored;

    private boolean notOut=true;

    private PlayerDetails knockedOutBy;

    private int sixes;

    private int fours;

    private int ballsFaced;

    private int oversBowled;

    private int wickets;

    private int maiden;

    private int economy;

    private int CatchesTaken;

    private int runOuts;

    private int runsConceded;

    private PlayerDetails playerDetails;

    public int getRunsConceded() {
        return runsConceded;
    }

    public void setRunsConceded(int runsConceded) {
        this.runsConceded = runsConceded;
    }

    public  PlayerDetails(String playerName, int jerseyNo){
        this.playersName=playerName;
        this.jerseyNo=jerseyNo;
    }
    public PlayerDetails(PlayerDetails playerDetails){
        this.playerDetails=playerDetails;
    }

    public int getJerseyNo() {
        return jerseyNo;
    }

    public void setJerseyNo(int jerseyNo) {
        this.jerseyNo = jerseyNo;
    }

    public String getPlayersName() {
        return playersName;
    }

    public void setPlayersName(String playersName) {
        this.playersName = playersName;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public boolean isNotOut() {
        return notOut;
    }

    public void setNotOut(boolean notOut) {
        this.notOut = notOut;
    }

    public PlayerDetails getKnockedOutBy() {
        return knockedOutBy;
    }

    public void setKnockedOutBy(PlayerDetails knockedOutBy) {
        this.knockedOutBy = knockedOutBy;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getBallsFaced() {
        return ballsFaced;
    }

    public void setBallsFaced(int ballsFaced) {
        this.ballsFaced = ballsFaced;
    }

    public int getOversBowled() {
        return oversBowled;
    }

    public void setOversBowled(int oversBowled) {
        this.oversBowled = oversBowled;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getMaiden() {
        return maiden;
    }

    public void setMaiden(int maiden) {
        this.maiden = maiden;
    }

    public int getEconomy() {
        return economy;
    }

    public void setEconomy(int economy) {
        this.economy = economy;
    }

    public int getCatchesTaken() {
        return CatchesTaken;
    }

    public void setCatchesTaken(int catchesTaken) {
        CatchesTaken = catchesTaken;
    }

    public int getRunOuts() {
        return runOuts;
    }

    public void setRunOuts(int runOuts) {
        this.runOuts = runOuts;
    }
}
