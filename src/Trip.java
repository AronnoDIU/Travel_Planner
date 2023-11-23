import java.util.ArrayList;

class Trip {
    String destination; // Destination of the trip
    double budget; // Budget of the trip
    ArrayList<String> itinerary; // Itinerary of the trip

    Trip(String destination, double budget) {
        this.destination = destination;
        this.budget = budget;
        this.itinerary = new ArrayList<>();
    }
}