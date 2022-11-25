package com.example.IPL.repository;

import com.example.IPL.model.data.Match;
import com.example.IPL.model.data.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Repository
public interface MatchRespository extends JpaRepository<Match, Long> {

    @Query("select count(m) from Match m where m.umpire1!='mazhar' ")
    Long getDetails(String umpire1);

    @Query(value = "select pp.team1,pp.male_count,pp.female_count " +
            "from((SELECT team1, count(team1) male_count  FROM Match  " +
            "where team1=?1  group by team1 )p1  join (SELECT team2, count(team2) " +
            "female_count  FROM Match  where team2=?1 group by team2  )p2 " +
            "on p1.team1=p2.team2" +
            " )pp  ", nativeQuery = true)
    List<Object[]> getGroupedData(String team1);

    @Query(value = " select count (*),pp.tm1,pp.tm2 from(select team1 tm1,team2 tm2 from Match where team1=?1 or team2=?1 )pp group by pp.tm1", nativeQuery = true)
    List<Object[]> getTotalCount(String team1);

    @Query(value = "select * from Match where team1=?1 or team2=?1 order by date desc limit 3", nativeQuery = true)
    List<Match> getLatest3Games(String name);

    @Query(value = "select * from Match where team1=?1 or team2=?1 order by date ", nativeQuery = true)
    List<Match> getLatestGames(String name);


    @Query(value = "select * from Match where team1=?1 order by date desc limit 3", nativeQuery = true)
    List<Match> getLatest3WinGames(String name);

    @Query(value = "select * from Match where team2=?1 order by date desc limit 3", nativeQuery = true)
    List<Match> getLatest3LostGames(String name);

    @Query(value = "select * from Match where method!='NA'", nativeQuery = true)
    Match getSuperOverMatch();

    @Query(value = "select * from Match where (umpire1=?1 and umpire2=?2) or (umpire1=?2 and umpire2=?1)", nativeQuery = true)
    List<Match> getUmpires(String umpire1, String umpire2);

    @Query(value = "select * from Match order by date desc limit 1", nativeQuery = true)
    Match getWinningTeam();

    @Query(value = "select team2 from Match")
    List<Object[]> getAllTeams();

    @Query(value = "select team2,count(team2) m from Match group by team2 order by m ", nativeQuery = true)
    List<Object[]> getAllLossGames();

    @Query(value = "select distinct team1 from Match", nativeQuery = true)
    List<Object> getAllTeamNames();
}
/*** select count(m.team1),count(m.team2) from Match m where m.team1 =( select count(m1.team1) from Match m1 where m1.team1=?1) and m.team2 =( select m2.team2 from Match m2 where m2.team2=?1) **********/