package java_tips.model;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;

@Immutable
@ParametersAreNonnullByDefault
public class Car {

    private final String brand;
    private final Insurance insurance;

    public Car(String brand, @Nullable Insurance insurance) {
        this.brand = brand;
        this.insurance = insurance;
    }

    public String getBrand() {
        return brand;
    }

    public Optional<Insurance> getInsurance() {
        return Optional.ofNullable(insurance);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", insurance=" + insurance +
                '}';
    }
}
