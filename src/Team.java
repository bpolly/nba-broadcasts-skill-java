import java.util.ArrayList;

/**
 * Created by polly.6 on 5/12/16.
 */
public class Team {
    String name;
    ArrayList<String> nicknames = new ArrayList<String>();

    // Constructor
    public Team(String team_name) {
        name = team_name;
    }

    // Overloaded constructor that allows for nicknames
    public Team(String team_name, String[] team_nicknames) {
        name = team_name;
        for(String nickname : team_nicknames){
            nicknames.add(nickname);
        }
    }

}
