package java_tips.lambdas;

import java_tips.annotation.Bad;
import java_tips.annotation.Best;
import java_tips.annotation.Good;
import java_tips.model.Car;
import java_tips.model.Insurance;
import java_tips.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LambdaTips {

    @Bad
    public static List<Person> getPersonsWithInsurance(List<Person> persons) {
        return persons.stream()
                .filter(person -> {
                    Optional<Car> car = person.getCar();
                    if (car.isPresent()) {
                        Optional<Insurance> insurance = car.get().getInsurance();
                        return insurance.isPresent();
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    @Good
    public static List<Person> getPersonsWithInsurance2(List<Person> persons) {
        return persons.stream()
                .filter(LambdaTips::hasInsurance)
                .collect(Collectors.toList());
    }

    @Best
    public static List<Person> getPersonsWithInsurance3(List<Person> persons) {
        return persons.stream()
                .filter(Person::hasInsurance)
                .collect(Collectors.toList());
    }

    private static boolean hasInsurance(Person person) {
        return person.getCar()
                .flatMap(Car::getInsurance)
                .isPresent();
    }
}
