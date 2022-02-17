package com.example.ipapp.controller;

import com.example.ipapp.data.entitys.Team;
import com.example.ipapp.repository.MatchRepository;
import com.example.ipapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TeamController {

    private  TeamRepository teamRepository;
    private   MatchRepository matchRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository,MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository=matchRepository;
    }





    @GetMapping("/team/{teamName}")
    public Team getTeam( @PathVariable String teamName){


        Team team= teamRepository.findByTeamName(teamName);
        team.setMatches(matchRepository.findLatestMatchesByTeam(teamName,4));
        return  team;


    }
}