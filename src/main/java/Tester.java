/**
 * Created by bpolly on 5/28/16.
 */
public class Tester {
    public static void main(String[] args){
        NbaScraper nbaScraper = new NbaScraper();
        GameList nbaGames = nbaScraper.gameList;
        nbaGames.printGames();
        //System.out.println(nbaGames.getTodaysGames());
        //System.out.println(nbaGames);
    }

}
