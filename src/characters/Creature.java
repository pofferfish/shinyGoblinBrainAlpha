package characters;

public class Creature extends GameEntity{
	public enum TypeOfDamage{PHYSICALDMG, MAGICDMG, HYBRIDDMG, VOIDDMG, RANDOMDMG};
	public enum race{ORC, VOID, RANDOM, HUMAN, ELF, ANIMAL, DEMON, ANGLE, DRAGON, ILLUSION, UNDEAD};
	
	private TypeOfDamage dmgType;
	
	private int HP;
	
	private int maxAmount;
	private int currentAmount;
	
	private int maxHP;
	private int currentMaxHP;
	
	private int minDmg;
	private int currentMinDmg;
	
	private int maxDmg;
	private int currentMaxDmg;
	
	private int initiative;
	
	private int currentHappiness;
	private int happiness;
	
	private int movement;
	private boolean ranged;

	private race creaturType;

	
	public Creature(){
	}
}
