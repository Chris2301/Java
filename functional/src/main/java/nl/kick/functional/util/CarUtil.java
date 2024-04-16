package nl.kick.functional.util;

import nl.kick.functional.model.Brand;
import nl.kick.functional.model.Car;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarUtil {
    private static final Random RANDOM = new Random();

    public static List<Car> createCarSet() {
        return List.of(
            generateRandomCar(),
            generateRandomCar(),
            generateRandomCar(),
            generateRandomCar(),
            generateRandomCar(),
            generateRandomCar(),
            generateRandomCar(),
            generateRandomCar(),
            generateRandomCar(),
            generateRandomCar(),
            generateRandomCar(),
            generateRandomCar(),
            generateRandomCar(),
            generateRandomCar(),
            generateRandomCar(),
            generateRandomCar(),
            generateRandomCar()
        );
    }

    private static Car generateRandomCar() {
        UUID id = UUID.randomUUID();
        Brand brand = Brand.values()[RANDOM.nextInt(Brand.values().length)];
        int cylinders = getRandomCylinders();
        boolean electric = RANDOM.nextBoolean();
        String licensePlate = generateLicensePlate();
        List<String> owners = generateOwnerList(RANDOM.nextInt(15 - 2 + 1) + 2);
        return new Car(id, brand, cylinders, electric, licensePlate, owners);
    }

    private static List<String> generateOwnerList(int amount) {
       return IntStream.range(0, amount)
        .mapToObj(i -> "Owner " + i)
        .collect(Collectors.toList());
    }

    private static int getRandomCylinders() {
        int[] possibleCylinders = {2, 4, 6, 8, 10};
        return possibleCylinders[RANDOM.nextInt(possibleCylinders.length)];
    }

    private static String generateLicensePlate() {
        StringBuilder licensePlate = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0)
                licensePlate.append((char) (RANDOM.nextInt(26) + 'A')); // letters
            else
                licensePlate.append(RANDOM.nextInt(10)); // digits
            if (i == 1 || i == 3)
                licensePlate.append('-');
        }
        return licensePlate.toString();
    }
}
