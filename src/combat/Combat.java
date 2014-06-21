package combat;

import java.util.List;

import characters.Creature;
import characters.Hero;

public class Combat {
	CombatBoard board;
	Turn turn;
	
	
	public Combat(Hero hero1, Hero hero2){
		board = new CombatBoard(9,5);
		turn = new Turn();
		
		
	}
	
	

}
