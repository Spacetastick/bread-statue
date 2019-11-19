package simulation;

import java.util.Scanner;

public class PredatorPraySimulation {
	
	static double A, B, C, D;
	static int preyPop, predatorPop, periods;
	
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


/*
In a predator-prey simulation, you compute the populations of predators and prey, using the following equations:


Here, A is the rate at which prey birth exceeds natural death, B is the rate of predation, C is the rate at which predator deaths exceed births without food, and D represents predator 
increase in the presence of food.

Write a program that prompts users for these rates, the initial population sizes, and the number of periods. Then print the populations for the given number of periods. As inputs, 
try A = 0.1,  B = C = 0.01,  and D = 0.00002 with initial prey and predator populations of 1,000 and 20.
*/