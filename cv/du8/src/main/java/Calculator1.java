package du8.src.main.java;

public class Calculator1 implements ICalculator{
    @Override
    public int sum(int a, int b) {
        return a+b;
    }

    @Override
    public int substract(int a, int b) {
        return a-b;
    }
}
