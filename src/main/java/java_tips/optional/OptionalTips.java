package java_tips.optional;

import java_tips.annotation.Bad;
import java_tips.annotation.Good;
import java_tips.model.Car;
import java_tips.model.Insurance;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import java_tips.model.Person;
import java.util.Optional;

@ParametersAreNonnullByDefault
public class OptionalTips {

    @Bad
    public static Car getCar(Person person) {
        if (person.getCar().isPresent()) {
            return person.getCar().get();
        }
        throw new IllegalArgumentException("Person hasn't a car");
    }

    @Good
    public static Car getCar2(Person person) {
        return person.getCar()
                .orElseThrow(() -> new IllegalArgumentException("Person hasn't a car"));
    }

    @Bad
    public static long getInsuranceNumber(Person person) {
        Optional<Car> car = person.getCar();
        if (car.isPresent()) {
            Optional<Insurance> insurance = car.get().getInsurance();
            if (insurance.isPresent()) {
                return insurance.get().getId();
            }
        }
        throw new IllegalArgumentException("No insurance");
    }

    @Good
    public static long getInsuranceNumber2(Person person) {
        return person.getCar()
                .flatMap(Car::getInsurance)
                .orElseThrow(() -> new IllegalArgumentException("No insurance"))
                .getId();
    }

    @Bad
    public static void registerCar(Person person) {
        if (person.getCar().isPresent()) {
            registerCar(person.getCar().get());
        }
    }

    @Good
    public static void registerCar2(Person person) {
        person.getCar().ifPresent(OptionalTips::registerCar);
    }

    @Bad
    public static Car rentCar(Optional<Person> person) {
        //stub
        // 1. rentCar(Optional.ofNullable(person))
        // 2. rentCar(Optional.empty())
        // 3. rentCar(Optional.of(person))
        if (person.isPresent()) {
            Optional<Car> car = person.get().getCar();
            if (car.isPresent()) {
                return car.get();
            }
        };
        return defaultRentalCar();
    }

    @Bad
    public static Car rentCar2(Optional<Person> person) {
        //stub
        // rentCar2(person)
        return person.flatMap(Person::getCar)
                .orElse(defaultRentalCar());
    }

    @Good
    public static Car rentCar3(@Nullable Person person) {
        return Optional.ofNullable(person)
                .flatMap(Person::getCar)
                .orElseGet(() -> defaultRentalCar());
    }

    private static Car defaultRentalCar() {
        System.out.println("Renting default ar...");
        return new Car("GMT", null);
    }

    private static void registerCar(Car car) {
        // stub
    }

    public static void main(String[] args) {
        Person p = new Person("Fred", 28, new Car("Brand", null));
        System.out.println(rentCar2(Optional.of(p)));
        System.out.println(rentCar3(p));
    }
}
