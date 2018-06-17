package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class GameView extends JComponent {
	GameController gameController;
	GameModel gameModel;
	public GameView(GameController gc, GameModel gm){
		super();
		gameController = gc;
		gameModel = gm;
		gameController.startGame();
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				boolean inTable = false;
				double widthRatio = (double)Const.width/getWidth();
				double heightRatio = (double)Const.height/getHeight();
				double xPressed = arg0.getX()*widthRatio - Const.fieldWidth;
				double yPressed = arg0.getY()*heightRatio - Const.fieldHeight - Const.gapY;
				System.out.println(xPressed + " " + yPressed);
				int counterXInPixels = (-1)*Const.gapX/2;
				int counterX = -1;
				System.out.println(Const.dimensionColumns * (Const.fieldWidth + Const.gapX ) - Const.gapX);
				if(Const.dimensionColumns * (Const.fieldWidth + Const.gapX ) - Const.gapX > xPressed && xPressed > 0){
					if(Const.dimensionRows * (Const.fieldHeight + Const.gapY) - Const.gapY > yPressed && yPressed > 0){
						System.out.println("DA");
						//inTable = true;
						while(counterXInPixels < xPressed ){
							counterXInPixels += Const.fieldWidth + Const.gapX;
							counterX++;
						}
						double xCenter = (double)counterXInPixels - (Const.fieldWidth + Const.gapX ) / 2;
						int counterYInPixels = (-1)*Const.gapY/2;
						int counterY = -1;
						while(counterYInPixels < yPressed){
							counterYInPixels += Const.fieldHeight + Const.gapY / 2;
							counterY++;
						}
						double yCenter = (double)counterYInPixels - (Const.fieldHeight + Const.gapY / 2) / 2;
						if(Math.hypot(xPressed - xCenter, yPressed - yCenter ) < 50 /*&& inTable*/){
							gm.setField(counterX, PlayerEnum.Player1);
							//System.out.println(gm.getX());
						}
						repaint();
						
					}
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		double width = getWidth();
		double height = getHeight();
		g2d.scale(width/Const.width, height/Const.height);
		g2d.setPaint(Color.BLACK);
		g2d.fillRect(0, 0, Const.width, Const.height);
		int x = 0, y = Const.fieldHeight;
		for (int j = 0; j < Const.dimensionRows; j++) {
			y+=Const.gapY;
			for (int i = 0; i < Const.dimensionColumns; i++) {
				if(gameModel.getPlayer(i,j).equals(PlayerEnum.None)){
					g2d.setPaint(Color.LIGHT_GRAY);
				} else if(gameModel.getPlayer(i,j).equals(PlayerEnum.Player1)){
					g2d.setPaint(Color.RED);
				} else {
					g2d.setPaint(Color.YELLOW);
				}
				
				x+=Const.fieldWidth;
				g2d.fillOval(x, y, Const.fieldWidth, Const.fieldHeight);
				x+=Const.gapX;
			}
			y+=Const.fieldHeight;
			x = 0;
		}
	}

}
