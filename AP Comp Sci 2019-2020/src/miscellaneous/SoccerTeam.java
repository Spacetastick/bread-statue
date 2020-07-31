package miscellaneous;

public class SoccerTeam {

	private int wins, losses, ties;
	private static int games, goals; //# of games played and goals scored all teams total
	
	public SoccerTeam() {
		//makes soccer team object
	}
	
	public int getWins() {
		return wins;
	}
	
	public int getLosses() {
		return losses;
	}
	
	public int getTies() {
		return ties;
	}
	
	public static int getTotalGames() {
		return games;
	}
	
	public static int getTotalGoals() {
		return goals;
	}
	
	public static void startTournament() {
		games = 0;
		goals = 0;
	}
	
	public int getPoints() {
		int points = ((this.wins) * 3) + this.ties;
		return points;
	}
	
	public void reset() {
		wins = 0;
		losses = 0;
		ties = 0;
	}
	
	public void played(SoccerTeam other, int myScore, int otherScore) {
		if (myScore > otherScore) {
			this.wins += 1;
			other.losses += 1;
		}
		else if (myScore < otherScore) {
			this.losses += 1;
			other.wins += 1;
		}
		else {
			this.ties += 1;
			other.ties += 1;
		}
		goals += (myScore + otherScore);
		games += 1;
	}
}
