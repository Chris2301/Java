package nl.kick.designpatterns;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Command/Query responsibility segregation design pattern (CQRS)
 *
 * It is mostly used to seperate writing and reading to improve performance.
 * A second benefit is that it makes it very explicit and clear which service does what.
 */
public class CQRSpattern {

    public static void main(String[] args) {
        HotelCommandService.bookRoom(101, "John Doe");

        Optional<String> guestName = HotelQueryService.getGuestName(101);
        if (guestName.isPresent()) {
            System.out.println("Guest name for room 101: " + guestName.get());
        } else {
            System.out.println("Room 101 is vacant.");
        }
    }

    class HotelCommandService {
        public static void bookRoom(int roomNumber, String guestName) {
            RoomRegistry.rooms.put(roomNumber, guestName);
            System.out.println("Room " + roomNumber + " booked by " + guestName);
        }

    }
    class HotelQueryService {
        public static Optional<String> getGuestName(int roomNumber) {
            return Optional.ofNullable(RoomRegistry.rooms.get(roomNumber));
        }

    }

    class RoomRegistry {
        private static final Map<Integer, String> rooms = new HashMap<>();

    }
}
