import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;


import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class nba_scraper {
	static GameList gameList = new GameList();

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.nba.com/schedules/national_tv_schedule/");

        // Write HTML to local file
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	    BufferedWriter writer = new BufferedWriter(new FileWriter("src/nba_broadcast_schedule.html"));
	    String line;
	    while ((line = reader.readLine()) != null) {
	    	// For whatever reason, CDATA breaks Jsoup
	    	if (line.contains("<![CDATA[")){ line = line.replace("<![CDATA[", ""); }
	    	writer.write(line);
	    	writer.newLine();
	    }
        reader.close();
	    writer.close();
		
        // parse the local HTML file
		File nba_broadcast_html = new File("src/nba_broadcast_schedule.html");
		Document doc = Jsoup.parse(nba_broadcast_html, "UTF-8");

        // div with schedule in it
		Element content = doc.getElementById("scheduleMain");

        // get years from header
        Element headerRow = content.getElementsByClass("header").first();
        String yearRange = headerRow.text(); // NATIONAL TV SCHEDULE - 2015-16
        yearRange = yearRange.substring(yearRange.lastIndexOf(' ') + 1); // 2015-16
        String year1 = yearRange.substring(0, yearRange.lastIndexOf('-')); // 2015
        String year2 = (Integer.parseInt(year1) + 1) + ""; // 2016

        // get gameRows
		Elements gameRows = content.select("tr:not(.header):not(.title)");
        String lastDate="";
		for (Element row : gameRows) {
			String date = row.getElementsByClass("dt").first().text();
            SimpleDateFormat oldSDF = new SimpleDateFormat("EEE, MMM dd");
            SimpleDateFormat newSDF = new SimpleDateFormat("MM/dd/yyyy");
            try {
                if(date.length() == 0) date = lastDate;
                date = newSDF.format(oldSDF.parse(date));
                int month = Integer.parseInt(date.substring(0,2));
                if(month <= 7) {date = date.replace("1970", year2);}
                else {date = date.replace("1970", year1);}

                lastDate = date;
            } catch(ParseException pe){
                System.err.println(pe);
            }

			Elements teams_elems = row.select(".gm a");
			String[] teams = {teams_elems.first().text(), teams_elems.last().text()};
			String time = row.getElementsByClass("tm").first().text();
			Elements networks_elems = row.getElementsByTag("img");
			String[] networks = parseNetworkNames(networks_elems);

			Game newGame = new Game(date, teams, time, networks);
			gameList.addGame(newGame);
			newGame.print();
			System.out.println();
		}
		
	}
	
	// Get list of network Elements, get SRC, pull out filename and return list
	static private String[] parseNetworkNames(Elements networkElems){
		int networkCount = networkElems.size();
		String newName;
		String[] originalNetworks = new String[networkCount];
		int elemCount = 0;
		for (Element x : networkElems){
			newName = x.attr("src");
			originalNetworks[elemCount] = newName;
			elemCount++;
		}
	
		String[] newNames = new String[networkCount];
		for(int i = 0; i < networkCount; i++){
			if(originalNetworks[i] != null){
				String baseName = FilenameUtils.getBaseName(originalNetworks[i]);
				if(baseName.contains("shrinkee_")) { 
					baseName = baseName.replace("shrinkee_", "");
				}
				newNames[i] = baseName;
			}
		}
		return newNames;
	}
	

	

}
