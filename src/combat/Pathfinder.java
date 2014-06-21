package combat;

import java.util.List;

public class Pathfinder {
	PathfinderHexagon[][] map;
	int width;
	int height;

	Cordinate current;
	List<Cordinate> open = null;
	List<Cordinate> close = null;

	public Pathfinder(Hexagon[][] map, int width, int height, Cordinate start){
		this.width = width;
		this.height = height;

		this.map = new PathfinderHexagon[width][height];

		for(int i = 0; i <= width; i++){
			for(int j = 0; j <= height; j++){
				this.map[i][j] = new PathfinderHexagon(map[i][j].isWalkable());
			}
		}

		makepath(start);
	}

	public void makepath(Cordinate start){
		open.add(start);

		while(true){
			if(open.isEmpty()){
				break;
			}
			else{
				this.current = open.get(0);
				addSourroundingCordinates();
			}
		}

	}

	private void addSourroundingCordinates(){
		int x = current.getX();
		int y = current.getY();
		
		if(x > 0){
			add(new Cordinate(x-1, y)); //left
		}
		if(x < width -1){
			add(new Cordinate(x+1, y)); //right
		}
		
		if((y & 1) == 0){ //even (red)
			if(y < height -1){
				add(new Cordinate(x, y +1)); // topRight
				if(x > 0)
					add(new Cordinate(x-1, y+1)); //topLeft
			}
			if(y > 0){
				add(new Cordinate(x, y-1)); //bottomRight
				if(x > 0)
					add(new Cordinate(x-1, y-1)); //bottomLeft
			}
		}
		else{ //odd (blue)
			if(y < height -1){
				add(new Cordinate(x, y+1)); //topLeft
				if(x < width -1)
					add(new Cordinate(x+1, y+1)); //topRight
			}
			if(y > 0){
				add(new Cordinate(x, y-1)); //bottomLeft
				if(x < width -1)
					add(new Cordinate(x+1, y-1)); //bottomRight
			}
		}
	
	}

	private void add(Cordinate cordinate){
		PathfinderHexagon currentHex = map[cordinate.getX()][cordinate.getY()];
		PathfinderHexagon currentParent = map[current.getX()][current.getY()];
		
		if(! currentHex.isWalkable()){
			//not walkable - ignore	
		}
		else if(close.contains(cordinate)){
			//in close list - ignore
		}
		else if(open.contains(cordinate)){
			currentHex.updateDistance(currentParent.getDistance() + 1);
		}
		else
		{
			open.add(cordinate);
			currentHex.addParent(currentParent);
			currentHex.addDistance(currentParent.getDistance() + 1);

		}
	}

}
