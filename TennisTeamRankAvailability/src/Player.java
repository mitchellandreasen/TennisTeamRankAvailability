//Do I need to create a specific Run class like: https://stackoverflow.com/questions/2843423/in-java-why-would-one-initialize-an-int-variable-with-0-when-it-will-be-assigned
//Do I need a class for multiple Players? A team class?  That seems to only make sense if there were more than one group of players.

public class Player {
	String name;
	String phone;
	String email;
	int timesplayed;
	int singles;
	int ad;
	int duece;
	int[] availability;
	
	public Player(String name, String email, String phone, int timesplayed, int singles, int ad, int duece, int[] availability) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.timesplayed = timesplayed;
		this.singles = singles;
		this.ad = ad;
		this.duece = duece;
		this.availability = availability;
	}
	
	public String getName() {
		return name;
	}
	
	public int getTimesPlayed() {
		return timesplayed;
	}
	
	public static void main(String[] args) {
		new Program().Run();
	}
}
