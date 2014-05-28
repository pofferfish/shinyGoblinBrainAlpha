package combat;
import java.util.List;
import characters.*;

public class Hexagon {
	
	private boolean walkable;
	
	private List<GameEntity> pileOfDead;
	private GameEntity entity;
	private List<TrapObject> traps;
	
	public Hexagon(Creature entity){
		setEntity(entity);
	}
	
	public Hexagon(SolidObject entity){
		setEntity(entity);
	}
	
	public Hexagon(TrapObject trap){
		traps.add(trap);
		this.walkable = true;
	}
	
	public Hexagon(){
		this.walkable = true;
	}
	
	private void setEntity(GameEntity entity){
		this.entity = entity;
		walkable = false;
	}


}
