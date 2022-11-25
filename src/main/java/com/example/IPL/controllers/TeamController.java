package com.example.IPL.controllers;
import com.example.IPL.model.data.*;
import com.example.IPL.repository.*;
import com.example.IPL.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import sun.reflect.generics.tree.Tree;

import javax.persistence.EntityManager;
import java.util.*;

@RestController
@SessionScope
@RequestMapping("/teams")
@CrossOrigin("*")
@Slf4j
public class TeamController {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    MatchRespository matchRespository;
    @Autowired
    EntityManager entityManager;

    @GetMapping("/{teamName}")
    public Team getTeamDetails(@PathVariable String teamName) {
        Team team = new Team();
        matchRespository.getGroupedData(teamName).stream().forEach(e ->
        {
            System.out.println(e[0] + "," + e[1] + "," + e[2]);
            team.setName((String) e[0]);
            team.setMatchesWon(e[1] + "");
            team.setMatchesLost(e[2] + "");
            team.setId(1L);
            Integer won = Integer.parseInt(e[1].toString());
            Integer lost = Integer.parseInt(e[2].toString());
            //System.out.println(won+lost);
            team.setNoOfMatches(won + lost + "");
        });

        return team;

    }

    @GetMapping("/statistics/{teamName}")
    public List<Statistics> getStatistics(@PathVariable String teamName) {
        System.out.println(teamName);
        List<Statistics> list = new ArrayList<>();
        Statistics statistics = new Statistics();
       List<Object[]> list1= matchRespository.getGroupedData(teamName);
        System.out.println(list1.size());
        matchRespository.getGroupedData(teamName).stream().forEach(e ->
        {
            System.out.println("entered bhaya");
            Integer matchesWon = Integer.parseInt(e[1].toString());
            Integer matchesLost = Integer.parseInt(e[2].toString());
            Integer noOfMatches = matchesLost + matchesWon;
            statistics.setMatchesLost(matchesLost);
            statistics.setMatchesWon(matchesWon);
            statistics.setMatchesPlayed(noOfMatches);
            Long winRatio = Math.round(matchesWon * 100 / noOfMatches + 0.0);
            Long lossRatio = Math.round(matchesLost * 100 / noOfMatches + 0.0);
            if (winRatio + lossRatio > 100) {
                winRatio--;
            }
            if (winRatio + lossRatio < 100) {
                lossRatio++;
            }
            statistics.setWinToLossRation(winRatio + "--" + lossRatio);
        });
        list.add(statistics);
        //list.add(statistics);
        return list;
    }

    @GetMapping("/matches/latest/{teamName}")
    public List<Match> getLatestGames(@PathVariable String teamName) {
        return matchRespository.getLatest3Games(teamName);
    }

    @GetMapping("/matches/latest1/{teamName}")
    public List<Match> getLatestGames1(@PathVariable String teamName) {
        return matchRespository.getLatestGames(teamName);
    }

    @GetMapping("/matches/latest/win/{teamName}")

    public List<String> getLatestWin(@PathVariable String teamName) {
        List<String> teamNames = new ArrayList<>();
        matchRespository.getLatest3WinGames(teamName).stream().forEach(e ->
        {
            teamNames.add(e.getTeam2());
        });
        return teamNames;
    }

    @GetMapping("/matches/latest/loss/{teamName}")
    public List<String> getLatestLoss(@PathVariable String teamName) {
        List<String> teamNames = new ArrayList<>();
        matchRespository.getLatest3LostGames(teamName).stream().forEach(e ->
        {
            teamNames.add(e.getTeam1());
        });
        return teamNames;
    }

    @GetMapping("/matches/won/superover")
    public Match getSuperOverMatch() {
        return matchRespository.getSuperOverMatch();
        // return null;
    }

    @GetMapping("/umpires/{umpire1}/{umpire2}")
    public List<Match> getUmpires(@PathVariable String umpire1, @PathVariable String umpire2) {
        return matchRespository.getUmpires(umpire1, umpire2);
    }

    @GetMapping("/winner")
    public Match getWinnerTeam() {
        return matchRespository.getWinningTeam();
    }

    @GetMapping("/ratio")
    public List<TeamWinningInfo> getWinningRatio() {
        Map<String, Integer> map = new HashMap<>();
        List<TeamWinningInfo> list = new ArrayList<>();
        matchRespository.getAllTeams().stream().forEach(e ->
        {
            if (map.containsKey(e[0].toString())) {
                map.put(e[0].toString(), map.get(e[0].toString()) + 1);
            } else {
                map.put(e[0].toString(), 1);
            }
        });

        TreeMap<Integer, List<TeamWinningInfo>> treeMap = new TreeMap<>();
        map.entrySet().forEach(e ->
        {
            if (treeMap.containsKey(e.getValue())) {
                List<TeamWinningInfo> listTeamWinningInfo = treeMap.get(e.getValue());
                TeamWinningInfo teamWinningInfo = new TeamWinningInfo();
                teamWinningInfo.setName(e.getKey());
                teamWinningInfo.setLosses(e.getValue());
                listTeamWinningInfo.add(teamWinningInfo);
                treeMap.put(e.getValue(), listTeamWinningInfo);
            } else {
                List<TeamWinningInfo> listTeamWinningInfo = new ArrayList<>();
                TeamWinningInfo teamWinningInfo = new TeamWinningInfo();
                teamWinningInfo.setLosses(e.getValue());
                teamWinningInfo.setName(e.getKey());
                listTeamWinningInfo.add(teamWinningInfo);
                treeMap.put(e.getValue(), listTeamWinningInfo);
            }


        });
        treeMap.entrySet().forEach(e ->
        {
            System.out.println(e);
            if (e.getValue().size() == 1) {
                list.add(e.getValue().get(0));
            } else {
                for (TeamWinningInfo teamWinningInfo : e.getValue()) {
                    list.add(teamWinningInfo);
                }
            }
        });

        return list;
    }

    @GetMapping("/lossgames")
    public List<Object[]> getAllLostgames() {
        return matchRespository.getAllLossGames();
    }

    @GetMapping("/allTeams")
    public List<Object> getAllTeams() {
        return matchRespository.getAllTeamNames();
        // return null;
    }
}

