package com.example.ipapp.data.batchprocessing;

import com.example.ipapp.data.entitys.Match;
import com.example.ipapp.data.entitys.MatchInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

    @Override
    public Match process(final MatchInput matchInp) throws Exception {


        final Match match = new Match();
        match.setId(Long.parseLong(matchInp.getId()));
        match.setDate(LocalDate.parse(matchInp.getDate()));
        match.setPlayerOfMatch(matchInp.getPlayer_of_match());

        match.setVenue(matchInp.getVenue());
        String firstInningsTeam,secondInningsTeam;
        if("bat".equals(matchInp.getToss_decision())){

            firstInningsTeam=matchInp.getToss_winner();
            secondInningsTeam=matchInp.getToss_winner().equals(matchInp.getTeam1()) ? matchInp.getTeam2():matchInp.getTeam1();
        }
        else {
            secondInningsTeam = matchInp.getToss_winner();
            firstInningsTeam = matchInp.getToss_winner().equals(matchInp.getTeam1()) ? matchInp.getTeam2() : matchInp.getTeam1();


        };


        match.setTeam1(firstInningsTeam);
        match.setTeam2(secondInningsTeam);
        match.setTossWinner(matchInp.getToss_winner());
        match.setCity(matchInp.getCity());
        match.setTossDecision(matchInp.getToss_decision());
        match.setMatchWinner(matchInp.getWinner());
        match.setResult(matchInp.getResult());

        match.setResultMargin(matchInp.getResult_margin());
        match.setUmpire1(matchInp.getUmpire1());
        match.setUmpire2(matchInp.getUmpire2());


        log.info("Converting (" + matchInp + ") into (" + match + ")");

        return match;
    }

}