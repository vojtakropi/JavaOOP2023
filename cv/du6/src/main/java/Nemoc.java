package du6.src.main.java;

import java.util.Objects;

public class Nemoc {
    public Nemoc(String name, int daysToCure) {
        this.name = name;
        this.daysToCure = daysToCure;
    }

    private String name;

    private int daysToCure;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDaysToCure() {
        return daysToCure;
    }


    public void setDaysToCure(int daysToCure) {
        this.daysToCure = daysToCure;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nemoc nemoc)) return false;
        return getDaysToCure() == nemoc.getDaysToCure() && Objects.equals(getName(), nemoc.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDaysToCure());
    }

    @Override
    public String toString() {
        return "Nemoc{" +
                "name='" + name + '\'' +
                ", daysToCure=" + daysToCure +
                '}';
    }
}
