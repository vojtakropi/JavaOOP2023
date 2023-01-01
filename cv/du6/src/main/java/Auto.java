package du6.src.main.java;

public class Auto {

    private String Znacka;
    private Integer RokVyroby;
    private String Barva;
    private Motor motor;

    public Motor getMotor() {
        return motor;
    }

    public String getBarva() {
        return Barva;
    }

    public Integer getRokVyroby() {
        return RokVyroby;
    }

    public String getZnacka() {
        return Znacka;
    }

    public Auto(String znacka, Integer rokVyroby, String barva, Motor motor){
        this.Znacka = znacka;
        this.RokVyroby = rokVyroby;
        this.Barva = barva;
        this.motor = motor;

    }

    @Override
    public String toString() {
        return "Auto{" +
                "Znacka='" + Znacka + '\'' +
                ", RokVyroby=" + RokVyroby +
                ", Barva='" + Barva + '\'' +
                ", motor=" + motor +
                '}';
    }
}

