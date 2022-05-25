import {React} from "react";
import {Link} from "react-router-dom";

export const MatchSmallCard = ({teamName, match}) => {

    if (!match) return null;


    const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
    const otherTeamsRoute = `/teams/${otherTeam}`

    return (
        <div className="MatchSmallCard">
            <h3><Link to={otherTeamsRoute}> vs {otherTeam}</Link></h3>
            <p> {match.matchWinner} won by {match.resultMargin} {match.result}</p>
        </div>
    );
}