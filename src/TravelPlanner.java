import java.util.ArrayList;
import java.util.Scanner;

public class TravelPlanner {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        ArrayList<Trip> trips = new ArrayList<>(); // ArrayList of Trip objects

        while (true) {
            System.out.println("\n===== Travel Planner =====");
            System.out.println("1. Plan a Trip");
            System.out.println("2. View Trips");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = userInput.nextInt();
            userInput.nextLine(); // Consume the newline character

            switch (choice) {
                case 1: // For Plan a trip
                    planTrip(userInput, trips);
                    break;
                case 2: // For View trips
                    viewTrips(trips);
                    break;
                case 3: // For Exit
                    System.out.println("Exiting Travel Planner. Have a great day!");
                    System.exit(0);
                    break;
                default: // For invalid choice
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    // Method to plan a trip
    private static void planTrip(Scanner userInput, ArrayList<Trip> trips) {
        System.out.print("Enter destination: ");
        String destination = userInput.nextLine();

        System.out.print("Enter budget: ");
        double budget = userInput.nextDouble();
        userInput.nextLine(); // Consume the newline character

        // Create a new Trip object and add it to the ArrayList
        Trip trip = new Trip(destination, budget);

        // Itinerary planning
        while (true) {
            System.out.print("Add an activity to the itinerary (or enter 'done' to finish): ");
            String activity = userInput.nextLine();

            // If the user enters 'done', then break out of the loop
            if (activity.equalsIgnoreCase("done")) {
                break;
            } else { // Else, add the activity to the itinerary
                trip.itinerary.add(activity);
            }
        }

        trips.add(trip); // Add the trip to the ArrayList
        System.out.println("Trip to " + destination + " planned successfully!");
    }


    // Method to view trips
    private static void viewTrips(ArrayList<Trip> trips) {
        // If the ArrayList is empty, then print a message
        if (trips.isEmpty()) {
            System.out.println("No trips planned yet.");
        } else { // Else, print the trips
            System.out.println("\n===== Your Trips =====");
            for (int i = 0; i < trips.size(); i++) {
                Trip trip = trips.get(i); // Get the Trip object at index i

                System.out.println("Trip " + (i + 1) + ":");
                System.out.println("Destination: " + trip.destination);
                System.out.println("Budget: $" + trip.budget);
                System.out.println("Itinerary: " + trip.itinerary);
                System.out.println();
            }
        }
    }
}
