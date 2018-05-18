package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		GameModel gm = new GameModel();
		GameView gv = new GameView(gm);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800, 600);
		window.setVisible(true);
		window.setContentPane(gv);                                                                                                                                                                                                                                                       
	}

}
