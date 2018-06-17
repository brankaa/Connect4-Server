package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.BufferUnderflowException;

public class GameController {
	GameModel gameModel;		
	public GameController(GameModel gm) {
		gameModel = gm;
	}
	
	public void startGame(){
	/*	try {
			Socket connectionSocket = new Socket("localhost", 9012);		
			BufferedReader serverInput = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			String line = serverInput.readLine();
			System.out.println(line);
			connectionSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	*/
	}
}
