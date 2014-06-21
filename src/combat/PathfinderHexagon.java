package combat;

public class PathfinderHexagon {
	private boolean walkable;
	private int distance;
	private PathfinderHexagon parent;
	
	public PathfinderHexagon(boolean walkable){
		this.walkable = walkable;
	}
	
	public boolean isWalkable(){
		return walkable;
	}
	
	
	public void addParent(PathfinderHexagon parent){
		this.parent = parent;
	}
	
	public void addDistance(int distance){
		this.distance = distance;
	}
	
	public int getDistance(){
		return this.distance;
	}
	
	public void updateDistance(int distance){
		if(distance < this.distance){
			this.distance = distance;
		}
	}
}
