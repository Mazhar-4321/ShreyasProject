package com.example.IPL.model.data;

/*ID,City,Date,Season,MatchNumber,Team1,Team2,
Venue,TossWinner,TossDecision,SuperOver,WinningTeam,
WonBy,Margin,method,Player_of_Match,Team1Players,
Team2Players,Umpire1,Umpire2
*/

import lombok.Getter;
import lombok.Setter;

/**** 1312199,Ahmedabad,2022-05-27,2022,
 * Qualifier 2,Royal Challengers Bangalore,Rajasthan Royals,
 * "Narendra Modi Stadium, Ahmedabad",Rajasthan Royals,field,N,Rajasthan Royals*****/
@Getter
@Setter
public class MatchInput {
    private String ID;
    private String City;
    private String Date;
    private String  Season;
    private String MatchNumber;
    private String  Team1;
    private String Team2;
    private String  Venue;
    private String TossWinner;
    private String  TossDecision;
    private String SuperOver;
    private String  WinningTeam;
    private String  WonBy;
    private String  Margin;
    private String  method;
    private String  Player_of_Match;
    private String  Team1Players;
    private String  Team2Players;
    private String  Umpire1;
    private String  Umpire2;
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setSeason(String season) {
        Season = season;
    }

    public void setMatchNumber(String matchNumber) {
        MatchNumber = matchNumber;
    }

    public void setTeam1(String team1) {
        Team1 = team1;
    }

    public void setTeam2(String team2) {
        Team2 = team2;
    }

    public void setVenue(String venue) {
        Venue = venue;
    }

    public void setTossWinner(String tossWinner) {
        TossWinner = tossWinner;
    }

    public void setTossDecision(String tossDecision) {
        TossDecision = tossDecision;
    }

    public void setSuperOver(String superOver) {
        SuperOver = superOver;
    }

    public void setWinningTeam(String winningTeam) {
        WinningTeam = winningTeam;
    }

    public void setWonBy(String wonBy) {
        WonBy = wonBy;
    }

    public void setMargin(String margin) {
        Margin = margin;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setPlayer_of_Match(String player_of_Match) {
        Player_of_Match = player_of_Match;
    }

    public void setTeam1Players(String team1Players) {
        Team1Players = team1Players;
    }

    public void setTeam2Players(String team2Players) {
        Team2Players = team2Players;
    }

    public void setUmpire1(String umpire1) {
        Umpire1 = umpire1;
    }

    public void setUmpire2(String umpire2) {
        Umpire2 = umpire2;
    }



    public String getID() {
        return ID;
    }

    public String getCity() {
        return City;
    }

    public String getDate() {
        return Date;
    }

    public String getSeason() {
        return Season;
    }

    public String getMatchNumber() {
        return MatchNumber;
    }

    public String getTeam1() {
        return Team1;
    }

    public String getTeam2() {
        return Team2;
    }

    public String getVenue() {
        return Venue;
    }

    public String getTossWinner() {
        return TossWinner;
    }

    public String getTossDecision() {
        return TossDecision;
    }

    public String getSuperOver() {
        return SuperOver;
    }

    public String getWinningTeam() {
        return WinningTeam;
    }

    public String getWonBy() {
        return WonBy;
    }

    public String getMargin() {
        return Margin;
    }

    public String getMethod() {
        return method;
    }

    public String getPlayer_of_Match() {
        return Player_of_Match;
    }

    public String getTeam1Players() {
        return Team1Players;
    }

    public String getTeam2Players() {
        return Team2Players;
    }

    public String getUmpire1() {
        return Umpire1;
    }

    public String getUmpire2() {
        return Umpire2;
    }
}
