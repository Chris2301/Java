package nl.kick.designpatterns;

import java.util.Random;

/**
 * SAGA pattern
 *
 * When transactions are sent between microservices it makes sure everything is completed in the right order and
 * reverts processes when something fails.
 *
 * The two main things to remember in this pattern that there is a central Coordinator and services which can DO but also UNDO.
 * As shown in the example the Coordinator logically decides what happens.
 *
 */
public class SagaMicroservicePattern {


    public static void main(String[] args) {
        SagaCoordinator sagaCoordinator = new SagaCoordinator();
        sagaCoordinator.bookVacation();
    }

    static class SagaCoordinator {
        HotelMicroservice hotelMicroservice = new HotelMicroservice();
        FlightMicroservice flightMicroservice = new FlightMicroservice();

        public void bookVacation() {
            try {
                hotelMicroservice.bookRoom();
                flightMicroservice.bookFlight();
                System.out.println("Hotel room and flight booked successfully!");
            } catch (Exception e) {
                System.out.println("Booking failed. Initiating compensating transactions...");
                hotelMicroservice.cancelRoomBooking();
                flightMicroservice.cancelFlightBooking();
                System.out.println("Compensating transactions executed successfully.");
            }
        }
    }

    static class HotelMicroservice {
        public void bookRoom() {
            System.out.println("Hotel room booked.");
        }

        public void cancelRoomBooking() {
            System.out.println("Hotel room booking canceled.");
        }
    }

    static class FlightMicroservice {
        public void bookFlight() throws Exception {
            //Randomly fail
            int chance = new Random().nextInt(5);

            if (chance < 2) {
                throw new Exception("Flight booking failed.");
            } else {
                System.out.println("Flight booked.");
            }
        }

        public void cancelFlightBooking() {
            System.out.println("Flight booking canceled.");
        }
    }
}
