import java.util.ArrayList;

public class Game {
	String date, time;
	ArrayList<String> teams, networks;
	
	public Game(String in_date, String[] in_teams, String in_time, String[] in_networks) {
		date = in_date;
		time = in_time;
		teams = new ArrayList<String>();
		networks = new ArrayList<String>();
		for(String team : in_teams){
            teams.add(team);
        }
        for(String network : in_networks){
            networks.add(network);
        }
	}
	
	public String getDate(){
		return date;
	}
	
	public String getTime(){
		return time;
	}

	
	public void print(){
		System.out.println(date);
		printTeams(teams);
		System.out.println(time);
		printNetworks(networks);
	}
	
	private static void printTeams(ArrayList<String> teams){
		System.out.println(teams.get(0) + " vs " + teams.get(0));
	}
	
	private static void printNetworks(ArrayList<String> in_networks){
		String networks = "";
		for(String network : in_networks){
			networks += (network + ",");
		}
		networks.substring(0, networks.length()-1);
		System.out.println(networks);
	}


}
