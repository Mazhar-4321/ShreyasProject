package com.example.IPL.model.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import com.example.IPL.model.data.Match;
import com.example.IPL.model.data.MatchInput;
import java.time.LocalDate;


@Slf4j





public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {


    @Override
    public Match process(final MatchInput matchData) throws Exception {
       Match match = new Match();
       match.setId(Long.valueOf(matchData.getID()));
       match.setCity(matchData.getCity());
       match.setDate(LocalDate.parse(matchData.getDate()));
       if(matchData.getWinningTeam().equals(matchData.getTeam2())){
           match.setTeam1(matchData.getTeam2());
           match.setTeam2(matchData.getTeam1());
       }
       else {
           match.setTeam1(matchData.getTeam1());
           match.setTeam2(matchData.getTeam2());
       }
       match.setVenue(matchData.getVenue());
       match.setTossWinner(matchData.getTossWinner());
       match.setTossDecision(matchData.getTossDecision());
       match.setWinningTeam(matchData.getWinningTeam());
       match.setWonBy(matchData.getWonBy());
       match.setMargin(matchData.getMargin());
       match.setMethod(matchData.getMethod());
       match.setUmpire1(matchData.getUmpire1());
       match.setUmpire2(matchData.getUmpire2());

       return match;
    }

}