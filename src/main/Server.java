package main;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {

	
	public static LinkedList<Gameroom> onlineRooms = new LinkedList<>();

	public static void main(String[] args) {
		ServerSocket serverSoket =null;
		Socket communicationSoket = null;		
	
		try {		
			serverSoket = new ServerSocket(9012);
			System.out.println("SERVER JE POKERNUT");
			while(true) {
				System.out.println("cekanje na konekciju...");	
				communicationSoket= serverSoket.accept();
				System.out.println("\tkonekcija uspostavljena.");				
				ClientHandler noviKlijent = new ClientHandler(communicationSoket);					
				noviKlijent.start();
/*				if(onlineRooms.isEmpty() || onlineRooms.getLast().playersInRoom[1]!=null) {		
					onlineRooms.add(new Gameroom()); 				
					onlineRooms.getLast().playersInRoom[0]=noviKlijent;
					System.out.println("\tSoba je kreirana.\n\t\tPrvi igrac je u sobi.");}
				}else {
					onlineRooms.getLast().playersInRoom[1]=noviKlijent;
					System.out.println("\t\tDrugi igrac je u sobi.");
				}	
*/				int br=0;
				for (Gameroom el : onlineRooms) {					
					if(el.playersInRoom[1]==null) {
						onlineRooms.getLast().playersInRoom[1]=noviKlijent;
						System.out.println("\t\tDrugi igrac je u sobi.");
						br++;
						break;
					}
				}
				if(br==0 && (onlineRooms.isEmpty() || onlineRooms.getLast().playersInRoom[1]!=null)) {		//jel dovoljno da igrac 2 bude !=null???????
					onlineRooms.add(new Gameroom()); 				
					onlineRooms.getLast().playersInRoom[0]=noviKlijent;
					System.out.println("\tSoba je kreirana.\n\t\tPrvi igrac je u sobi.");
				}				
			}	
		} 
		catch (IOException e) {
			System.out.println("Greska: vec postoji pokrenut server");
		}								
	}
}

