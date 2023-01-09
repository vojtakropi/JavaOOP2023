package du13.src.main.java;

public class SkatesDecorator implements Skates {

    private final Skates skates;

    public SkatesDecorator(Skates skates) {
        this.skates = skates;
    }

    @Override
    public void skating() {
        this.skates.skating();
    }
}
