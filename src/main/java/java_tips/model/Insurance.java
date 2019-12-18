package java_tips.model;

import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public class Insurance {

    private final long id;

    public Insurance(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                '}';
    }
}
