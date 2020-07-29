package soccer;

public class SoccerTeamWithOfficial {
	
	private int wins, losses, ties;
	private TournamentOfficial tOfficial = new TournamentOfficial();
	
	public SoccerTeamWithOfficial(TournamentOfficial official) {
		tOfficial = official;
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
	
	public int getPoints() {
		int points = ((this.wins) * 3) + this.ties;
		return points;
	}
	
	public void reset() {
		wins = 0;
		losses = 0;
		ties = 0;
	}
	
	public void played(SoccerTeamWithOfficial other, int myScore, int otherScore) {
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
		tOfficial.addGoals(myScore, otherScore);
		tOfficial.addGame();
	}
}
