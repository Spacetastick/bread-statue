package miscellaneous;

import java.util.Scanner;

public class FrogSimulation {
	
	private int goalDistance, maxHops, hopDistance;
	
	public FrogSimulation(int goalDistance, int maxHops) {
		this.goalDistance = goalDistance;
		this.maxHops = maxHops;
	}
	
	private int hopDistance(){
		hopDistance = (int)(Math.random() * 45) -15;
		return hopDistance;
	}
	
	public boolean simulate() {
		int hops = 0;
		int hopLength = hopDistance();
		//System.out.println("hopLength is: " + hopLength);
		for (int distance = 0; distance < goalDistance; distance += 0) {
			//System.out.println("Distance is: " + distance);
			//System.out.println("Hopping " + hopLength + " inches!");
			distance += hopLength;
			hops++;
			if (distance < 0) {
				return false;
			}
			else if ((hops >= maxHops) && (distance < goalDistance)) {
				return false;
			}
			else if (distance >= goalDistance) {
				break;
			}
			hopLength = hopDistance();
		}
		if (hops <= maxHops) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public double runSimulations(int num) {
		int successfulSims = 0;
		for (int sims = num; sims > 0; sims--) {
			boolean test = this.simulate();
			//System.out.println("test is " + test);
			if (test) {
				successfulSims++;
				//System.out.println(successfulSims + " successful sims");
			}
		}
		//System.out.println("loop is over");
		//System.out.println("successful sims is: " + successfulSims + ", num is: " + num);
		double successRate = successfulSims/(double)num;
		return successRate;
	}
	
	public static void main(String[] args) {	
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Frog Simulation!");
		System.out.print("Name your frog: ");
		String name = input.nextLine();
		System.out.println("What is " + name + "'s goal distance?");
		int goal = input.nextInt();
		System.out.println("What is the max amount of hops?");
		int hops = input.nextInt();
		System.out.println("How many simulations do you want to run?");
		int sims = input.nextInt();
		input.close();
		FrogSimulation frog = new FrogSimulation(goal, hops);
		System.out.println("For " + sims + " simulations, " + name + " must hop " + goal + " inches in no more than " + hops + " hops.");
		
		double successRate = frog.runSimulations(sims);
		double successPercentage = successRate * 100;
		System.out.println(name + " the frog was successful in " + successPercentage + "% of simulations!");
	}
}