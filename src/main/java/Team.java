import java.util.ArrayList;
import java.util.Collections;

public class Team {
    String name;
    ArrayList<String> nicknames = new ArrayList<>();

    // Constructor
    public Team(String team_name) {
        name = team_name;
    }

    // Overloaded constructor that allows for nicknames
    public Team(String team_name, String[] team_nicknames) {
        name = team_name;
        Collections.addAll(nicknames, team_nicknames);
    }

}
