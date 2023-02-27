package cricketscorecard.dto;

import java.util.ArrayList;

public class OverDetails {

    ArrayList<String> ballHistory=new ArrayList<>();

    private int noOfWides;

    private int legalDeliveries;

    private int noOfDots;

    private int noOfWickets;

    private int runsConceded;

    private int noOfSixes;

    private int noOfFours;

    private int noBalls;

    private int byes;

    public ArrayList getBallHistory() {
        return ballHistory;
    }

    public void setBallHistory(ArrayList ballHistory) {
        this.ballHistory = ballHistory;
    }

    public int getNoOfWides() {
        return noOfWides;
    }

    public void setNoOfWides(int noOfWides) {
        this.noOfWides = noOfWides;
    }

    public int getNoOfDots() {
        return noOfDots;
    }

    public void setNoOfDots(int noOfDots) {
        this.noOfDots = noOfDots;
    }

    public int getNoOfWickets() {
        return noOfWickets;
    }

    public void setNoOfWickets(int noOfWickets) {
        this.noOfWickets = noOfWickets;
    }

    public int getRunsConceded() {
        return runsConceded;
    }

    public void setRunsConceded(int runsConceded) {
        this.runsConceded = runsConceded;
    }

    public int getNoOfSixes() {
        return noOfSixes;
    }

    public void setNoOfSixes(int noOfSixes) {
        this.noOfSixes = noOfSixes;
    }

    public int getNoOfFours() {
        return noOfFours;
    }

    public void setNoOfFours(int noOfFours) {
        this.noOfFours = noOfFours;
    }

    public int getNoBalls() {
        return noBalls;
    }

    public void setNoBalls(int noBalls) {
        this.noBalls = noBalls;
    }

    public int getByes() {
        return byes;
    }

    public void setByes(int byes) {
        this.byes = byes;
    }

    public int getLegalDeliveries() {
        return legalDeliveries;
    }

    public void setLegalDeliveries(int legalDeliveries) {
        this.legalDeliveries = legalDeliveries;
    }
}
