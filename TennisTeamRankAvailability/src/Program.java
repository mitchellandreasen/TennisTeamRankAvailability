import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

	String[] data;
	String row;
	int numberofplayers;
	int numberofmatches;
	int[] availability;
	BufferedReader csvReader = null;
	
	public void Run() {
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			//Prompt user for location of .csv file
			System.out.print("Please enter the location of the .csv file with team information: ");
			String file_name = br.readLine();
			System.out.print("Parsing file information...");
			
			//Read in information from .csv file
			csvReader = new BufferedReader(new FileReader(file_name));
				
			while((row = csvReader.readLine()) != null) {
				data = row.split(",");
				//Player(String name, String phone, String email, int timesplayed, int singles, int ad, int duece, int[] availability)
								
				numberofplayers++;
				
				int i = 0;
				while(data[i+7] != null) {
					availability[i] = Integer.parseInt(data[i + 7]);
					i++;
				}
				
				Player myPlayer = new Player(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), availability);

			}
			csvReader.close();
		}
		catch(IOException ioe){
			System.out.print("Error parsing file information.");
		}
	}
}