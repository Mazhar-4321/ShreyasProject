package com.example.IPL.model.data;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class
Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String noOfMatches;
    private String matchesWon;
    private String matchesLost;
    Team(String name , String noOfMatches)
    {
        this.name=name;
        this.matchesWon=noOfMatches;
    }
}
