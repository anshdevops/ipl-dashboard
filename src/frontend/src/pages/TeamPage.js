import React, {useEffect} from "react";
import {MatchDetailCard} from "../components/MatchDetailCard";
import {MatchSmallCard} from "../components/MatchSmallCard";
export const TeamPage=()=>{


        useEffect(

            ()=>{
                    const fetchMatches=async ()=>{
                            const response = fetch('localhost:8080/team/')

                    }
            }

        );
return(



    <div className="TeamPage">
        <h1>Team Name</h1>
        <MatchDetailCard/>
        <MatchSmallCard/>
        <MatchSmallCard/>
        <MatchSmallCard/>




    </div>
)
}