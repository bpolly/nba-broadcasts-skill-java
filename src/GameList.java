import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GameList {
	int DEFAULT_CUTOFF = 7;
	int listSize = 0;
	ArrayList<Game> games = new ArrayList<Game>();
	
	public GameList() {
		// Initialization Code here
	}
	
	// Add a game to the GameList
	public void addGame(Game game){
		if(!games.contains(game)){
			games.add(game);
			listSize++;
		}
	}
	
	// Remove a game to the GameList
	public void deleteGame(Game game){
		if(!games.contains(game)){
			games.remove(game);
			listSize--;
		}
	}
	
	// Get a list of Today's games
	public ArrayList<Game> getTodaysGames(){
		ArrayList<Game> todaysGames = new ArrayList<Game>();
		Date date = new Date();
		String todayDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
		//todayDate = time.strftime("%a, %B %-d");
		
		for(Game game : games){
			if(game.date.equals(todayDate)){
				todaysGames.add(game);
			}
		}
		
		return todaysGames;
	}
	
	// Get a list of Tomorrow's games
	public ArrayList<Game> getTomorrowsGames(){
		return null;
	}
	
	public ArrayList<Game> getGamesGivenTeam(String team){
		return null;
	}
	
	public ArrayList<Game> getGamesGivenTime(String time){
		return null;
	}
	
	public void printGames(){
		for(Game game : games){
			game.print();
		}
	}
	

}
