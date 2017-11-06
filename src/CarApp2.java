/* Author: Serhiy Bardysh
 * Grand Circus dealership car data for car inventory
*/

import java.util.ArrayList;
import java.util.Scanner;

public class CarApp2 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		int carCount = 0;
		String choice = "y";
		String choice2 = "y";
		String makes = "";
		String model = "";
		int year = 0;
		double price = 0.0;
		double mileage = 0.0;
		int carChoice = 0;

		Cars carNew = new Cars();
		UsedCars carUsed = new UsedCars();

		ArrayList<Cars> carsList = new ArrayList<Cars>(carCount);
		
		System.out.println("Welcome to the Grand Circus Motors admin console! ");
		System.out.println();

		while (choice.equalsIgnoreCase("y")) {

			System.out.println("How many cars are you entering: ");

			carCount = scnr.nextInt();

			scnr.nextLine();

			for (int i = 0; i < carCount; i++) {

				makes = Validator.getString(scnr, "Enter Car Make: ");

				model = Validator.getString(scnr, "Enter Car Model: ");

				year = Validator.getInt(scnr, "Enter Car Year: ");

				price = Validator.getDouble(scnr, "Enter Car Price: ");

				if (year >= 1885 && year <= 2016) {

					mileage = Validator.getDouble(scnr, "Enter Miles: ");
					carUsed = new UsedCars(makes, model, year, price, mileage);
					carsList.add(carUsed);

				} else {

					carNew = new Cars(makes, model, year, price);
					carsList.add(carNew);
				}

			}

			System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", "Make", "Model", "Year", "   ", "Price");
			System.out.println();
			int numCounter = 1;
			for (int j = 0; j < carsList.size(); j++) {

				System.out.println(numCounter + ". " + carsList.get(j).toString());
				numCounter++;
			}
			System.out.println("Quit");
			
			carChoice = Validator.getInt(scnr, "Which car would you like: ");
			
			System.out.println(carsList.get(carChoice-1));
			choice2 = Validator.getString(scnr, "Would you like to buy this car?: ");
			

			if (choice2.equalsIgnoreCase("y")) {

				System.out.println("Excellent! Our Finance department will be in touch shortly.");

				break;
			} else {

				System.out.println("Would you like to look up more cars? y/n: ");
				choice = scnr.next();
			}
		}
		System.out.println("Have a great day!!!");
		scnr.close();
	}

}
