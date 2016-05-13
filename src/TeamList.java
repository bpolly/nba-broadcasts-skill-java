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
                break;
            }
        }
        return foundTeam;
    }

    public void addTeam(Team team){
        teamList.add(team);
    }

    public void initialize(){
        teamList.add(new Team("atlanta hawks", new String[]{"atlanta hawks", "atlanta", "hawks"}));
        teamList.add(new Team("boston celtics", new String[]{"boston celtics", "boston", "celtics"}));
        teamList.add(new Team("brooklyn nets", new String[]{"brooklyn nets", "brooklyn", "nets", "new jersey"}));
        teamList.add(new Team("charlotte bobcats", new String[]{"charlotte bobcats", "charlotte", "bobcats"}));
        teamList.add(new Team("chicago bulls", new String[]{"chicago bulls", "chicago", "bulls"}));
        teamList.add(new Team("cleveland cavaliers", new String[]{"cleveland cavaliers", "cleveland", "cavaliers", "cavs"}));
        teamList.add(new Team("dallas mavericks", new String[]{"dallas mavericks", "dallas", "mavericks", "mavs"}));
        teamList.add(new Team("denver nuggets", new String[]{"denver nuggets", "denver", "nuggets", "nugs"}));
        teamList.add(new Team("detroit pistons", new String[]{"detroit pistons", "detroit", "pistons"}));
        teamList.add(new Team("golden state warriors", new String[]{"golden state warriors", "golden state", "warriors", "dubs"}));
        teamList.add(new Team("houston rockets", new String[]{"houston rockets", "houston", "rockets"}));
        teamList.add(new Team("indiana pacers", new String[]{"indiana pacers", "indiana", "pacers"}));
        teamList.add(new Team("la clippers", new String[]{"la clippers","los angeles clippers", "clippers", "clips"}));
        teamList.add(new Team("la lakers", new String[]{"la lakers", "lakers", "los angeles lakers"}));
        teamList.add(new Team("memphis grizzlies", new String[]{"memphis grizzlies", "memphis", "grizzlies", "grizz"}));
        teamList.add(new Team("miami heat", new String[]{"miami heat", "miami", "heat"}));
        teamList.add(new Team("milwaukee bucks", new String[]{"milwaukee bucks", "milwaukee", "bucks"}));
        teamList.add(new Team("minnesota timberwolves", new String[]{"minnesota timberwolves", "minnesota", "wolves", "timberwolves"}));
        teamList.add(new Team("new orleans hornets", new String[]{"new orleans hornets", "orleans", "hornets"}));
        teamList.add(new Team("new york knicks", new String[]{"new york knicks", "knicks", "new york", "knickerbockers"}));
        teamList.add(new Team("oklahoma city thunder", new String[]{"oklahoma city thunder", "oklahoma", "okc", "thunder", "sonics"}));
        teamList.add(new Team("orlando magic", new String[]{"orlando magic", "orlando", "magic"}));
        teamList.add(new Team("philadelphia sixers", new String[]{"philadelphia sixers","philadelphia", "seventy sixers", "sixers"}));
        teamList.add(new Team("phoenix suns", new String[]{"phoenix suns", "phoenix", "suns"}));
        teamList.add(new Team("portland trail blazers", new String[]{"portland trail blazers", "portland", "trail", "blazers", "fourth seed"}));
        teamList.add(new Team("sacramento kings", new String[]{"sacramento kings", "sacramento", "kings"}));
        teamList.add(new Team("san antonio spurs", new String[]{"san antonio spurs", "san antonio", "spurs"}));
        teamList.add(new Team("toronto raptors", new String[]{"toronto raptors", "toronto", "raptors", "raps"}));
        teamList.add(new Team("utah jazz", new String[]{"utah jazz", "utah", "jazz"}));
        teamList.add(new Team("washington wizards", new String[]{"washington wizards", "washington", "wizards"}));



    }
}
