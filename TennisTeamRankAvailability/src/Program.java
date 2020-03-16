import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

	String[] HeaderData;
	String[] data = new String[50];
	String row;
	int numberofplayers;
	int numberofmatches;
	int[] availability = new int[20];
	BufferedReader csvReader = null;
	
	public void Run() {
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			//C:\Users\mitch\git\TennisTeamRankAvailability\TennisTeam.csv
			//Prompt user for location of .csv file
			System.out.print("Please enter the location of the .csv file with team information: ");
			String file_name = br.readLine();
			System.out.println("Parsing file information...");
			
			//Read in information from .csv file
			csvReader = new BufferedReader(new FileReader(file_name));
			
			//16 is the max number of players on a team
			Player[] MyTeam = new Player[16];
			
			int i = 0;
			while((row = csvReader.readLine()) != null) {
				
				if(i == 0) {
					HeaderData = row.split(",");
					i++;
					continue;
				}
				else {
				data = row.split(",");
				//Player(String name, String phone, String email, int timesplayed, int singles, int ad, int duece, int[] availability)
				}				
				
				int j = 0;
				while(data[j+7] != null) {
					if(data[j+7] == "1") {
						availability[j] = 1;
					}
					else {
					availability[j] = 0;	
					}
					j++;
				}
				
				MyTeam[i] = new Player(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), availability);
				numberofplayers++;
				i++;
			}
			csvReader.close();
		}
		catch(IOException ioe){
			System.out.println("Error parsing file information.");
		}
	}
}