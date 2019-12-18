package java_tips.model;


import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import java.util.Objects;
import java.util.Optional;

@Immutable
@ParametersAreNonnullByDefault
public class Person {
    private final String name;
    private final int age;
    private final Car car;

    public Person(String name, int age, @Nullable Car car) {
        Objects.requireNonNull(name, "Name should be not null");
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Optional<Car> getCar() {
        return Optional.ofNullable(car);
    }

    public static boolean hasInsurance(Person person) {
        //stub
        return false;
    }
}
