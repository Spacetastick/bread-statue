package frogSim;

import java.util.Scanner;

public class FrogSimulation {
	
	private int goalDistance, maxHops, hopDistance;
	
	public FrogSimulation(int goalDistance, int maxHops) {
		this.goalDistance = goalDistance;
		this.maxHops = maxHops;
	}
	
	private int hopDistance(){
		// Returns an integer representing the distance, in inches, to be moved when the frog hops
		hopDistance = (int)(Math.random() * 45) -15;
		return hopDistance;
	}
	
	public boolean simulate() {
		
		/* Simulates a frog attempting to reach the goal as described in part (a).
		Returns true if the frog successfully reached or passed the goal during the simulation;
		false otherwise. */
		/* The frog hops until one of the following conditions becomes true:
		• The frog has reached or passed the goal.
		• The frog has reached a negative position.
		• The frog has taken the maximum number of hops without reaching the goal. 
		*/
		
		int hops = 0;
		int hopLength = hopDistance();
		//System.out.println("hopLength is: " + hopLength);
		for (int distance = 0; distance < goalDistance; distance += 0) {
			System.out.println("Distance is: " + distance);
			System.out.println("Hopping " + hopLength + " inches!");
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
	
	public double runSimulations(int num, FrogSimulation frog) {
		
		/* Runs num simulations and returns the proportion of simulations in which the frog
		successfully reached or passed the goal.
		Precondition: num > 0  */
		int successfulSims = 0;
		for (int sims = num; sims > 0; sims--) {
			boolean test = frog.simulate();
			//System.out.println(test);
			if (test) {
				successfulSims++;
			}
		}
		
		return successfulSims/num;
	}
	
	public static void main(String[] args) {	
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Frog Simulation!");
		System.out.println("What is the goal distance?");
		int goal = input.nextInt();
		System.out.println("What is the max hops?");
		int hops = input.nextInt();
		System.out.println("How many simulations do you want to run?");
		int sims = input.nextInt();
		input.close();
		FrogSimulation frog = new FrogSimulation(goal, hops);
		
		while (sims > 0) {
			System.out.println(frog.runSimulations(sims, frog));
			sims--;
		}

	}
	
}

//bruh wtf github