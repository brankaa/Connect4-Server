package main;


public class GameModell {
	private PlayerEnum table[][] = new PlayerEnum[Const.dimensionRows][Const.dimensionColumns];
	
	public GameModell(){
		for (int i = 0; i < Const.dimensionRows; i++) {
			for (int j = 0; j < Const.dimensionColumns; j++) {
				table[i][j] = PlayerEnum.None;
			}
		}
	}
	public void setField(int x, PlayerEnum player){
		int y = Const.dimensionRows - 1;
		while(table[x][y] != PlayerEnum.None && y >= 0){
			y--;
		}
		if(y >= 0 && table[x][y].equals(PlayerEnum.None)){
			table[x][y] = player;
		}
	}
	
	public PlayerEnum getPlayer(int x, int y){
		return table[x][y];
	}
	
	public PlayerEnum winVertically(){ 
		for (int j = 0; j < Const.dimensionColumns; j++) {  //zbog vece verovatnoce pobede
			for (int i = 0; i < 3; i++) {
				if(table[i][j].equals(table[i+1][j]) &&  table[i+2][j].equals(table[i+3][j]) && table[i][j].equals(table[i+2][j])){
					if(table[i][j].equals(PlayerEnum.Player1)){
						return PlayerEnum.Player1;
					} else if(table[i][j].equals(PlayerEnum.Player2)){
						return PlayerEnum.Player2;
					}
				}

			}
		}
		return PlayerEnum.None;
	}

	public PlayerEnum winHorizontally(){
		for (int i = 5; i >= 0; i--) {
			for (int j = 0; j < Const.dimensionColumns - 3; j++) {
				if(table[i][j].equals(table[i][j+1]) && table[i][j+2].equals(table[i][j+3]) && table[i][j].equals(table[i][j+2])){
					if(table[i][j].equals(PlayerEnum.Player1)){
						return PlayerEnum.Player1;
					} else if(table[i][j].equals(PlayerEnum.Player2)){
						return PlayerEnum.Player2;
					}
				}
			}
		}
		return PlayerEnum.None;
	}

	public PlayerEnum winDiagonal() {
		//Main diagonal
		for (int i = 0; i < Const.dimensionRows - 3; i++) {
			for (int j = 0; j < Const.dimensionColumns - 3; j++) {
				if(table[i][j].equals(table[i+1][j+1]) && table[i+2][j+2].equals(table[i+3][j+3]) && table[i][j].equals(table[i+2][j+2])){
					if(table[i][j].equals(PlayerEnum.Player1)){
						return PlayerEnum.Player1;
					} else if(table[i][j].equals(PlayerEnum.Player2)){
						return PlayerEnum.Player2;
					}
				}
			}
		}
		//Other diagonal
		for (int i = 0; i < Const.dimensionRows - 3; i++) {
			for (int j = Const.dimensionColumns - 1; j > 2; j--) {
				if(table[i][j].equals(table[i+1][j-1]) && table[i+2][j-2].equals(table[i+3][j-3]) && table[i][j].equals(table[i+2][j-2])){
					if(table[i][j].equals(PlayerEnum.Player1)){
						return PlayerEnum.Player1;
					} else if(table[i][j].equals(PlayerEnum.Player2)){
						return PlayerEnum.Player2;
					}}

			}
		}
		return PlayerEnum.None;
	}
}

