package du5.src.main.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pacient {

    private String name;
    private String surname;
    private LocalDate dateofbirth;
    private int height;
    private int weight;
    private int idcardnumber;

    List<Nemoc> nemoci = new ArrayList<>();


    public Pacient(String name, String surname, LocalDate dateofbirth, int height, int weight, int idcardnumber, List<Nemoc> nemoci) {
        this.name = name;
        this.surname = surname;
        this.dateofbirth = dateofbirth;
        this.height = height;
        this.weight = weight;
        this.idcardnumber = idcardnumber;
        this.nemoci = nemoci;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getIdcardnumber() {
        return idcardnumber;
    }

    public List<Nemoc> getNemoci() {
        return nemoci;
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateofbirth=" + dateofbirth +
                ", height=" + height +
                ", weight=" + weight +
                ", idcardnumber=" + idcardnumber +
                ", nemoci=" + nemoci +
                '}';
    }
}
