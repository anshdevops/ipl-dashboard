package com.example.ipapp.data.entitys;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Team {

    public Team() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String teamName;
    private  long totalMatches;
    private long totalWins;

    @Transient
    private List<Match> matches;

    public Team(String teamName, long totalMatches) {
        this.teamName=teamName;
        this.totalMatches=totalMatches;
    }
}
