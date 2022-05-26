package com.example.ipapp.controller;

import com.example.ipapp.data.entitys.Match;
import com.example.ipapp.data.entitys.Team;
import com.example.ipapp.repository.MatchRepository;
import com.example.ipapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@CrossOrigin

public class TeamController {

    private  TeamRepository teamRepository;
    private   MatchRepository matchRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository,MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository=matchRepository;
    }


    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {


        Team team = teamRepository.findByTeamName(teamName);
        team.setMatches(matchRepository.findLatestMatchesByTeam(teamName, 4));
        return team;


    }

    @GetMapping("/team/{teamName}/matches")
    public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year) {

        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year + 1, 1, 1);

        return matchRepository.getMatchesByTeamBetweenDates(teamName, startDate, endDate);


    }
}
