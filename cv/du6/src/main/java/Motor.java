package du6.src.main.java;

public class Motor {
    @Override
    public String toString() {
        return "Motor{" +
                "Palivo='" + Palivo + '\'' +
                ", Motor=" + Motor +
                '}';
    }

    private String Palivo;
    private double Motor;

    public double getMotor() {
        return Motor;
    }

    public String getPalivo() {
        return Palivo;
    }

    public Motor(String palivo, double motor){
        this.Palivo = palivo;
        this.Motor = motor;
    }

}
