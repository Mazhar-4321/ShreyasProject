package com.example.IPL.model.data;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Statistics {
    Integer matchesPlayed;
    Integer matchesWon;
    Integer matchesLost;
    String   winToLossRation;

}
