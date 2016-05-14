import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class GameList {
	int DEFAULT_CUTOFF = 7;
	int listSize = 0;
	HashMap<String, ArrayList<Game>> dateToGameMap = new HashMap<>();


    public GameList() {
	}
	
	// Add a game to the GameList
	public void addGame(Game game){
		if(dateToGameMap.containsKey(game.date)) {
			ArrayList<Game> games = dateToGameMap.get(game.date);
            games.add(game);
            dateToGameMap.put(game.date, games);
		} else {
            ArrayList<Game> games = new ArrayList<>();
            games.add(game);
            dateToGameMap.put(game.date, games);
        }
        listSize++;
	}
	
	// Remove a game to the GameList
	public void deleteGame(Game game){
        if(dateToGameMap.containsKey(game.date)) {
            ArrayList<Game> games = dateToGameMap.get(game.date);
            if(games.contains(game)) {
                games.remove(game);
                dateToGameMap.put(game.date, games);
            }
        }
	}
	
	// Get a list of Today's games
	public ArrayList<Game> getTodaysGames(){
        LocalDateTime todaysDateLDT = LocalDateTime.now();
		return getGamesGivenDate(todaysDateLDT);
	}
	
	// Get a list of Tomorrow's games
	public ArrayList<Game> getTomorrowsGames(){
        LocalDateTime tomorrowDateLTD = LocalDateTime.now();
        tomorrowDateLTD = tomorrowDateLTD.plusDays(1);
        return getGamesGivenDate(tomorrowDateLTD);
	}

    public ArrayList<Game> getGamesGivenDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String dateToGet = date.format(formatter);
        return dateToGameMap.get(dateToGet);
    }
	
	public ArrayList<Game> getGamesGivenTeam(String team){
        Team temp = TeamList.findTeamGivenNickname(team);
        String teamName = (temp != null) ? temp.name : null;

        ArrayList<Game> teamGames = new ArrayList<>();
        for(String date : dateToGameMap.keySet()) {
            ArrayList<Game> currentDateGames = dateToGameMap.get(date);
            for(Game game : currentDateGames) {
                if(game.teams.contains(teamName)){
                    teamGames.add(game);
                }
            }
        }
		return teamGames;
	}
	
	public ArrayList<Game> getGamesGivenTime(String time){
		return null;
	}
	
	public void printGames(ArrayList<Game> gamesToPrint){
		for(Game game : gamesToPrint){
			game.print();
		}
	}

    public int size(){
        return listSize;
    }
	

}
