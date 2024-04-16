package nl.kick.functional;

import nl.kick.functional.model.Car;
import nl.kick.functional.util.CarUtil;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Room for cool functional 'Madness' I come across.
 */
public class FunctionalApplication {

    public static void main(String[] args) {

        List<Car> cars = CarUtil.createCarSet();

        System.out.println("===========================");
        System.out.println("=========================== Multithreaded stream with index ===========================");
        System.out.println("===========================");
        AtomicInteger indexParallelStream = new AtomicInteger(0);
        cars.parallelStream().forEach(car -> System.out.println("ArrayPosition: " + indexParallelStream.getAndIncrement() + "car.getLicence_plate() = " + car.getLicence_plate()));

        System.out.println("===========================");
        System.out.println("=========================== Peeking and sorting ===========================");
        System.out.println("===========================");
        cars.stream()
            .filter(Car::isElectric)
            .peek(electricCars -> System.out.println("electricCarUnsorted = " + electricCars.getBrand()))
            .sorted(Comparator.comparing(Car::getBrand))
            .forEach(car -> System.out.println("sortedCar = " + car.getBrand()));

        System.out.println("===========================");
        System.out.println("=========================== flatMap benefits directly stream all the owners of all cars ===========================");
        System.out.println("===========================");
        cars.stream()
                .flatMap(car -> car.getOwners().stream())
                .filter(owner -> owner.equalsIgnoreCase("Owner 1"))
                .forEach(owner -> System.out.println("owner = " + owner));

    }

}
