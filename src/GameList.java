import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
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
	public GameList getTodaysGames(){
		GameList todaysGames = new GameList();
		Date date = new Date();
		//String todayDate= new SimpleDateFormat("MM/dd/yyyy").format(date);

        // Java 8 DateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime todaysDateLDT = LocalDateTime.now();
        String todayDate = todaysDateLDT.format(formatter); // "05/12/2016"


		for(Game game : games){
			if(game.date.equals(todayDate)){
				todaysGames.addGame(game);
			}
		}
		
		return todaysGames;
	}
	
	// Get a list of Tomorrow's games
	public GameList getTomorrowsGames(){
        GameList tomorrowsGames = new GameList();
        Date date = new Date();
        //String todayDate= new SimpleDateFormat("MM/dd/yyyy").format(date);

        // Java 8 DateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime tomorrowDateLTD = LocalDateTime.now();
        tomorrowDateLTD = tomorrowDateLTD.plusDays(1);
        String tomorrowDate = tomorrowDateLTD.format(formatter); // "05/12/2016"


        for(Game game : games){
            if(game.date.equals(tomorrowDate)){
                tomorrowsGames.addGame(game);
            }
        }

        return tomorrowsGames;
	}
	
	public GameList getGamesGivenTeam(String team){
		return null;
	}
	
	public GameList getGamesGivenTime(String time){
		return null;
	}
	
	public void printGames(){
		for(Game game : games){
			game.print();
		}
	}

    public int size(){
        return listSize;
    }
	

}
