package combat;
import characters.gameObject;

public class Hexagon {
	public enum hexType {NORMAL, OBSTACLE, ENEMY, FRIEND};
	public enum walkable {WALKABLE, DESTRUCTASBLE, INDESTRUCTABLE}
	
	private hexType type;
	private boolean destructable;
	private gameObject content;
	
	public Hexagon(hexType type, boolean destructable, gameObject containedObject){
		this.type = type;
		this.destructable = destructable;
		this.setContent(containedObject);
	}
	
	public Hexagon(hexType type, boolean destructable){
		this.type = type;
		this.destructable = destructable;
		this.setContent(null);
	}
	
	public hexType getType(){
		return this.type;
	}
	public void setType(hexType type){
		this.type = type;
	}
	
	public boolean getDestructable(){
		return this.destructable;
	}
	public void setDestructable(boolean destructable){
		this.destructable = destructable;
	}

	public gameObject getContent() {
		return content;
	}

	public void setContent(gameObject content) {
		this.content = content;
	}
}
