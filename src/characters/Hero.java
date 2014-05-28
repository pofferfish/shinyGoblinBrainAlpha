package characters;

public class Hero extends GameEntity {

	private int level;
	private int experience;
	
	private Creature.race race;	
	
	private int offence;
	private int defence;
	private int spellStrength;
	private int mindPower;
	private int luck;
	
	private spell[] spells;
	private skill[] skills;
	private int movement;
	private int currentMovment;
	private Creature[] army = new Creature[5];  
}
