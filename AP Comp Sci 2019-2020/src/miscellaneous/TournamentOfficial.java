package miscellaneous;

public class TournamentOfficial {

	private int games, goals; //# of games played and goals scored all teams total
	
	public TournamentOfficial() {
	}
	
	public int getTotalGames() {
		return games;
	}
	
	public int getTotalGoals() {
		return goals;
	}
	
	public void startTournament() {
		games = 0;
		goals = 0;
	}
	
	public void addGoals(int a, int b) {
		goals += (a + b);
	}
	
	public void addGame() {
		games += 1;
	}
	
}