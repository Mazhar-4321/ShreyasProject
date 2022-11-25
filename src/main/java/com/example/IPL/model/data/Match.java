package com.example.IPL.model.data;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Match {
    @Id
    private Long id;
    private String city;
    private String  team1;
    private LocalDate date;
    private String team2;
    private String  venue;
    private String tossWinner;
    private String  tossDecision;
    private String  winningTeam;
    private String  wonBy;
    private String  margin;
    private String  method;
    private String  umpire1;
    private String  umpire2;

}
