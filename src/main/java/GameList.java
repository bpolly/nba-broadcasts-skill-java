import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

class GameList {
	int DEFAULT_CUTOFF = 7;
	private int listSize = 0;
	private HashMap<String, ArrayList<Game>> dateToGameMap = new HashMap<>();


    GameList() {
	}
	
	// Add a game to the GameList
    void addGame(Game game){
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
    ArrayList<Game> getTodaysGames(){
        LocalDateTime todaysDateLDT = LocalDateTime.now();
		return getGamesGivenDate(todaysDateLDT);
	}
	
	// Get a list of Tomorrow's games
	ArrayList<Game> getTomorrowsGames(){
        LocalDateTime tomorrowDateLTD = LocalDateTime.now();
        tomorrowDateLTD = tomorrowDateLTD.plusDays(1);
        return getGamesGivenDate(tomorrowDateLTD);
	}

    ArrayList<Game> getGamesGivenDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String dateToGet = date.format(formatter);
        return dateToGameMap.get(dateToGet);
    }
	
    ArrayList<Game> getGamesGivenTeam(String team){
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
	
    void printGames(){

		for(Map.Entry<String, ArrayList<Game>> pair : dateToGameMap.entrySet()){
            for(Game game : pair.getValue()) {
                game.print();
            }
		}
	}

    public int size(){
        return listSize;
    }
	

}
