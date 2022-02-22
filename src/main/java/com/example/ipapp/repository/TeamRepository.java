package com.example.ipapp.repository;

import com.example.ipapp.data.entitys.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team,Long> {


   Team findByTeamName(String teamName);
}
