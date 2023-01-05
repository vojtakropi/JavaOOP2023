package du6.src.main.java;

import java.util.List;
import java.util.Objects;

public class Pacient {

    private List<Nemoc> nemoci;

    public Pacient(List<Nemoc> nemoci, String name, int vek) {
        this.nemoci = nemoci;
        this.name = name;
        this.vek = vek;
    }

    public List<Nemoc> getNemoci() {
        return nemoci;
    }

    public void setNemoci(List<Nemoc> nemoci) {
        this.nemoci = nemoci;
    }

    private String name;

    private int vek;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVek() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pacient pacient)) return false;
        return getVek() == pacient.getVek() && Objects.equals(getName(), pacient.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getVek());
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "name='" + name + '\'' +
                ", vek=" + vek +
                '}';
    }
}
