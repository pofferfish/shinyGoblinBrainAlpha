package characters;

import combat.NORMAL;
import combat.enum;

public class Creatures {
	public enum TypeOfDamage{PHYSICALDMG, MAGICDMG, HYBRIDDMG, VOIDDMG, RANDOMDMG};
	
	private TypeOfDamage dmgType;
	
	private int HP;
	
	private int maxHP;
	private int currentMaxHP;
	
	private int minDmg;
	private int currentMinDmg;
	
	private int maxDmg;
	private int currentMaxDmg;
	
	private int initiative;
	
	
	
	void Creature(TypeOfDamage dmgType){
		this.dmgType = dmgType;
	}
}
