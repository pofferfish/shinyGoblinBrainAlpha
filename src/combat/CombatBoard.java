package combat;

import characters.GameEntity;


public class CombatBoard {
	
	private Hexagon[][] map;
	
	public CombatBoard(int width, int height){
		map = new Hexagon[width][height];
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
