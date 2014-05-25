package characters;

public class Creatures extends GameEntity{
	public enum TypeOfDamage{PHYSICALDMG, MAGICDMG, HYBRIDDMG, VOIDDMG, RANDOMDMG};
	
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
	
	
	
	void Creature(){
	}
}
