package simulation;

import java.util.Scanner;

public class PredatorPraySimulation {
	
	static double A, B, C, D, preyPop, predatorPop, periods;
	
	public static int predatorPop() { //add constructors for equations
		
		//predator(n+1) = predator(n) times (1 - C + D times prey(n))
		predatorPop = predatorPop * (1 - C + D * preyPop);
	}
	//fix problem for both of pop numbers being changed and accidentally affecting 
	//eachother when executed one after another
	public static int preyPop() {
		
		//prey(n+1) = prey(n) times (1 + A - B times predator(n))
		preyPop = preyPop * (1 + A - B * predatorPop);
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Predator-Prey Simulation!");
		Scanner input = new Scanner(System.in);
		System.out.println("What is the rate at prey which birth exceeds natural death?");
		A = input.nextDouble();
		System.out.println("What is the rate of predation?");
		B = input.nextDouble();
		System.out.println("What is the rate at which predator deaths exceed births without food?");
		C = input.nextDouble();
		System.out.println("What is the rate of predator increase in the presence of food?");
		D = input.nextDouble();
		System.out.println("What is the initial prey population size?");
		preyPop = input.nextInt();
		System.out.println("What is the initial predator population size?");
		predatorPop = input.nextInt();
		System.out.println("What is the number of periods?");
		periods = input.nextInt();
		input.close();
		
		
		
		
		
	}

}