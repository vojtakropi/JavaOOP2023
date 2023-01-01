package du5.src.main.java;

import java.util.Objects;

public class Nemoc {

    private String nazev;

    private int Smrtelnost;

    public Nemoc(String nazev, int smrtelnost) {
        this.nazev = nazev;
        Smrtelnost = smrtelnost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nemoc nemoc)) return false;
        return Smrtelnost == nemoc.Smrtelnost && Objects.equals(nazev, nemoc.nazev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazev, Smrtelnost);
    }

    @Override
    public String toString() {
        return "Nemoc{" +
                "nazev='" + nazev + '\'' +
                ", Smrtelnost=" + Smrtelnost +
                '}';
    }
}
