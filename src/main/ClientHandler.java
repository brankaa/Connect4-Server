package main;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JFrame;



public class ClientHandler extends Thread {

	BufferedReader clientInput=null;
	PrintStream clientOutput=null;
	Socket communicationSocket = null;
	
//	String username;
//	String password;
	
	String igrac=null;
	// igrac2=null;     ako radim preko niza ne trebaju mi oba ovde;
	
	
	public ClientHandler(Socket s) {
	      communicationSocket = s;

	}
			

	
	public void run() {
		try {
			clientInput = new BufferedReader(new InputStreamReader(communicationSocket.getInputStream()));
			clientOutput = new PrintStream(communicationSocket.getOutputStream());
			
			//sad treba da otvaram prozor za registraciju da bi uso u gameroom
			//pa otvaram prozor za gameroom
			
			
			JFrame window = new JFrame();
			GameModel gm = new GameModel();
			GameController gc = new GameController(gm);
			GameView gv = new GameView(gc,gm);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setSize(800, 600);
			window.setVisible(true);
			window.setContentPane(gv);       
			
			clientOutput.println("Nznm da li nad ovaj deo uopste i treba.");
			clientOutput.println("< Dovidjenja >");
			Server.onlineRooms.remove(this);
			communicationSocket.close();					
				
		} catch (IOException e) {
			System.out.println("Korisnik nije povezan!");
		//	Server.onlineRooms.remove(this);			
			//kad jedan ode, drugog treba vratiti da opet bira gameroom (ili da ostane i ceka) i postaviti ga na nultu poziciju u nizu
		}


	}

}
