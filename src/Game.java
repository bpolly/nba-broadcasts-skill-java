
public class Game {
	String date, time;
	String[] teams, networks;
	
	public Game(String in_date, String[] in_teams, String in_time, String[] in_networks) {
		date = in_date;
		time = in_time;
		teams = in_teams;
		networks = in_networks;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getTime(){
		return time;
	}
	
	public String[] getTeams(){
		return teams;
	}
	
	public String[] getNetworks(){
		return networks;
	}
	
	public void print(){
		System.out.println(date);
		printTeams(teams);
		System.out.println(time);
		printNetworks(networks);
	}
	
	private static void printTeams(String[] teams){
		System.out.println(teams[0] + " vs " + teams[1]);
	}
	
	private static void printNetworks(String[] in_networks){
		String networks = "";
		for(String network : in_networks){
			networks += (network + ",");
		}
		networks.substring(0, networks.length()-1);
		System.out.println(networks);
	}


}
