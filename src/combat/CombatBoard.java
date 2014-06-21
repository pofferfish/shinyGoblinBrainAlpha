package combat;

import characters.GameEntity;


public class CombatBoard {
	
	private Hexagon[][] map;
	private int width;
	private int height;
	
	public CombatBoard(int width, int height){
		map = new Hexagon[width][height];
		
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				map[i][j] = new Hexagon();
			}
		}
		
		//set out creatures and stuff
		
		//map[0][0] = new Hexagon(dinosaur);
		
		
	}
	
	
	public void move(Cordinate currentPosition, Cordinate newPosition){
		Hexagon currentHexagon  = map[currentPosition.getX()][currentPosition.getY()];
		Hexagon newHexagon = map[newPosition.getX()][newPosition.getY()];
		
		GameEntity entity = currentHexagon.removeEntity();
		newHexagon.setEntity(entity);
	}
	
	/*
	int[] pos = {x,y}
	
	TopLeft = {x+1, y}
	TopRight = {x+1,y+1}
	Left = {x, y-1}
	Right = {x, y+1}
	BotLeft = {x-1, y}
	BotRight = {x-1, y+1}
	*/
	
	
	
	
	
	
	

}
