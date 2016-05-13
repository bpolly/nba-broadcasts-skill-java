import java.util.ArrayList;

/**
 * Created by polly.6 on 5/12/16.
 */
public class TeamList {
    ArrayList<Team> teamList = new ArrayList<Team>();
    public TeamList(){
        // Initialization code here
    }

    // Find team with nickname {nickname}, return Team object
    public Team findTeamGivenNickname(String nickname){
        Team foundTeam = null;
        for(Team t : teamList){
            if(t.nicknames.contains(nickname)){
                foundTeam = t;
            }
        }
        return foundTeam;
    }
}
