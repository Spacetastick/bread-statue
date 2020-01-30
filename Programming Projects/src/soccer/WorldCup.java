package soccer;

public class WorldCup
{
  public static void main(String[] args)
  {
    SoccerTeamWithOfficial Rockville = new SoccerTeamWithOfficial();
    SoccerTeamWithOfficial Gaithersburg = new SoccerTeamWithOfficial();
    SoccerTeamWithOfficial Poolesville = new SoccerTeamWithOfficial();
    SoccerTeamWithOfficial Germantown = new SoccerTeamWithOfficial();

    Rockville.played(Gaithersburg, 1, 2);
    Gaithersburg.played(Poolesville, 2, 2);
    Poolesville.played(Rockville, 3, 2);
    Rockville.played(Germantown, 1, 1);
    System.out.println("Rockville: " + Rockville.getPoints() + " points");
    System.out.println("Gaithersburg: " + Gaithersburg.getPoints() + " points");
    System.out.println("Poolesville: " + Poolesville.getPoints() + " points");
    System.out.println("Germantown: " + Germantown.getPoints() + " points");
    System.out.println("Total games: " + SoccerTeamWithOfficial.getTotalGames());
    System.out.println("Total goals: " + SoccerTeamWithOfficial.getTotalGoals());
    System.out.println();

    SoccerTeamWith.startTournament();
    Rockville.reset();
    Gaithersburg.reset();
    Poolesville.reset();
    Germantown.reset();

    Rockville.played(Gaithersburg, 3, 1);
    Gaithersburg.played(Poolesville, 3, 3);
    Poolesville.played(Germantown, 1, 4);
    System.out.println("Rockville: " + Rockville.getPoints() + " points");
    System.out.println("Gaithersburg: " + Gaithersburg.getPoints() + " points");
    System.out.println("Poolesville: " + Poolesville.getPoints() + " points");
    System.out.println("Germantown: " + Germantown.getPoints() + " points");
    System.out.println("Total games: " + SoccerTeam.getTotalGames());
    System.out.println("Total goals: " + SoccerTeam.getTotalGoals());
    System.out.println();
  }
}

