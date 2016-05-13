import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by polly.6 on 5/12/16.
 */
public class TeamList {
    static ArrayList<Team> teamList = new ArrayList<>(Arrays.asList(
        new Team("atlanta hawks", new String[]{"atlanta hawks", "atlanta", "hawks"}),
        new Team("boston celtics", new String[]{"boston celtics", "boston", "celtics"}),
        new Team("brooklyn nets", new String[]{"brooklyn nets", "brooklyn", "nets", "new jersey"}),
        new Team("charlotte bobcats", new String[]{"charlotte bobcats", "charlotte", "bobcats"}),
        new Team("chicago bulls", new String[]{"chicago bulls", "chicago", "bulls"}),
        new Team("cleveland cavaliers", new String[]{"cleveland cavaliers", "cleveland", "cavaliers", "cavs"}),
        new Team("dallas mavericks", new String[]{"dallas mavericks", "dallas", "mavericks", "mavs"}),
        new Team("denver nuggets", new String[]{"denver nuggets", "denver", "nuggets", "nugs"}),
        new Team("detroit pistons", new String[]{"detroit pistons", "detroit", "pistons"}),
        new Team("golden state warriors", new String[]{"golden state warriors", "golden state", "warriors", "dubs"}),
        new Team("houston rockets", new String[]{"houston rockets", "houston", "rockets"}),
        new Team("indiana pacers", new String[]{"indiana pacers", "indiana", "pacers"}),
        new Team("la clippers", new String[]{"la clippers","los angeles clippers", "clippers", "clips"}),
        new Team("la lakers", new String[]{"la lakers", "lakers", "los angeles lakers"}),
        new Team("memphis grizzlies", new String[]{"memphis grizzlies", "memphis", "grizzlies", "grizz"}),
        new Team("miami heat", new String[]{"miami heat", "miami", "heat"}),
        new Team("milwaukee bucks", new String[]{"milwaukee bucks", "milwaukee", "bucks"}),
        new Team("minnesota timberwolves", new String[]{"minnesota timberwolves", "minnesota", "wolves", "timberwolves"}),
        new Team("new orleans hornets", new String[]{"new orleans hornets", "orleans", "hornets"}),
        new Team("new york knicks", new String[]{"new york knicks", "knicks", "new york", "knickerbockers"}),
        new Team("oklahoma city thunder", new String[]{"oklahoma city thunder", "oklahoma", "okc", "thunder", "sonics", "oklahoma city"}),
        new Team("orlando magic", new String[]{"orlando magic", "orlando", "magic"}),
        new Team("philadelphia sixers", new String[]{"philadelphia sixers","philadelphia", "seventy sixers", "sixers"}),
        new Team("phoenix suns", new String[]{"phoenix suns", "phoenix", "suns"}),
        new Team("portland trail blazers", new String[]{"portland trail blazers", "portland", "trail", "blazers", "fourth seed"}),
        new Team("sacramento kings", new String[]{"sacramento kings", "sacramento", "kings"}),
        new Team("san antonio spurs", new String[]{"san antonio spurs", "san antonio", "spurs"}),
        new Team("toronto raptors", new String[]{"toronto raptors", "toronto", "raptors", "raps"}),
        new Team("utah jazz", new String[]{"utah jazz", "utah", "jazz"}),
        new Team("washington wizards", new String[]{"washington wizards", "washington", "wizards"}))
    );

    // Find team with nickname {nickname}, return Team object
    public static Team findTeamGivenNickname(String nickname){
        Team foundTeam = null;
        for(Team t : teamList){
            if(t.nicknames.contains(nickname.toLowerCase())){
                foundTeam = t;
                break;
            }
        }
        return foundTeam;
    }

}
