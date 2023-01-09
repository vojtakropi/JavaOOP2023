package du13.src.main.java;

public class BauerSkates extends SkatesDecorator{
    public BauerSkates(Skates skates) {
        super(skates);
    }

    @Override
    public void skating() {
        super.skating();
        System.out.println("na bauerach");
    }
}
