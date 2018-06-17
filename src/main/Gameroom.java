package main;


public class Gameroom {

	String imeSobe;
	int bodovi1,bodovi2;
	public static ClientHandler[] playersInRoom; //=new GameClientHandler[2];
	private ClientHandler table[][] = new ClientHandler[Const.dimensionColumns][Const.dimensionRows];
	
	public Gameroom() {
		imeSobe="";
		bodovi1=0;
		bodovi2=0;
		playersInRoom=new ClientHandler[2];
	}
		
	
	
	
}
