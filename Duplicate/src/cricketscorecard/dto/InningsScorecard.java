package cricketscorecard.dto;

public class InningsScorecard {

    private int teamScore;

    private PlayerDetails striker;

    private PlayerDetails nonStriker;

    private PlayerDetails bowler;

    private int oversUp;

    public static int toChase=Integer.MAX_VALUE;

    private int wicketsDown;

    private double runrate;

    private double requiredRunRate;

    public int getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(int teamScore) {
        this.teamScore = teamScore;
    }

    public PlayerDetails getStriker() {
        return striker;
    }

    public void setStriker(PlayerDetails striker) {
        this.striker = striker;
    }

    public PlayerDetails getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(PlayerDetails nonStriker) {
        this.nonStriker = nonStriker;
    }

    public PlayerDetails getBowler() {
        return bowler;
    }

    public void setBowler(PlayerDetails bowler) {
        this.bowler = bowler;
    }

    public int getOversUp() {
        return oversUp;
    }

    public void setOversUp(int oversUp) {
        this.oversUp = oversUp;
    }

    public int getWicketsDown() {
        return wicketsDown;
    }

    public void setWicketsDown(int wicketsDown) {
        this.wicketsDown = wicketsDown;
    }

    public double getRunrate() {
        return runrate;
    }

    public void setRunrate(double runrate) {
        this.runrate = runrate;
    }

    public double getRequiredRunRate() {
        return requiredRunRate;
    }

    public void setRequiredRunRate(double requiredRunRate) {
        this.requiredRunRate = requiredRunRate;
    }
}
