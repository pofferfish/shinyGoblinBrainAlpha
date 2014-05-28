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

	/**
	 * Is used to remove a creature from the hexagon when it
	 * is to be moved to another hexagon.
	 * 
	 * @return The entity that was occupying the hexagon
	 */
	public GameEntity removeEntity(){
		GameEntity tempEntity = this.entity;
		setEntity(null);
		walkable = true;
		return tempEntity;
	}

	/**
	 * This moves a creature to this hexagon
	 * 
	 * @param entity the entity that will occupy the hexagon
	 */
	public void setEntity(GameEntity entity){
		if (this.entity == null){
			this.entity = entity;
			walkable = false;
		}
		else{
			//error
		}
	}

	/**
	 * Summons an entity to this hexagon
	 * 
	 * @param entity the entity to be summoned here
	 */
	public void summonEntity(GameEntity entity){
		setEntity(entity);
	}

	/**
	 * Kill the creature or destroys the object occupying
	 * this hexagon
	 * If it is a non-summoned creature it is moved to the pileOfDead
	 */
	public void destroyEntity(){
		if(! this.entity.isSummonable() && this.entity.getClass() == Creature.class){ //entity is not summoned and is creature
			this.pileOfDead.add(this.entity);
		}
		removeEntity();
	}

	/**
	 * Resurrects a creature from the pile of dead
	 * 
	 * @param creature the creature to be resurrected
	 */
	public void resurrectCreature(Creature creature){
		if(this.pileOfDead.contains(creature)){
			setEntity(creature);
			this.pileOfDead.remove(creature);
		}
		else
		{
			//error
		}

	}

	/**
	 * Summons a trap on the hexagon
	 * @param trap the trap to be summoned
	 */
	public void summonTrap(TrapObject trap){
		this.traps.add(trap);
	}

	/**
	 * removes a trap from the hexagon
	 * @param trap the trap to be removed
	 */
	public void destroyTrap(TrapObject trap){
		if(this.traps.contains(trap)){
			this.traps.remove(trap);
		}
		else
		{
			//error
		}
	}
	
	/**
	 * moves a trap to this hexagon
	 * @param trap the trap to move here
	 */
	public void moveTrapHere(TrapObject trap){
		summonTrap(trap);
	}
	
	/**
	 * moves a trap away from this hexagon
	 * @param trap the trap to be moved
	 */
	public void moveAwayTrap(TrapObject trap){
		destroyTrap(trap);
	}

}
