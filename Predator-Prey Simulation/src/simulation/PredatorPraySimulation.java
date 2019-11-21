package simulation;

import java.util.Scanner;

public class PredatorPraySimulation {
	
	static double A, B, C, D;
	static int periods, preyPop, predatorPop;
	
	public static int predatorPop() {
		double predators = predatorPop * (1 - C + D * preyPop);
		return (int)predators;
	}

	public static int preyPop() {
		double preys = preyPop * (1 + A - B * predatorPop);
		return (int)preys;
	}
	
	public static void simulate(int periods) {
		
		for (int i = 0; i <= periods; i++) {
			System.out.println("Predator population for period " + i + " is " + predatorPop);
			System.out.println("Prey population for period " + i + " is " + preyPop);
			int numPred = predatorPop();
			int numPrey = preyPop();
			predatorPop = numPred;
			preyPop = numPrey;
		}
		
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
		
		simulate(periods);
	}

}