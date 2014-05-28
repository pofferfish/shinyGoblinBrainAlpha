package characters;

public class GameEntity {
	public enum alliance {NEUTRAL, PLAYER1, PLAYER2, PLAYER3, PLAYER4}
	private boolean summonable;
//this can be obstacle/enemy/friend
	
	
	public boolean isSummonable(){
		return this.summonable;
	}
}
